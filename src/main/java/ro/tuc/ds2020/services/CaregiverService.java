package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.CaregiverDetailsDTO;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.dtos.builders.CaregiverBuilder;
import ro.tuc.ds2020.dtos.builders.MedicationBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.repositories.CaregiverRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CaregiverService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CaregiverService.class);
    private final CaregiverRepository caregiverRepository;

    @Autowired
    public CaregiverService(CaregiverRepository caregiverRepository) { this.caregiverRepository = caregiverRepository; }

    public List<CaregiverDTO> findCaregivers() {
        List<Caregiver> caregiverList = caregiverRepository.findAll();
        return caregiverList.stream()
                .map(CaregiverBuilder::toCaregiverDTO)
                .collect(Collectors.toList());
    }

    public UUID insert(CaregiverDetailsDTO caregiverDetailsDTO) {
        Caregiver caregiver = CaregiverBuilder.toEntity(caregiverDetailsDTO);
        caregiver = caregiverRepository.save(caregiver);
        LOGGER.debug("Caregiver with id {} was inserted in db", caregiver.getId());
        return caregiver.getId();
    }

    public CaregiverDetailsDTO findCaregiverById(UUID id){
        Optional<Caregiver> prosumerOptional = caregiverRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Caregiver with id {} was not found in db", id);
            throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with id: " + id);
        }
        return CaregiverBuilder.toCaregiverDetailsDTO(prosumerOptional.get());
    }

    public void deleteCaregiverByID(UUID id){
        Optional<Caregiver> optionalCaregiver = caregiverRepository.findById(id);
        if(optionalCaregiver.isPresent())
        {
            caregiverRepository.delete(optionalCaregiver.get());
        }
    }

    public CaregiverDetailsDTO deleteCaregiverByName(String name){
        Optional<Caregiver> optionalCaregiver = caregiverRepository.findByName(name);
        if(optionalCaregiver.isPresent())
        {
            caregiverRepository.delete(optionalCaregiver.get());
        }
        return CaregiverBuilder.toCaregiverDetailsDTO(optionalCaregiver.get());
    }

    public CaregiverDetailsDTO findCaregiverByName(String caregiverName){
        Optional<Caregiver> prosumerOptional = caregiverRepository.findByName(caregiverName);
        if(!prosumerOptional.isPresent()){
            LOGGER.error("Caregiver with NAME {} donest exist!",caregiverName);
        }
        return  CaregiverBuilder.toCaregiverDetailsDTO(prosumerOptional.get());
    }

    public UUID updateCaregiver(CaregiverDetailsDTO caregiverDetailsDTO){
        Optional<Caregiver> caregiverOptional = caregiverRepository.findById(caregiverDetailsDTO.getId());
        if(!caregiverOptional.isPresent())
        {
            throw new ResourceNotFoundException("Caregiver with id:"+caregiverDetailsDTO.getId()+" doesn't exist!");
        }else{

            CaregiverBuilder.updateEntity(caregiverDetailsDTO, caregiverOptional.get());
            caregiverRepository.save(caregiverOptional.get());

        }
        return caregiverOptional.get().getId();
    }
}

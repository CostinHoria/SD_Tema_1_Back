package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.dtos.builders.MedicationBuilder;
import ro.tuc.ds2020.dtos.builders.PersonBuilder;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.repositories.MedicationRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.prefs.Preferences;
import java.util.stream.Collectors;

@Service
public class MedicationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicationService.class);
    private final MedicationRepository medicationRepository;

    @Autowired
    public MedicationService(MedicationRepository medicationRepository){ this.medicationRepository = medicationRepository; }

    public List<MedicationDTO> findMedications() {
        List<Medication> medicationList = medicationRepository.findAll();
        return medicationList.stream()
                .map(MedicationBuilder::toMedicationDTO)
                .collect(Collectors.toList());
    }



    public UUID insert(MedicationDetailsDTO medicationDTO) {
        Medication medication = MedicationBuilder.toEntity(medicationDTO);
        medication = medicationRepository.save(medication);
        LOGGER.info("Medication with id {} was inserted in db", medication.getId());
        System.out.println("DADA");
        return medication.getId();
    }

    public MedicationDetailsDTO findMedicationByName(String name){
        Optional<Medication> prosumerOptional = medicationRepository.findByName(name);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Medication with name {} was not found in db", name);
            throw new ResourceNotFoundException(Medication.class.getSimpleName() + " with name: " + name);
        }
        System.out.println(prosumerOptional.toString());
        System.out.println("MERGE GET BY NAME");
        return MedicationBuilder.toMedicationDetailsDTO(prosumerOptional.get());
    }

    /*public String deleteMedicationByName(String name){
        MedicationDetailsDTO medicationDetailsDTO = findMedicationByName(name);
        System.out.println("ID MEDICAMENT :"+medicationDetailsDTO.getId());
        System.out.println("NUME :"+medicationDetailsDTO.getName());
        Medication medication = MedicationBuilder.toEntity(medicationDetailsDTO);
        medicationRepository.deleteById(medication.getId());
        LOGGER.debug("Medication with name {} was DELETED from db", name);
        return medication.getName();
    }*/
    public void deleteMedicationByID(UUID id){
        Optional<Medication> optionalMedication = medicationRepository.findById(id);
        if(optionalMedication.isPresent())
        {
            medicationRepository.delete(optionalMedication.get());
        }
    }

    public MedicationDetailsDTO deleteMedicationByName(String name){
        Optional<Medication> optionalMedication = medicationRepository.findByName(name);
        if(optionalMedication.isPresent())
        {
            medicationRepository.delete(optionalMedication.get());
        }

        return MedicationBuilder.toMedicationDetailsDTO(optionalMedication.get());
    }




    public MedicationDetailsDTO findMedicationById(UUID id){
        Optional<Medication> prosumerOptional = medicationRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("!!!!Medication with id {} was not found in db", id);
            throw new ResourceNotFoundException(Medication.class.getSimpleName() + " with id: " + id);
        }
        return MedicationBuilder.toMedicationDetailsDTO(prosumerOptional.get());
    }

    public UUID updateMedication(MedicationDetailsDTO medicationDetailsDTO){
        Optional<Medication> medicationOptional = medicationRepository.findById(medicationDetailsDTO.getId());
        if(!medicationOptional.isPresent())
        {
            throw new ResourceNotFoundException("Medication with id:"+medicationDetailsDTO.getId()+" doesn't exist!");
        }else{

            MedicationBuilder.updateEntity(medicationDetailsDTO, medicationOptional.get());
            medicationRepository.save(medicationOptional.get());

        }
        return medicationOptional.get().getId();
    }
}

package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.PatientDetailsDTO;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);
    private final PatientRepository PatientRepository;

    @Autowired
    public PatientService(PatientRepository PatientRepository) {
        this.PatientRepository = PatientRepository;
    }

    public List<PatientDTO> findPatients() {
        List<Patient> PatientList = PatientRepository.findAll();
        return PatientList.stream()
                .map(PatientBuilder::toPatientDTO)
                .collect(Collectors.toList());
    }

    public PatientDetailsDTO findPatientById(UUID id) {
        Optional<Patient> prosumerOptional = PatientRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Patient with id {} was not found in db", id);
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + id);
        }
        return PatientBuilder.toPatientDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(PatientDetailsDTO patientDTO) {
        Patient patient = PatientBuilder.toEntity(patientDTO);
        patient = PatientRepository.save(patient);
        LOGGER.debug("Patient with id {} was inserted in db", patient.getId());
        return patient.getId();
    }

    public PatientDetailsDTO deletePatientByName(String name){
        Optional<Patient> optionalPatient = PatientRepository.findByName(name);
        if(optionalPatient.isPresent())
        {
            PatientRepository.delete(optionalPatient.get());
        }

        return PatientBuilder.toPatientDetailsDTO(optionalPatient.get());
    }

    public UUID updatePatient(PatientDetailsDTO PatientDetailsDTO){
        Optional<Patient> PatientOptional = PatientRepository.findById(PatientDetailsDTO.getId());
        if(!PatientOptional.isPresent())
        {
            throw new ResourceNotFoundException("Patient with id:"+PatientDetailsDTO.getId()+" doesn't exist!");
        }else{

            PatientBuilder.updateEntity(PatientDetailsDTO, PatientOptional.get());
            PatientRepository.save(PatientOptional.get());

        }
        return PatientOptional.get().getId();
    }

    public List<Patient> findByCaregiver(String caregiverName){
        List<Patient> dtos = PatientRepository.findByCaregiverName(caregiverName);
        return dtos;
    }

}


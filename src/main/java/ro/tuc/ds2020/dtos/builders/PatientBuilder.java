package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.PatientDetailsDTO;
import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.Person;

public class PatientBuilder {

    private PatientBuilder() {
    }

    public static PatientDTO toPatientDTO(Patient patient) {
        return new PatientDTO(patient.getId(),
                patient.getName(),
                patient.getAddress(),
                patient.getAge(),
                patient.getGender(),
                patient.getUsername(),
                patient.getPassword(),
                patient.getCaregiverName());
    }

    public static PatientDetailsDTO toPatientDetailsDTO(Patient patient) {
        return new PatientDetailsDTO(patient.getId(),
                patient.getName(),
                patient.getAddress(),
                patient.getAge(),
                patient.getGender(),
                patient.getUsername(),
                patient.getPassword(),
                patient.getCaregiverName());
    }

    public static void updateEntity(PatientDetailsDTO patientDetailsDTO, Patient patient) {
        if(patientDetailsDTO != null && patient != null) {
            patient.setId(patientDetailsDTO.getId());
            patient.setName(patientDetailsDTO.getName());
            patient.setAddress(patientDetailsDTO.getAddress());
            patient.setAge(patientDetailsDTO.getAge());
            patient.setGender(patientDetailsDTO.getGender());
            patient.setUsername(patientDetailsDTO.getUsername());
            patient.setPassword(patientDetailsDTO.getPassword());
            patient.setCaregiverName(patientDetailsDTO.getCaregiverName());
        }
    }

    public static Patient toEntity(PatientDetailsDTO patientDetailsDTO){
        return new Patient(patientDetailsDTO.getId(),
                patientDetailsDTO.getName(),
                patientDetailsDTO.getAddress(),
                patientDetailsDTO.getAge(),
                patientDetailsDTO.getGender(),
                patientDetailsDTO.getUsername(),
                patientDetailsDTO.getPassword(),
                patientDetailsDTO.getCaregiverName());
    }
}

package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.CaregiverDetailsDTO;
import ro.tuc.ds2020.entities.Caregiver;

import javax.validation.constraints.Null;

public class CaregiverBuilder {

    public CaregiverBuilder() {
    }

    public static CaregiverDTO toCaregiverDTO(Caregiver caregiver){
        return new CaregiverDTO(caregiver.getId(),caregiver.getName(),caregiver.getEmail(),caregiver.getPassword());
    }

    public static CaregiverDetailsDTO toCaregiverDetailsDTO(Caregiver caregiver){
        return new CaregiverDetailsDTO(caregiver.getId(),caregiver.getName(),caregiver.getEmail(),caregiver.getPassword());
    }

    public static Caregiver toEntity(CaregiverDetailsDTO caregiverDetailsDTO){
        return new Caregiver(caregiverDetailsDTO.getId(),caregiverDetailsDTO.getName(),caregiverDetailsDTO.getEmail(),caregiverDetailsDTO.getPassword());
    }

    public static void updateEntity(CaregiverDetailsDTO caregiverDetailsDTO, Caregiver caregiver){
        if(caregiverDetailsDTO!= null && caregiver!=null){
            caregiver.setId(caregiverDetailsDTO.getId());
            caregiver.setName(caregiverDetailsDTO.getName());
            caregiver.setEmail(caregiverDetailsDTO.getEmail());
            caregiver.setPassword(caregiverDetailsDTO.getPassword());
        }
    }
}

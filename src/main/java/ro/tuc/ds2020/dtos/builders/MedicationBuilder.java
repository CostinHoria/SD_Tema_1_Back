package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.entities.Medication;

public class MedicationBuilder {

    public MedicationBuilder() {
    }

    public static MedicationDTO toMedicationDTO(Medication medication){
        return new MedicationDTO(medication.getId(), medication.getName(), medication.getDescription(), medication.getPrice());
    }

    public static MedicationDetailsDTO toMedicationDetailsDTO(Medication medication){
        return new MedicationDetailsDTO(medication.getId(), medication.getName(), medication.getDescription(), medication.getPrice());
    }

    public static Medication toEntity(MedicationDetailsDTO medicationDetailsDTO){
        return new Medication(medicationDetailsDTO.getId(), medicationDetailsDTO.getName(),
                medicationDetailsDTO.getDescription(),
                medicationDetailsDTO.getPrice());
    }

    public static void updateEntity(MedicationDetailsDTO medicationDetailsDTO, Medication medication){
        if(medicationDetailsDTO!=null && medication!=null) {
            medication.setId(medicationDetailsDTO.getId());
            medication.setName(medicationDetailsDTO.getName());
            medication.setDescription(medicationDetailsDTO.getDescription());
            medication.setPrice(medicationDetailsDTO.getPrice());
        }
    }
}

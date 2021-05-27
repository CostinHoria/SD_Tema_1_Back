package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.dtos.MedicationPlanDTO;
import ro.tuc.ds2020.dtos.MedicationPlanDetailsDTO;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.MedicationPlan;

public class MedicationPlanBuilder {

    public MedicationPlanBuilder() {
    }

    public static MedicationPlanDTO toMedicationPlanDTO(MedicationPlan medicationPlan){
        return new MedicationPlanDTO(medicationPlan.getId(), medicationPlan.getMedications_list(), medicationPlan.getPatient_name(), medicationPlan.getStart_dates(), medicationPlan.getEnd_dates(), medicationPlan.getAdministrations());
    }

    public static MedicationPlanDetailsDTO toMedicationPlanDetailsDTO(MedicationPlan medicationPlan){
        return new MedicationPlanDetailsDTO(medicationPlan.getId(), medicationPlan.getMedications_list(), medicationPlan.getPatient_name(), medicationPlan.getStart_dates(), medicationPlan.getEnd_dates(), medicationPlan.getAdministrations());
    }

    public static MedicationPlan toEntity(MedicationPlanDetailsDTO medicationPlanDetailsDTO){
        return new MedicationPlan(medicationPlanDetailsDTO.getId(), medicationPlanDetailsDTO.getMedications_list(), medicationPlanDetailsDTO.getPatient_name(), medicationPlanDetailsDTO.getStart_dates(), medicationPlanDetailsDTO.getEnd_dates(), medicationPlanDetailsDTO.getAdministrations());
    }

    public static void updateEntity(MedicationPlanDetailsDTO medicationPlanDetailsDTO, MedicationPlan medicationPlan){
        if(medicationPlanDetailsDTO!=null && medicationPlan!=null) {
            medicationPlan.setId(medicationPlanDetailsDTO.getId());
            medicationPlan.setMedications_list(medicationPlanDetailsDTO.getMedications_list());
            medicationPlan.setPatient_name(medicationPlanDetailsDTO.getPatient_name());
            medicationPlan.setStart_dates(medicationPlanDetailsDTO.getStart_dates());
            medicationPlan.setEnd_dates(medicationPlanDetailsDTO.getEnd_dates());
            medicationPlan.setAdministrations(medicationPlanDetailsDTO.getAdministrations());
        }
    }
}

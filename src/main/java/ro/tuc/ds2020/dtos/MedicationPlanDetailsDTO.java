package ro.tuc.ds2020.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class MedicationPlanDetailsDTO {

    private UUID id;
    @NotNull
    private String medications_list;
    @NotNull
    private String patient_name;
    @NotNull
    private String start_dates;
    @NotNull
    private String end_dates;
    @NotNull
    private String administrations;

    public MedicationPlanDetailsDTO() {
    }

    public MedicationPlanDetailsDTO(UUID id, String medications_list, String patient_name, String start_dates, String end_dates, String administrations) {
        this.id = id;
        this.medications_list = medications_list;
        this.patient_name = patient_name;
        this.start_dates = start_dates;
        this.end_dates = end_dates;
        this.administrations = administrations;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMedications_list() {
        return medications_list;
    }

    public void setMedications_list(String medications_list) {
        this.medications_list = medications_list;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getStart_dates() {
        return start_dates;
    }

    public void setStart_dates(String start_dates) {
        this.start_dates = start_dates;
    }

    public String getEnd_dates() {
        return end_dates;
    }

    public void setEnd_dates(String end_dates) {
        this.end_dates = end_dates;
    }

    public String getAdministrations() {
        return administrations;
    }

    public void setAdministrations(String administrations) {
        this.administrations = administrations;
    }
}

package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class MedicationPlan implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "medications_list", nullable = false)
    private String medications_list;

    @Column(name = "patient_name", nullable = false)
    private String patient_name;

    @Column(name = "start_dates", nullable = false)
    private String start_dates;

    @Column(name = "end_dates", nullable = false)
    private String end_dates;

    @Column(name = "administrations", nullable = false)
    private String administrations;

    public MedicationPlan(UUID id, String medications_list, String patient_name, String start_dates, String end_dates, String administrations) {
        this.id = id;
        this.medications_list = medications_list;
        this.patient_name = patient_name;
        this.start_dates = start_dates;
        this.end_dates = end_dates;
        this.administrations = administrations;
    }

    public MedicationPlan(String medications_list, String patient_name, String start_dates, String end_dates, String administrations) {
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

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }
}

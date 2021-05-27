package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class PrescripedDrug implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name_drug", nullable = false)
    private String name_drug;

    @Column(name = "start_date", nullable = false)
    private LocalDate start_date;

    @Column(name = "end_date", nullable = false)
    private LocalDate end_date;

    @Column(name = "administration", nullable = false)
    private String administration;

    public PrescripedDrug() {
    }

    public PrescripedDrug(UUID id, String name_drug, LocalDate start_date, LocalDate end_date, String administration) {
        this.id = id;
        this.name_drug = name_drug;
        this.start_date = start_date;
        this.end_date = end_date;
        this.administration = administration;
    }

    public PrescripedDrug(String name_drug, LocalDate start_date, LocalDate end_date, String administration) {
        this.name_drug = name_drug;
        this.start_date = start_date;
        this.end_date = end_date;
        this.administration = administration;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName_drug() {
        return name_drug;
    }

    public void setName_drug(String name_drug) {
        this.name_drug = name_drug;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public String getAdministration() {
        return administration;
    }

    public void setAdministration(String administration) {
        this.administration = administration;
    }
}

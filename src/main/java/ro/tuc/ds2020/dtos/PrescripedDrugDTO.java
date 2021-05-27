package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.UUID;

public class PrescripedDrugDTO extends RepresentationModel<PrescripedDrugDTO> {

    private UUID id;
    private String name_drug;
    private LocalDate start_date;
    private LocalDate end_date;
    private String administration;

    public PrescripedDrugDTO() {
    }

    public PrescripedDrugDTO(UUID id, String name_drug, LocalDate start_date, LocalDate end_date, String administration) {
        this.id = id;
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

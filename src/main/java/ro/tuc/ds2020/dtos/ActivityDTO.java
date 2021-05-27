package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.UUID;

public class ActivityDTO extends RepresentationModel<ActivityDTO> {

    private UUID id;
    private String name;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private UUID id_client;

    public ActivityDTO(UUID id, String name, LocalDateTime start_date, LocalDateTime end_date, UUID id_client) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.id_client = id_client;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDateTime start_date) {
        this.start_date = start_date;
    }

    public LocalDateTime getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDateTime end_date) {
        this.end_date = end_date;
    }

    public UUID getId_client() {
        return id_client;
    }

    public void setId_client(UUID id_client) {
        this.id_client = id_client;
    }
}

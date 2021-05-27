package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import java.util.Objects;
import java.util.UUID;

public class MedicationDTO extends RepresentationModel<MedicationDTO> {
    private UUID id;
    private String name;
    private String description;
    private float price;

    public MedicationDTO() {
    }

    public MedicationDTO(UUID id, String name, String description, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}

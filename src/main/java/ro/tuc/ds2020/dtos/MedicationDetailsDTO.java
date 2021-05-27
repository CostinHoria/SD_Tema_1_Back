package ro.tuc.ds2020.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class MedicationDetailsDTO {

    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private float price;

    public MedicationDetailsDTO() {
    }

    public MedicationDetailsDTO(UUID id, String name, String description, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public MedicationDetailsDTO(String name, String description, float price) {
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

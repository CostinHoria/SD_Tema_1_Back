package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;
import java.util.UUID;

public class DoctorDTO extends RepresentationModel<DoctorDTO> {
    private UUID id;
    private String name;
    private String email;

    public DoctorDTO() {
    }

    public DoctorDTO(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int hashCode() { return Objects.hash(name, email);}
}

package ro.tuc.ds2020.dtos;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public class CaregiverDetailsDTO {

    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

    public CaregiverDetailsDTO() {
    }

    public CaregiverDetailsDTO(@NotNull String name, @NotNull String email, @NotNull String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public CaregiverDetailsDTO(UUID id, @NotNull String name, @NotNull String email, @NotNull String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password);
    }
}

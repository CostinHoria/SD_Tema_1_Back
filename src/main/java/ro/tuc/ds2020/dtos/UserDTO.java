package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Column;
import java.util.Objects;
import java.util.UUID;

public class UserDTO extends RepresentationModel<UserDTO> {
    private UUID id;
    private UUID id_cont;
    private String username;
    private String password;
    private String user_type;

    public UserDTO() {
    }

    public UserDTO(UUID id, UUID id_cont, String username, String password, String user_type) {
        this.id = id;
        this.id_cont = id_cont;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId_cont() {
        return id_cont;
    }

    public void setId_cont(UUID id_cont) {
        this.id_cont = id_cont;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

}

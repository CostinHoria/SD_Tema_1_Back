package ro.tuc.ds2020.dtos;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UserDetailsDTO {
    private UUID id;
    @NotNull
    private UUID id_cont;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String user_type;

    public UserDetailsDTO() {
    }

    public UserDetailsDTO(UUID id_cont, String username, String password, String user_type) {
        this.id_cont = id_cont;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
    }

    public UserDetailsDTO(UUID id, UUID id_cont, String username, String password, String user_type) {
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

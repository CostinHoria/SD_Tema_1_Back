package ro.tuc.ds2020.dtos.builders;


import ro.tuc.ds2020.dtos.UserDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.entities.Users;

public class UserBuilder {

    public UserBuilder() {
    }

    public static UserDTO toUserDTO(Users users){
        return new UserDTO(users.getId(),
                users.getId_cont(),
                users.getUsername(),
                users.getPassword(),
                users.getUser_type());
    }

    public static UserDetailsDTO toUserDetailsDTO(Users user){
        return new UserDetailsDTO(user.getId(),
                user.getId_cont(),
                user.getUsername(),
                user.getPassword(),
                user.getUser_type());
    }

    public static Users toEntity(UserDetailsDTO userDetailsDTO){
        return new Users(userDetailsDTO.getId(),
                userDetailsDTO.getId_cont(),
                userDetailsDTO.getUsername(),
                userDetailsDTO.getPassword(),
                userDetailsDTO.getUser_type());
    }

    public static void updateEntity(UserDetailsDTO userDetailsDTO, Users user){
        if(userDetailsDTO!=null && user!=null) {
            user.setId(userDetailsDTO.getId());
            user.setId_cont(userDetailsDTO.getId_cont());
            user.setUsername(userDetailsDTO.getUsername());
            user.setPassword(userDetailsDTO.getPassword());
            user.setUser_type(userDetailsDTO.getUser_type());
        }
    }
}

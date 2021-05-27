package ro.tuc.ds2020.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.dtos.builders.UserBuilder;
import ro.tuc.ds2020.entities.Users;
import ro.tuc.ds2020.repositories.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicationService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){ this.userRepository = userRepository; }

    public UUID insert(UserDetailsDTO userDetailsDTO) {
        Users user = UserBuilder.toEntity(userDetailsDTO);
        user = userRepository.save(user);
        LOGGER.info("User with id {} was inserted in db", user.getId());
        System.out.println("DADA");
        return user.getId();
    }

    public UserDetailsDTO findByUsernameAndPassword(String username, String password){
        Optional<Users> prosumerOptional = userRepository.findByUsernameAndPassword(username, password);
        return UserBuilder.toUserDetailsDTO(prosumerOptional.get());
    }


}

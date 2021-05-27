package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.CaregiverDetailsDTO;
import ro.tuc.ds2020.dtos.UserDetailsDTO;
import ro.tuc.ds2020.services.CaregiverService;
import ro.tuc.ds2020.services.UserService;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) { this.userService = userService; }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody UserDetailsDTO userDetailsDTO) {
        UUID userID = userService.insert(userDetailsDTO);
        return new ResponseEntity<>(userID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{username}/{password}")
    public ResponseEntity<UserDetailsDTO> getUserTypeByUsernameAndPassword(@PathVariable("username") String username, @PathVariable("password") String password) {
        UserDetailsDTO dto = userService.findByUsernameAndPassword(username,password);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}

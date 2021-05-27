package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.CaregiverDetailsDTO;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.services.CaregiverService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/caregiver")
public class CaregiverController {
    private final CaregiverService caregiverService;

    @Autowired
    public CaregiverController(CaregiverService caregiverService) { this.caregiverService = caregiverService; }

    @GetMapping()
    public ResponseEntity<List<CaregiverDTO>> getCaregivers() {
        List<CaregiverDTO> dtos = caregiverService.findCaregivers();
        for (CaregiverDTO dto : dtos) {
            Link caregiverLink = linkTo(methodOn(CaregiverController.class)
                    .getCaregiver(dto.getId())).withRel("caregiverDetails");
            dto.add(caregiverLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody CaregiverDetailsDTO caregiverDetailsDTO) {
        UUID caregiverID = caregiverService.insert(caregiverDetailsDTO);
        return new ResponseEntity<>(caregiverID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CaregiverDetailsDTO> getCaregiver(@PathVariable("id") UUID caregiverId) {
        CaregiverDetailsDTO dto = caregiverService.findCaregiverById(caregiverId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<UUID> getCaregiverIdByName(@PathVariable("name") String nameCaregiver){
        CaregiverDetailsDTO dto = caregiverService.findCaregiverByName(nameCaregiver);
        UUID id = dto.getId();
        System.out.println("ID caregiver by NAME: "+id);
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<UUID> deleteCaregiver(@PathVariable("id") UUID caregiverID) {
        System.out.println("ID caregiver DELETED: "+caregiverID);
        caregiverService.deleteCaregiverByID(caregiverID);
        return new ResponseEntity<>(caregiverID,HttpStatus.OK);
    }*/

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<CaregiverDetailsDTO> deleteCaregiver(@PathVariable("name") String caregiverName) {
        System.out.println("ID caregiver DELETED: "+caregiverName);
        CaregiverDetailsDTO dto = caregiverService.deleteCaregiverByName(caregiverName);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UUID> updateCaregiver(@RequestBody CaregiverDetailsDTO caregiverDetailsDTO){
        UUID resultID = caregiverService.updateCaregiver(caregiverDetailsDTO);
        return new ResponseEntity<>(resultID,HttpStatus.CREATED);
    }

}

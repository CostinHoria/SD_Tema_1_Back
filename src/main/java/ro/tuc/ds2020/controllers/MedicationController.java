package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.services.MedicationService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/medication")
public class MedicationController {
    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) { this.medicationService = medicationService; }

    @GetMapping()
    public ResponseEntity<List<MedicationDTO>> getMedications() {
        List<MedicationDTO> dtos = medicationService.findMedications();
        for (MedicationDTO dto : dtos) {
            Link medicationLink = linkTo(methodOn(MedicationController.class)
                    .getMedication(dto.getId())).withRel("medicationDetails");
            dto.add(medicationLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody MedicationDetailsDTO medicationDTO) {
        UUID medicationID = medicationService.insert(medicationDTO);
        return new ResponseEntity<>(medicationID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicationDetailsDTO> getMedication(@PathVariable("id") UUID medicationId) {
        MedicationDetailsDTO dto = medicationService.findMedicationById(medicationId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{name}")
    public ResponseEntity<MedicationDetailsDTO> getMedicationByName(@PathVariable("name") String medicationName) {
        MedicationDetailsDTO dto = medicationService.findMedicationByName(medicationName);
        return  new ResponseEntity<>(dto,HttpStatus.OK);
    }

    /*@DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteMedication(@PathVariable("name") String medicationName) {
        System.out.println("Nume med: "+medicationName);
        medicationService.deleteMedicationByName(medicationName);
        return new ResponseEntity<>(medicationName,HttpStatus.OK);
    }*/

    /*@DeleteMapping("/delete/{id}")
    public ResponseEntity<UUID> deleteMedication(@PathVariable("id") UUID medicationID) {
        System.out.println("ID med: "+medicationID);
        medicationService.deleteMedicationByID(medicationID);
        return new ResponseEntity<>(medicationID,HttpStatus.OK);
    }*/

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<MedicationDetailsDTO> deleteMedication(@PathVariable("name") String medicationName) {
        System.out.println("NAME med: "+medicationName);
        MedicationDetailsDTO dto = medicationService.deleteMedicationByName(medicationName);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UUID> updateMedication(@RequestBody MedicationDetailsDTO medicationDetailsDTO){
        UUID resultID = medicationService.updateMedication(medicationDetailsDTO);
        return new ResponseEntity<>(resultID,HttpStatus.CREATED);
    }

}

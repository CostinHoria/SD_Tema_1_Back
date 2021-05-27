package ro.tuc.ds2020.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.dtos.MedicationPlanDTO;
import ro.tuc.ds2020.dtos.MedicationPlanDetailsDTO;
import ro.tuc.ds2020.entities.MedicationPlan;
import ro.tuc.ds2020.services.MedicationPlanService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/medicationPlan")
public class MedicationPlanController {
    private final MedicationPlanService medicationPlanService;

    @Autowired
    public MedicationPlanController(MedicationPlanService medicationPlanService) {
        this.medicationPlanService = medicationPlanService;
    }

    /*@GetMapping(value = "/{name}")
    public ResponseEntity<MedicationPlanDetailsDTO> getMedicationPlan(@PathVariable("name") String patient_name) {
        MedicationPlanDetailsDTO dto = medicationPlanService.findMedicationPlanByPatientName(patient_name);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/get/{patientName}")
    public ResponseEntity<List<MedicationPlanDTO>> getMedicationsByPatientName(@PathVariable("name") String patient_name) {
        List<MedicationPlanDTO> dtos = medicationPlanService.findMedicationPlansByPatientName(patient_name);
        for (MedicationPlanDTO dto : dtos) {
            Link medicationLink = linkTo(methodOn(MedicationPlanController.class)
                    .getMedicationPlan(dto.getPatient_name())).withRel("medicationPlanDetails");
            dto.add(medicationLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }*/

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody MedicationPlanDetailsDTO medicationPlanDetailsDTO) {
        UUID medicationPlanID = medicationPlanService.insert(medicationPlanDetailsDTO);
        return new ResponseEntity<>(medicationPlanID, HttpStatus.CREATED);
    }
}

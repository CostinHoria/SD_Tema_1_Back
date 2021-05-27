package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.dtos.PrescripedDrugDTO;
import ro.tuc.ds2020.dtos.PrescripedDrugDetailsDTO;
import ro.tuc.ds2020.services.PrescripedDrugService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/prescriptedDrug")
public class PrescriptedDrugController {
    private final PrescripedDrugService prescripedDrugService;

    @Autowired
    public PrescriptedDrugController(PrescripedDrugService prescripedDrugService) {
        this.prescripedDrugService = prescripedDrugService;
    }

    @GetMapping()
    public ResponseEntity<List<PrescripedDrugDTO>> getPrescriptedDrugs() {
        List<PrescripedDrugDTO> dtos = prescripedDrugService.findPrescriptedDrugs();
        for (PrescripedDrugDTO dto : dtos) {
            Link prescriptedDrugLink = linkTo(methodOn(PrescriptedDrugController.class)
                    .getPrescriptedDrug(dto.getId())).withRel("prescriptedDrugDetails");
            dto.add(prescriptedDrugLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody PrescripedDrugDetailsDTO prescripedDrugDetailsDTO) {
        UUID prescripteddrugID = prescripedDrugService.insert(prescripedDrugDetailsDTO);
        return new ResponseEntity<>(prescripteddrugID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PrescripedDrugDetailsDTO> getPrescriptedDrug(@PathVariable("id") UUID prescriptedDrugID) {
        PrescripedDrugDetailsDTO dto = prescripedDrugService.findPrescriptedDrugById(prescriptedDrugID);
        System.out.println(dto.toString());
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}

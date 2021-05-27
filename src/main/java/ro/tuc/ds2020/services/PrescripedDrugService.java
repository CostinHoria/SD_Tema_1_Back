package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.dtos.PrescripedDrugDTO;
import ro.tuc.ds2020.dtos.PrescripedDrugDetailsDTO;
import ro.tuc.ds2020.dtos.builders.MedicationBuilder;
import ro.tuc.ds2020.dtos.builders.PrescriptedDrugBuilder;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.PrescripedDrug;
import ro.tuc.ds2020.repositories.PrescripedDrugRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PrescripedDrugService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicationService.class);
    private final PrescripedDrugRepository prescripedDrugRepository;

    @Autowired
    public PrescripedDrugService(PrescripedDrugRepository prescripedDrugRepository) {
        this.prescripedDrugRepository = prescripedDrugRepository;
    }

    public List<PrescripedDrugDTO> findPrescriptedDrugs(){
        List<PrescripedDrug> prescripedDrugList = prescripedDrugRepository.findAll();
        return prescripedDrugList.stream()
                .map(PrescriptedDrugBuilder::toPrescritpedDrugDTO)
                .collect(Collectors.toList());
    }

    public UUID insert(PrescripedDrugDetailsDTO prescripedDrugDetailsDTO) {
        PrescripedDrug prescripedDrug = PrescriptedDrugBuilder.toEntity(prescripedDrugDetailsDTO);
        prescripedDrug = prescripedDrugRepository.save(prescripedDrug);
        LOGGER.info("PrescriptedDrug with id {} was inserted in db", prescripedDrug.getId());
        System.out.println("DADA");
        return prescripedDrug.getId();
    }

    public PrescripedDrugDetailsDTO findPrescriptedDrugById(UUID id){
        Optional<PrescripedDrug> prosumerOptional = prescripedDrugRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("!!!!PrescriptedDrug with id {} was not found in db", id);
            throw new ResourceNotFoundException(PrescripedDrug.class.getSimpleName() + " with id: " + id);
        }
        return PrescriptedDrugBuilder.toPrescriptedDrugDetailsDTO(prosumerOptional.get());
    }
}

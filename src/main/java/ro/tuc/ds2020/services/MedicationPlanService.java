package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.*;
import ro.tuc.ds2020.dtos.builders.MedicationBuilder;
import ro.tuc.ds2020.dtos.builders.MedicationPlanBuilder;
import ro.tuc.ds2020.dtos.builders.PersonBuilder;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.MedicationPlan;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.repositories.MedicationPlanRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicationPlanService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicationPlanService.class);
    private final MedicationPlanRepository medicationPlanRepository;

    @Autowired
    public MedicationPlanService(MedicationPlanRepository medicationPlanRepository) { this.medicationPlanRepository = medicationPlanRepository; }

    public List<MedicationPlanDTO> findMedicationPlans() {
        List<MedicationPlan> medicationPlanList = medicationPlanRepository.findAll();
        return medicationPlanList.stream()
                .map(MedicationPlanBuilder::toMedicationPlanDTO)
                .collect(Collectors.toList());
    }

    public UUID insert(MedicationPlanDetailsDTO medicationPlanDetailsDTO) {
        MedicationPlan medicationPlan = MedicationPlanBuilder.toEntity(medicationPlanDetailsDTO);
        medicationPlan = medicationPlanRepository.save(medicationPlan);
        LOGGER.info("Medication PLAN with ID {}  and PATIENT NAME {} was inserted in db", medicationPlan.getId(), medicationPlan.getPatient_name());
        System.out.println("DA DA LA MEDICATION PLAN");
        return medicationPlan.getId();
    }

    public MedicationPlanDetailsDTO findMedicationPlanById(UUID id)
    {
        Optional<MedicationPlan> prosumerOptional = medicationPlanRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("!!!!Medication with id {} was not found in db", id);
            throw new ResourceNotFoundException(MedicationPlan.class.getSimpleName() + " with id: " + id);
        }
        return MedicationPlanBuilder.toMedicationPlanDetailsDTO(prosumerOptional.get());
    }

    public UUID addDrugToMedicationPlan(MedicationPlan medicationPlan, PrescripedDrugDetailsDTO prescripedDrugDetailsDTO){


        String medicationPlan_Medications_List = medicationPlan.getMedications_list();
        medicationPlan.setMedications_list(medicationPlan_Medications_List + prescripedDrugDetailsDTO.getName_drug() + ",");

        String medicationPlan_StartDates = medicationPlan.getStart_dates();
        medicationPlan.setStart_dates(medicationPlan_StartDates + prescripedDrugDetailsDTO.getStart_date() + ",");

        String medicationPlan_EndDates = medicationPlan.getEnd_dates();
        medicationPlan.setEnd_dates(medicationPlan_EndDates + prescripedDrugDetailsDTO.getEnd_date() + ",");

        String medicationPlan_Administrations = medicationPlan.getAdministrations();
        medicationPlan.setAdministrations(medicationPlan_Administrations + prescripedDrugDetailsDTO.getAdministration() + ",");

        LOGGER.info(medicationPlan.toString());

        return medicationPlan.getId();
    }

    /*public MedicationPlanDetailsDTO findMedicationPlanByPatientName(String patientName){
        Optional<MedicationPlan> prosumerOptional = medicationPlanRepository.findByPatientName(patientName);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Medication Plan with PATIENT NAME {} was not found in db", patientName);
            throw new ResourceNotFoundException(MedicationPlan.class.getSimpleName() + " with PatientName: " + patientName);
        }
        return MedicationPlanBuilder.toMedicationPlanDetailsDTO(prosumerOptional.get());
    }

    public List<MedicationPlanDTO> findMedicationPlansByPatientName(String patientName) {
        List<MedicationPlan> medicationPlanList = medicationPlanRepository.findMedicationPlansByName(patientName);
        return medicationPlanList.stream()
                .map(MedicationPlanBuilder::toMedicationPlanDTO)
                .collect(Collectors.toList());
    }*/


}

package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.MedicationDTO;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.dtos.builders.MedicationBuilder;
import ro.tuc.ds2020.dtos.builders.PersonBuilder;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.repositories.MedicationRepository;
import ro.tuc.ds2020.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorService.class);
    private final MedicationRepository medicationRepository;
    private final PersonRepository personRepository;

    @Autowired
    public DoctorService(PersonRepository personRepository, MedicationRepository medicationRepository)
    {
        this.personRepository = personRepository;
        this.medicationRepository = medicationRepository;
    }

    public List<PersonDTO> findPersons() {
        List<Person> personList = personRepository.findAll();
        return personList.stream()
                .map(PersonBuilder::toPersonDTO)
                .collect(Collectors.toList());
    }

    public PersonDetailsDTO findPersonById(UUID id) {
        Optional<Person> prosumerOptional = personRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Person with id {} was not found in db", id);
            throw new ResourceNotFoundException(Person.class.getSimpleName() + " with id: " + id);
        }
        return PersonBuilder.toPersonDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(PersonDetailsDTO personDTO) {
        Person person = PersonBuilder.toEntity(personDTO);
        person = personRepository.save(person);
        LOGGER.debug("Person with id {} was inserted in db", person.getId());
        return person.getId();
    }

    public List<MedicationDTO> findMedications() {
        List<Medication> medicationList = medicationRepository.findAll();
        return medicationList.stream()
                .map(MedicationBuilder::toMedicationDTO)
                .collect(Collectors.toList());
    }



    public UUID insert(MedicationDetailsDTO medicationDTO) {
        Medication medication = MedicationBuilder.toEntity(medicationDTO);
        medication = medicationRepository.save(medication);
        LOGGER.debug("Medication with id {} was inserted in db", medication.getId());
        return medication.getId();
    }

    /*public Medication deleteByID(MedicationDetailsDTO medicationDTO){
        Medication medication = MedicationBuilder.toEntity((medicationDTO));
        medicationRepository.deleteById(medication.getId());
        LOGGER.debug("Medication with id {} was DELETED from db", medication.getId());
        return medication;
    }*/

    public void deleteByID(UUID id){
        //Medication medication = MedicationBuilder.toEntity((medicationDTO));
        medicationRepository.deleteById(id);
        LOGGER.debug("Medication with id {} was DELETED from db", id);
        //return medication;
    }

    public MedicationDetailsDTO findMedicationById(UUID id){
        Optional<Medication> prosumerOptional = medicationRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Medication with id {} was not found in db", id);
            throw new ResourceNotFoundException(Medication.class.getSimpleName() + " with id: " + id);
        }
        return MedicationBuilder.toMedicationDetailsDTO(prosumerOptional.get());
    }
}

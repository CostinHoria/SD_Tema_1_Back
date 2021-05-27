package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.MedicationDetailsDTO;
import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.dtos.builders.MedicationBuilder;
import ro.tuc.ds2020.dtos.builders.PersonBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Medication;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
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

    public PersonDetailsDTO deletePersonByName(String name){
        Optional<Person> optionalPerson = personRepository.findByName(name);
        if(optionalPerson.isPresent())
        {
            personRepository.delete(optionalPerson.get());
        }

        return PersonBuilder.toPersonDetailsDTO(optionalPerson.get());
    }

    public UUID updatePerson(PersonDetailsDTO personDetailsDTO){
        Optional<Person> personOptional = personRepository.findById(personDetailsDTO.getId());
        if(!personOptional.isPresent())
        {
            throw new ResourceNotFoundException("Person with id:"+personDetailsDTO.getId()+" doesn't exist!");
        }else{

            PersonBuilder.updateEntity(personDetailsDTO, personOptional.get());
            personRepository.save(personOptional.get());

        }
        return personOptional.get().getId();
    }

    public List<PersonDTO> findByCaregiver(String caregiver_name){
        List<PersonDTO> dtos = personRepository.findByCaregiverName(caregiver_name);
        return dtos;
    }

}

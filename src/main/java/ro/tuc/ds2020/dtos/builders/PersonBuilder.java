package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.entities.Person;

public class PersonBuilder {

    private PersonBuilder() {
    }

    public static PersonDTO toPersonDTO(Person person) {
        return new PersonDTO(person.getId(),
                person.getName(),
                person.getAddress(),
                person.getAge(),
                person.getGender(),
                person.getUsername(),
                person.getPassword(),
                person.getCaregiverName());
    }

    public static PersonDetailsDTO toPersonDetailsDTO(Person person) {
        return new PersonDetailsDTO(person.getId(),
                person.getName(),
                person.getAddress(),
                person.getAge(),
                person.getGender(),
                person.getUsername(),
                person.getPassword(),
                person.getCaregiverName());
    }

    public static void updateEntity(PersonDetailsDTO personDetailsDTO, Person person) {
        if(personDetailsDTO != null && person != null) {
            person.setId(personDetailsDTO.getId());
            person.setName(personDetailsDTO.getName());
            person.setAddress(personDetailsDTO.getAddress());
            person.setAge(personDetailsDTO.getAge());
            person.setGender(personDetailsDTO.getGender());
            person.setUsername(personDetailsDTO.getUsername());
            person.setPassword(personDetailsDTO.getPassword());
            person.setCaregiverName(personDetailsDTO.getCaregiverName());
        }
    }

    public static Person toEntity(PersonDetailsDTO personDetailsDTO){
        return new Person(personDetailsDTO.getId(),
        personDetailsDTO.getName(),
        personDetailsDTO.getAddress(),
        personDetailsDTO.getAge(),
        personDetailsDTO.getGender(),
        personDetailsDTO.getUsername(),
        personDetailsDTO.getPassword(),
        personDetailsDTO.getCaregiverName());
    }
}

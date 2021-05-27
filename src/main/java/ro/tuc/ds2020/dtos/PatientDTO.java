package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;
import java.util.UUID;



    public class PatientDTO extends RepresentationModel<PatientDTO> {
        private UUID id;
        private String name;
        private String address;
        private int age;
        private String gender;
        private String username;
        private String password;
        private String caregiverName;

        public PatientDTO() {
        }

        public PatientDTO(UUID id, String name, String address, int age, String gender, String username, String password, String caregiverName) {
            this.id = id;
            this.name = name;
            this.address = address;
            this.age = age;
            this.gender = gender;
            this.username = username;
            this.password = password;
            this.caregiverName = caregiverName;
        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getCaregiverName() {
            return caregiverName;
        }

        public void setCaregiverName(String caregiverName) {
            this.caregiverName = caregiverName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
           PatientDTO patientDTO = (PatientDTO) o;
            return age == patientDTO.age &&
                    Objects.equals(name, patientDTO.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

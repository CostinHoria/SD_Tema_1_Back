package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

    @Entity
    public class Patient  implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Type(type = "uuid-binary")
        private UUID id;

        @Column(name = "name", nullable = false)
        private String name;

        @Column(name = "address", nullable = false)
        private String address;

        @Column(name = "age", nullable = false)
        private int age;

        @Column(name = "gender", nullable = false)
        private String gender;

        @Column(name = "username", nullable = false)
        private String username;

        @Column(name = "password", nullable = false)
        private String password;

        @Column(name = "caregiverName", nullable = false)
        private String caregiverName;


        public Patient() {
        }

        public Patient(UUID id, String name, String address, int age, String gender, String username, String password, String caregiverName) {
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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCaregiverName() {
            return caregiverName;
        }

        public void setCaregiverName(String caregiverName) {
            this.caregiverName = caregiverName;
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
    }

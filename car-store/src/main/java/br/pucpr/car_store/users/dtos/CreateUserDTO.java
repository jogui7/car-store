package br.pucpr.car_store.users.dtos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.pucpr.car_store.users.entities.User;

public class CreateUserDTO {
    
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public static User toEntity(CreateUserDTO createUserDTO) {
        
        createUserDTO.setPassword(new BCryptPasswordEncoder()
        .encode(createUserDTO.getPassword()));

        return new User(
            createUserDTO.email, 
            createUserDTO.password, 
            createUserDTO.firstName, 
            createUserDTO.lastName
        );
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

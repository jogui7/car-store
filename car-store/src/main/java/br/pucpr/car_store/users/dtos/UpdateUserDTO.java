package br.pucpr.car_store.users.dtos;

import br.pucpr.car_store.users.entities.User;

public class UpdateUserDTO {
    private String email;
    private String firstName;
    private String lastName;

    public static User toEntity(User user, UpdateUserDTO updateUserDTO) {
        if(updateUserDTO.getEmail() != null) {
            user.setEmail(updateUserDTO.getEmail());
        }

        if(updateUserDTO.getFirstName() != null) {
            user.setFirstName(updateUserDTO.getFirstName());
        }

        if(updateUserDTO.getLastName() != null) {
            user.setLastName(updateUserDTO.getLastName());
        }

        return user;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
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

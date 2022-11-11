package br.pucpr.customers.dtos;

import br.pucpr.customers.entities.Customer;

public class UpdateCustomerDTO {
    private String firstName;
    private String lastName;
    private String cpfCnpj;
    private String email;
    private String phone;

    public static Customer toEntity(Customer customer, UpdateCustomerDTO updateCustomerDTO) {
        if(updateCustomerDTO.getCpfCnpj() != null) {
            customer.setCpfCnpj(updateCustomerDTO.getCpfCnpj());
        }

        if (updateCustomerDTO.getEmail() != null) {
            customer.setEmail(updateCustomerDTO.getEmail());
        }

        if (updateCustomerDTO.getFirstName() != null) {
            customer.setFirstName(updateCustomerDTO.getFirstName());
        }

        if (updateCustomerDTO.getLastName() != null) {
            customer.setLastName(updateCustomerDTO.getLastName());
        }

        if (updateCustomerDTO.getPhone() != null) {
            customer.setPhone(updateCustomerDTO.getPhone());
        }

        return customer;
    }

    public UpdateCustomerDTO() {
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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

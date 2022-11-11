package br.pucpr.customers.dtos;

import br.pucpr.customers.entities.Customer;

public class CreateCustomerDTO {
    private String firstName;
    private String lastName;
    private String cpfCnpj;
    private String email;
    private String phone;

    public static Customer toEntity(CreateCustomerDTO createCustomerDTO) {
        Customer customer = new Customer();

        customer.setCpfCnpj(createCustomerDTO.getCpfCnpj());
        customer.setEmail(createCustomerDTO.getEmail());
        customer.setFirstName(createCustomerDTO.getFirstName());
        customer.setLastName(createCustomerDTO.getLastName());
        customer.setPhone(createCustomerDTO.getPhone());

        return customer;
    }

    public CreateCustomerDTO() {
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

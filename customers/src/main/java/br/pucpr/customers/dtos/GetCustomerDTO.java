package br.pucpr.customers.dtos;

import br.pucpr.customers.entities.Customer;

public class GetCustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String cpfCnpj;
    private String email;
    private String phone;

    public static GetCustomerDTO toDTO(Customer customer) {
        GetCustomerDTO getCustomerDTO = new GetCustomerDTO();

        getCustomerDTO.setId(customer.getId());
        getCustomerDTO.setCpfCnpj(customer.getCpfCnpj());
        getCustomerDTO.setEmail(customer.getEmail());
        getCustomerDTO.setFirstName(customer.getFirstName());
        getCustomerDTO.setLastName(customer.getLastName());
        getCustomerDTO.setPhone(customer.getPhone());

        return getCustomerDTO;
    }

    public GetCustomerDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

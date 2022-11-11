package br.pucpr.car_store.sales.dtos;

import java.sql.Date;

import br.pucpr.car_store.cars.dtos.GetCarDTO;
import br.pucpr.car_store.customers.dtos.GetCustomerDTO;

public class GetSaleDTO {
    private Long id;
    private GetCustomerDTO customer;
    private GetCarDTO car;
    private String paymentMethod;
    private Date saleDate;
    
    public GetSaleDTO() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public GetCustomerDTO getCustomer() {
        return customer;
    }
    public void setCustomer(GetCustomerDTO customer) {
        this.customer = customer;
    }
    public GetCarDTO getCar() {
        return car;
    }
    public void setCar(GetCarDTO car) {
        this.car = car;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public Date getSaleDate() {
        return saleDate;
    }
    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }
}

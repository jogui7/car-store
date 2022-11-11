package br.pucpr.sales.sales.dtos;

import java.sql.Date;
import br.pucpr.sales.sales.entities.Sale;

public class CreateSaleDTO {
    private Long customerId;
    private Long carId;
    private String paymentMethod;

    public static Sale toEntity(CreateSaleDTO createSaleDTO) {
        Sale sale = new Sale();

        sale.setCarId(createSaleDTO.getCarId());
        sale.setCustomerId(createSaleDTO.getCustomerId());
        sale.setPaymentMethod(createSaleDTO.getPaymentMethod());
        sale.setSaleDate(new Date(System.currentTimeMillis()));

        return sale;
    }

    public CreateSaleDTO() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

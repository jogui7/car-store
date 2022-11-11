package br.pucpr.sales.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucpr.sales.cars.clients.CarsClient;
import br.pucpr.sales.cars.dtos.GetCarDTO;
import br.pucpr.sales.customers.clients.CustomersClient;
import br.pucpr.sales.customers.dtos.GetCustomerDTO;
import br.pucpr.sales.sales.dtos.GetSaleDTO;
import br.pucpr.sales.sales.entities.Sale;

@Service
public class SaleTranslator {
    @Autowired
    private CarsClient carsClient;
    
    @Autowired
    private CustomersClient customersClient;

    public GetSaleDTO toDTO(Sale sale) {
        GetCarDTO carDTO = this.carsClient.getById(sale.getCarId());
        GetCustomerDTO customerDTO = this.customersClient.getById(sale.getCustomerId());

        GetSaleDTO getSaleDTO = new GetSaleDTO();

        getSaleDTO.setId(sale.getId());
        getSaleDTO.setPaymentMethod(sale.getPaymentMethod());
        getSaleDTO.setSaleDate(sale.getSaleDate());
        getSaleDTO.setCar(carDTO);
        getSaleDTO.setCustomer(customerDTO);

        return getSaleDTO;
    }
}

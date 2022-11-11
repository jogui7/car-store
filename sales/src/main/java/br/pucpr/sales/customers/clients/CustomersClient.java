package br.pucpr.sales.customers.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.pucpr.sales.customers.dtos.GetCustomerDTO;

@FeignClient(value = "customersService", url = "http://localhost:8082/customers")
public interface CustomersClient {
    
    @GetMapping("/{id}")
    GetCustomerDTO getById(@PathVariable("id") Long id);
}

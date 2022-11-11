package br.pucpr.car_store.customers.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.pucpr.car_store.customers.dtos.CreateOrUpdateCustomerDTO;
import br.pucpr.car_store.customers.dtos.GetCustomerDTO;

@FeignClient(value = "customersService", url = "http://localhost:8082/customers")
public interface CustomersClient {
    @GetMapping
    List<GetCustomerDTO> list();

    @GetMapping("/{id}")
    GetCustomerDTO getById(@PathVariable("id") Long id);

    @PostMapping
    GetCustomerDTO create(@RequestBody CreateOrUpdateCustomerDTO createCustomerDTO);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    GetCustomerDTO update(@PathVariable("id") Long id, @RequestBody CreateOrUpdateCustomerDTO updateCustomerDTO);
}

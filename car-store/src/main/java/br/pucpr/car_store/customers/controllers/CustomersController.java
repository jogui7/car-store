package br.pucpr.car_store.customers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucpr.car_store.customers.clients.CustomersClient;
import br.pucpr.car_store.customers.dtos.CreateOrUpdateCustomerDTO;
import br.pucpr.car_store.customers.dtos.GetCustomerDTO;

@RestController
@RequestMapping("/customers")
public class CustomersController {
    @Autowired
    CustomersClient customersClient;

    @GetMapping
    List<GetCustomerDTO> list() {
        return this.customersClient.list();
    };

    @GetMapping("/{id}")
    GetCustomerDTO getById(@PathVariable("id") Long id) {
        return this.customersClient.getById(id);
    }

    @PostMapping
    GetCustomerDTO create(@RequestBody CreateOrUpdateCustomerDTO createCustomerDTO) {
        return this.customersClient.create(createCustomerDTO);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id) {
        this.customersClient.deleteById(id);
    }

    @PutMapping("/{id}")
    GetCustomerDTO update(
        @PathVariable("id") Long id, 
        @RequestBody CreateOrUpdateCustomerDTO updateCustomerDTO
    ) {
        return this.customersClient.update(id, updateCustomerDTO);
    }
}

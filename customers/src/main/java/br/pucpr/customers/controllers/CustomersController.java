package br.pucpr.customers.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucpr.customers.dtos.CreateCustomerDTO;
import br.pucpr.customers.dtos.GetCustomerDTO;
import br.pucpr.customers.dtos.UpdateCustomerDTO;
import br.pucpr.customers.entities.Customer;
import br.pucpr.customers.services.CustomersService;

@RestController
@RequestMapping("/customers")
@EnableAutoConfiguration
public class CustomersController {
    @Autowired
    CustomersService customersService;

    @GetMapping("/{id}")
    GetCustomerDTO getById(@PathVariable("id") Long id) {
        return GetCustomerDTO.toDTO(this.customersService.getById(id));
    }
    
    @GetMapping 
    List<GetCustomerDTO> list() {
        List<Customer> cars = this.customersService.list();

        List<GetCustomerDTO> getCustomerDTOs = new ArrayList<GetCustomerDTO>();
        cars.forEach(car -> getCustomerDTOs.add(GetCustomerDTO.toDTO(car)));

        return getCustomerDTOs;
    }

    @PostMapping
    GetCustomerDTO create(@RequestBody CreateCustomerDTO createCustomerDTO) {
        return GetCustomerDTO.toDTO(this.customersService.save(CreateCustomerDTO.toEntity(createCustomerDTO)));
    }

    @PutMapping("/{id}")
    GetCustomerDTO update(@PathVariable("id") Long id, @RequestBody UpdateCustomerDTO updateCustomerDTO) {
        Customer car = this.customersService.getById(id);
        return GetCustomerDTO.toDTO(this.customersService.save(UpdateCustomerDTO.toEntity(car, updateCustomerDTO)));
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id) {
        this.customersService.deleteById(id);
    }
}

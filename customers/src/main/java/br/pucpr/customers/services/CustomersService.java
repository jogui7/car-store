package br.pucpr.customers.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.pucpr.customers.entities.Customer;
import br.pucpr.customers.repositories.CustomersRepository;

@Service
public class CustomersService {
    @Autowired
    CustomersRepository customersRepository;

    public Customer save(Customer customer) {
        return this.customersRepository.save(customer);
    }

    public Customer getById(Long id) {
        Optional<Customer> customer = this.customersRepository.findById(id);
        
        if(customer.isPresent()) {
            return customer.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
    }

    public List<Customer> list() {
        return (List<Customer>) this.customersRepository.findAll();
    }

    public void deleteById(Long id) {
        Customer Customer = this.getById(id);
        this.customersRepository.delete(Customer);
    }
}

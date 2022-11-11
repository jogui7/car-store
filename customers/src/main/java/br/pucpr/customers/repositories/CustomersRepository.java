package br.pucpr.customers.repositories;

import org.springframework.data.repository.CrudRepository;

import br.pucpr.customers.entities.Customer;

public interface CustomersRepository extends CrudRepository<Customer, Long> {
    
}

package br.pucpr.sales.repositories;

import org.springframework.data.repository.CrudRepository;

import br.pucpr.sales.entities.Sale;

public interface SalesRepository extends CrudRepository<Sale, Long> {
    
}

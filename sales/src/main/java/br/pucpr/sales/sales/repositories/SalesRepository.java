package br.pucpr.sales.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.pucpr.sales.sales.entities.Sale;

@Repository
public interface SalesRepository extends CrudRepository<Sale, Long>, SalesRepositoryCustom {
    
}

package br.pucpr.sales.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import br.pucpr.sales.sales.entities.Sale;

public interface SalesRepository extends CrudRepository<Sale, Long> {
    
}

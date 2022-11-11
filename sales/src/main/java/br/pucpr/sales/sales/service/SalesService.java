package br.pucpr.sales.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.pucpr.sales.sales.entities.Sale;
import br.pucpr.sales.sales.repositories.SalesRepository;

@Service
public class SalesService {
    @Autowired
    SalesRepository salesRepository;

    public Sale save(Sale customer) {
        return this.salesRepository.save(customer);
    }
}

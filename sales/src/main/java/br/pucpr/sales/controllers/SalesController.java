package br.pucpr.sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucpr.sales.dtos.CreateSaleDTO;
import br.pucpr.sales.entities.Sale;
import br.pucpr.sales.service.SalesService;

@RestController
@RequestMapping("/sales")
@EnableAutoConfiguration
public class SalesController {
    
    @Autowired
    SalesService salesService;

    @PostMapping
    Sale create(@RequestBody CreateSaleDTO createSaleDTO) {
        return this.salesService.save(CreateSaleDTO.toEntity(createSaleDTO));
    }

}

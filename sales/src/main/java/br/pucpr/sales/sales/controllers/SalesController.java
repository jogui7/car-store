package br.pucpr.sales.sales.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucpr.sales.sales.dtos.CreateSaleDTO;
import br.pucpr.sales.sales.dtos.GetSaleDTO;
import br.pucpr.sales.sales.entities.Sale;
import br.pucpr.sales.sales.service.SaleTranslator;
import br.pucpr.sales.sales.service.SalesService;

@RestController
@RequestMapping("/sales")
@EnableAutoConfiguration
public class SalesController {
    
    @Autowired
    SalesService salesService;

    @Autowired
    SaleTranslator saleTranslator;

    @PostMapping
    GetSaleDTO create(@RequestBody CreateSaleDTO createSaleDTO) {
        Sale sale = this.salesService.save(CreateSaleDTO.toEntity(createSaleDTO));

        return this.saleTranslator.toDTO(sale);
    }

    @GetMapping("/today-report")
    List<GetSaleDTO> todayReport() {
        List<Sale> sales = this.salesService.list();

        List<GetSaleDTO> getSaleDTOs = new ArrayList<GetSaleDTO>();
        sales.forEach(sale -> getSaleDTOs.add(this.saleTranslator.toDTO(sale)));

        return getSaleDTOs;
    }

}

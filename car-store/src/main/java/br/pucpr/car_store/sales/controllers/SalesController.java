package br.pucpr.car_store.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucpr.car_store.sales.clients.SalesClient;
import br.pucpr.car_store.sales.dtos.CreateSaleDTO;
import br.pucpr.car_store.sales.dtos.GetSaleDTO;

@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    SalesClient salesClient;

    @PostMapping
    GetSaleDTO create(@RequestBody CreateSaleDTO createSaleDTO) {
        return this.salesClient.create(createSaleDTO);
    }

    @GetMapping("/today-report")
    List<GetSaleDTO> todayReport() {
        return this.salesClient.todayReport();
    }
}

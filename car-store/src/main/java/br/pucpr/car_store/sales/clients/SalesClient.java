package br.pucpr.car_store.sales.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.pucpr.car_store.sales.dtos.CreateSaleDTO;
import br.pucpr.car_store.sales.dtos.GetSaleDTO;

@FeignClient(value = "salesService", url = "http://localhost:8083/sales")
public interface SalesClient {
    
    @PostMapping
    GetSaleDTO create(@RequestBody CreateSaleDTO createSaleDTO);

    @GetMapping("/today-report")
    List<GetSaleDTO> todayReport();
}

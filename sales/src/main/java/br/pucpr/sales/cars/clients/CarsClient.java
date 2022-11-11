package br.pucpr.sales.cars.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.pucpr.sales.cars.dtos.GetCarDTO;

@FeignClient(value = "carsService", url = "http://localhost:8081/cars")
public interface CarsClient {

    @GetMapping("/{id}")
    GetCarDTO getById(@PathVariable("id") Long id);
}

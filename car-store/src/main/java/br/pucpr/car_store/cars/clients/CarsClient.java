package br.pucpr.car_store.cars.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.pucpr.car_store.cars.dtos.CreateOrUpdateCarDTO;
import br.pucpr.car_store.cars.dtos.GetCarDTO;

@FeignClient(value = "carsService", url = "http://localhost:8081/cars")
public interface CarsClient {
    @GetMapping
    List<GetCarDTO> list();

    @GetMapping("/{id}")
    GetCarDTO getById(@PathVariable("id") Long id);

    @PostMapping
    GetCarDTO create(@RequestBody CreateOrUpdateCarDTO createCarDTO);

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id);

    @PutMapping("/{id}")
    GetCarDTO update(@PathVariable("id") Long id, @RequestBody CreateOrUpdateCarDTO updateCarDTO);
}

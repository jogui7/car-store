package br.pucpr.car_store.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucpr.car_store.cars.clients.CarsClient;
import br.pucpr.car_store.cars.dtos.CreateOrUpdateCarDTO;
import br.pucpr.car_store.cars.dtos.GetCarDTO;

@RestController
@RequestMapping("/cars")
public class CarsController {
    @Autowired
    private CarsClient carsClient;

    @GetMapping
    List<GetCarDTO> list() {
        return carsClient.list();
    };

    @GetMapping("/{id}")
    GetCarDTO getById(@PathVariable("id") Long id) {
        return carsClient.getById(id);
    }


    @PostMapping
    GetCarDTO create(@RequestBody CreateOrUpdateCarDTO createCarDTO) {
        return carsClient.create(createCarDTO);
    }

    @PutMapping("/{id}")
    GetCarDTO update(@PathVariable("id") Long id, @RequestBody CreateOrUpdateCarDTO updateCarDTO) {
        return carsClient.update(id, updateCarDTO);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id) {
        carsClient.deleteById(id);
    }
} 

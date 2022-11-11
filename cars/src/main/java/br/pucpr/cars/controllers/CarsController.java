package br.pucpr.cars.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucpr.cars.dtos.CreateCarDTO;
import br.pucpr.cars.dtos.GetCarDTO;
import br.pucpr.cars.dtos.UpdateCarDTO;
import br.pucpr.cars.entities.Car;
import br.pucpr.cars.services.CarsService;

@RestController
@RequestMapping("/cars")
@EnableAutoConfiguration
public class CarsController {
    @Autowired CarsService carsService;
    
    @GetMapping("/{id}")
    GetCarDTO getById(@PathVariable("id") Long id) {
        return GetCarDTO.toDTO(this.carsService.getById(id));
    }
    
    @GetMapping 
    List<GetCarDTO> list() {
        List<Car> cars = this.carsService.list();

        List<GetCarDTO> getCarDTOs = new ArrayList<GetCarDTO>();
        cars.forEach(car -> getCarDTOs.add(GetCarDTO.toDTO(car)));

        return getCarDTOs;
    }

    @PostMapping
    GetCarDTO create(@RequestBody CreateCarDTO createCarDTO) {
        return GetCarDTO.toDTO(this.carsService.save(CreateCarDTO.toEntity(createCarDTO)));
    }

    @PutMapping("/{id}")
    GetCarDTO update(@PathVariable("id") Long id, @RequestBody UpdateCarDTO updateCarDTO) {
        Car car = this.carsService.getById(id);
        return GetCarDTO.toDTO(this.carsService.save(UpdateCarDTO.toEntity(car, updateCarDTO)));
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable("id") Long id) {
        this.carsService.deleteById(id);
    }
}

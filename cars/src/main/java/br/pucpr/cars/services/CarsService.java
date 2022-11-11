package br.pucpr.cars.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.pucpr.cars.entities.Car;
import br.pucpr.cars.repositories.CarsRepository;

@Service
public class CarsService {
    
    @Autowired CarsRepository carsRepository;

    public Car save(Car car) {
        return this.carsRepository.save(car);
    }

    public Car getById(Long id) {
        Optional<Car> car = this.carsRepository.findById(id);
        
        if(car.isPresent()) {
            return car.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "car not found");
    }

    public List<Car> list() {
        return (List<Car>) this.carsRepository.findAll();
    }

    public void deleteById(Long id) {
        Car car = this.getById(id);
        this.carsRepository.delete(car);
    }
}

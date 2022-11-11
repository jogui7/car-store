package br.pucpr.cars.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.pucpr.cars.entities.Car;

@Repository
public interface CarsRepository extends CrudRepository<Car, Long>{
    
}

package br.pucpr.cars.dtos;

import br.pucpr.cars.entities.Car;

public class CreateCarDTO {
    private String plate;
    private String make;
    private String model;
    private String year;
    private String color;

    public static Car toEntity(CreateCarDTO createCarDTO) {
        Car car = new Car();

        car.setPlate(createCarDTO.plate);
        car.setMake(createCarDTO.make);
        car.setModel(createCarDTO.model);
        car.setModelYear(createCarDTO.year);
        car.setColor(createCarDTO.color);

        return car;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

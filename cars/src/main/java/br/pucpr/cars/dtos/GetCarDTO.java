package br.pucpr.cars.dtos;

import br.pucpr.cars.entities.Car;

public class GetCarDTO {
    private Long id;
    private String plate;
    private String make;
    private String model;
    private String year;
    private String color;

    public static GetCarDTO toDTO(Car car) {
        GetCarDTO getCarDTO = new GetCarDTO();

        getCarDTO.setId(car.getId());
        getCarDTO.setPlate(car.getPlate());
        getCarDTO.setMake(car.getMake());
        getCarDTO.setModel(car.getModel());
        getCarDTO.setYear(car.getModelYear());
        getCarDTO.setColor(car.getColor());

        return getCarDTO;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

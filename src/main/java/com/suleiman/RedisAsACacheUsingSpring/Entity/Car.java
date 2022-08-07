package com.suleiman.RedisAsACacheUsingSpring.Entity;


import com.suleiman.RedisAsACacheUsingSpring.Utils.Transmission;
import org.springframework.data.redis.core.RedisHash;

import org.springframework.data.annotation.Id;;
import java.io.Serializable;

@RedisHash("Car")
public class Car implements Serializable {
    @Id
    private Long id;
    private String manufacturer;
    private Transmission transmission;
    private Long price;

    public Car() {

    }


    public Car(Long id, String manufacturer, Transmission transmission, Long price) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.transmission = transmission;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }


}

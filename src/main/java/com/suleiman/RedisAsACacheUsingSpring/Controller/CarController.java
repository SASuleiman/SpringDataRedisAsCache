package com.suleiman.RedisAsACacheUsingSpring.Controller;

import com.suleiman.RedisAsACacheUsingSpring.Entity.Car;
import com.suleiman.RedisAsACacheUsingSpring.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableCaching
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService service;

    @GetMapping
    public List<Car> getAllCars() {
      return service.getAllCars();
    }

    @PostMapping
    public Car addACar(@RequestBody Car car) {
        return service.addACarToTheRepo(car);
    }

    @CacheEvict(key = "#id",value = "Car")
    @DeleteMapping("/{id}")
    public String deleteCarById(@PathVariable("id") Long id) {
        return service.deleteCarById(id);
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "Car", unless = "#result.manufacturer == \"Inosson Motors\"")
    public Car getCarById(@PathVariable("id") Long id) {
        return service.findCarById(id);
    }

    //TODO: till the issue of how to use unless  enum is resolved continue working with cacheable field or use a sting field
    //TODO: note that the cache put is used to update the cache in the case in which the put mapping is used this will be done soon
}

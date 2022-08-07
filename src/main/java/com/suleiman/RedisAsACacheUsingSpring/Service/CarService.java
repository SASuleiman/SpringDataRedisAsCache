package com.suleiman.RedisAsACacheUsingSpring.Service;

import com.suleiman.RedisAsACacheUsingSpring.Entity.Car;
import com.suleiman.RedisAsACacheUsingSpring.Repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    Repo repository;

    public List<Car> getAllCars() {
       return repository.findAll();
    };

    public Car addACarToTheRepo(Car car) {
         return repository.save(car);
    }

    public Car findCarById(Long id) {
        Car selectedCar = repository.findById(id);
        if(selectedCar == null ) {
            throw new IllegalArgumentException("the id you selected does not exist in the db");
        }
        return selectedCar;
    }


    public String deleteCarById(Long id) {
        boolean isDone = repository.deleteById(id);
        if(!isDone) {
            return "unable to delete the entity";
        }
        return "delete is successful";
    }
}

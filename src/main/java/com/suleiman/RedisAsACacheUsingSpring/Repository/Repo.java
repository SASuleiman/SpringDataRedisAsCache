package com.suleiman.RedisAsACacheUsingSpring.Repository;

import com.suleiman.RedisAsACacheUsingSpring.Entity.Car;

import java.util.List;

public interface Repo {
    List<Car> findAll();
    Car findById(Long Id);
    Boolean deleteById(Long id);
    Car save(Car car);
}

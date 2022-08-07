package com.suleiman.RedisAsACacheUsingSpring.Utils;

import com.suleiman.RedisAsACacheUsingSpring.Entity.Car;
import com.suleiman.RedisAsACacheUsingSpring.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CLR implements CommandLineRunner {
    @Autowired
    CarService service;

    @Override
    public void run(String... args) throws Exception {
        service.addACarToTheRepo(new Car(2L,"Ford",Transmission.MANUAL,30_000_000L));
        service.addACarToTheRepo(new Car(3L,"Lexus",Transmission.AUTOMATIC,10_000_000L));
        service.addACarToTheRepo(new Car(4L,"Kia",Transmission.AUTOMATIC,8_000_000L));


    }
}

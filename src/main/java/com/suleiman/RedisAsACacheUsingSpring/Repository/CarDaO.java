package com.suleiman.RedisAsACacheUsingSpring.Repository;

import com.suleiman.RedisAsACacheUsingSpring.Entity.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CarDaO implements Repo {

    @Autowired
    private RedisTemplate redisTemplate;

    public static final String HASH_KEY = "Car";


Logger logger = LoggerFactory.getLogger(CarDaO.class.getName());

    @Override
    public List<Car> findAll() {
         return redisTemplate.opsForHash().values(HASH_KEY);
    }

    @Override
    public Car findById(Long id) {
        try {
        logger.info("successfully retrieved id from the db");
        return (Car) redisTemplate.opsForHash().get(HASH_KEY,id);
        } catch (Exception ex) {
            logger.error("unable to retrieve entity from the db");
            throw new IllegalArgumentException("Error");
        }
    }

    @Override
    public Boolean deleteById(Long id) {
        try {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
        logger.info("Delete Successful");
            return true;
        } catch (Exception exception) {
            logger.error("Delete Unsuccessful");
            exception.printStackTrace();
            return false;
        }

    }

    @Override
    public Car save(Car car) {
        redisTemplate.opsForHash().put(HASH_KEY,car.getId(),car);
        logger.info("save successful");
        return car;
    }
}

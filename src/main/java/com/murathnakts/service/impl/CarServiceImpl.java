package com.murathnakts.service.impl;

import com.murathnakts.dto.DtoCar;
import com.murathnakts.dto.DtoCarIU;
import com.murathnakts.entity.Car;
import com.murathnakts.repository.CarRepository;
import com.murathnakts.service.ICarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarServiceImpl implements ICarService {

    @Autowired
    private CarRepository carRepository;

    private Car createCar(DtoCarIU car) {
        Car newCar = new Car();
        newCar.setCreateTime(new Date());
        BeanUtils.copyProperties(car, newCar);
        return newCar;
    }

    @Override
    public DtoCar saveCar(DtoCarIU car) {
        DtoCar dtoCar = new DtoCar();
        Car savedCar = carRepository.save(createCar(car));
        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }
}

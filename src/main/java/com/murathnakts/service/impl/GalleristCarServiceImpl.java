package com.murathnakts.service.impl;

import com.murathnakts.dto.*;
import com.murathnakts.entity.Car;
import com.murathnakts.entity.Gallerist;
import com.murathnakts.entity.GalleristCar;
import com.murathnakts.exception.BaseException;
import com.murathnakts.exception.ErrorMessage;
import com.murathnakts.exception.MessageType;
import com.murathnakts.repository.CarRepository;
import com.murathnakts.repository.GalleristCarRepository;
import com.murathnakts.repository.GalleristRepository;
import com.murathnakts.service.IGalleristCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristCarServiceImpl implements IGalleristCarService {

    @Autowired
    private GalleristCarRepository galleristCarRepository;

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private CarRepository carRepository;

    private GalleristCar createGalleristCar(DtoGalleristCarIU galleristCar) {
        Optional<Gallerist> optionalGallerist = galleristRepository.findById(galleristCar.getGalleristId());
        if (optionalGallerist.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, galleristCar.getGalleristId().toString()));
        }
        Optional<Car> optionalCar = carRepository.findById(galleristCar.getCarId());
        if (optionalCar.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, galleristCar.getCarId().toString()));
        }
        GalleristCar newGalleristCar = new GalleristCar();
        newGalleristCar.setCreateTime(new Date());
        newGalleristCar.setGallerist(optionalGallerist.get());
        newGalleristCar.setCar(optionalCar.get());
        return newGalleristCar;
    }

    @Override
    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU galleristCar) {
        DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoCar dtoCar = new DtoCar();
        DtoAddress dtoAddress  = new DtoAddress();
        GalleristCar savedGalleristCar = galleristCarRepository.save(createGalleristCar(galleristCar));
        BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
        BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);
        dtoGallerist.setAddress(dtoAddress);
        dtoGalleristCar.setGallerist(dtoGallerist);
        dtoGalleristCar.setCar(dtoCar);
        return dtoGalleristCar;
    }
}

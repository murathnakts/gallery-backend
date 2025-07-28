package com.murathnakts.controller.impl;

import com.murathnakts.controller.ICarController;
import com.murathnakts.controller.base.BaseController;
import com.murathnakts.controller.base.RootEntity;
import com.murathnakts.dto.DtoCar;
import com.murathnakts.dto.DtoCarIU;
import com.murathnakts.service.ICarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarControllerImpl extends BaseController implements ICarController {

    @Autowired
    private ICarService carService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCar> saveCar(@Valid @RequestBody DtoCarIU car) {
        return success(carService.saveCar(car));
    }
}

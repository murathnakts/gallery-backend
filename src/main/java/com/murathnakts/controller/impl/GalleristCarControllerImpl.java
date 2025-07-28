package com.murathnakts.controller.impl;

import com.murathnakts.controller.IGalleristCarController;
import com.murathnakts.controller.base.BaseController;
import com.murathnakts.controller.base.RootEntity;
import com.murathnakts.dto.DtoGalleristCar;
import com.murathnakts.dto.DtoGalleristCarIU;
import com.murathnakts.service.IGalleristCarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gallerist-car")
public class GalleristCarControllerImpl extends BaseController implements IGalleristCarController {

    @Autowired
    private IGalleristCarService galleristCarService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGalleristCar> saveGalleristCar(@Valid @RequestBody DtoGalleristCarIU galleristCar) {
        return success(galleristCarService.saveGalleristCar(galleristCar));
    }
}

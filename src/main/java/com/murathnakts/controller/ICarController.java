package com.murathnakts.controller;

import com.murathnakts.controller.base.RootEntity;
import com.murathnakts.dto.DtoCar;
import com.murathnakts.dto.DtoCarIU;

public interface ICarController {

    public RootEntity<DtoCar> saveCar(DtoCarIU car);
}

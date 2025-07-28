package com.murathnakts.controller;

import com.murathnakts.controller.base.RootEntity;
import com.murathnakts.dto.DtoGalleristCar;
import com.murathnakts.dto.DtoGalleristCarIU;

public interface IGalleristCarController {

    public RootEntity<DtoGalleristCar> saveGalleristCar(DtoGalleristCarIU galleristCar);
}

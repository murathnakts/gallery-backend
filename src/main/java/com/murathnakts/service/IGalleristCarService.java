package com.murathnakts.service;

import com.murathnakts.dto.DtoGalleristCar;
import com.murathnakts.dto.DtoGalleristCarIU;

public interface IGalleristCarService {

    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU galleristCar);
}

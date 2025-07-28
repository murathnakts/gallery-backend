package com.murathnakts.service;

import com.murathnakts.dto.DtoCar;
import com.murathnakts.dto.DtoCarIU;

public interface ICarService {

    public DtoCar saveCar(DtoCarIU car);
}

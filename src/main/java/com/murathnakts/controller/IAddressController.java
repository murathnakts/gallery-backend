package com.murathnakts.controller;

import com.murathnakts.dto.DtoAddress;
import com.murathnakts.dto.DtoAddressIU;

public interface IAddressController {

    public RootEntity<DtoAddress> saveAddress(DtoAddressIU address);
}

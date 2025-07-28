package com.murathnakts.service;

import com.murathnakts.dto.DtoAddress;
import com.murathnakts.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU address);
}

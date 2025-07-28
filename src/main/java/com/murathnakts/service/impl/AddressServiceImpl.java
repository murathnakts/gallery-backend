package com.murathnakts.service.impl;

import com.murathnakts.dto.DtoAddress;
import com.murathnakts.dto.DtoAddressIU;
import com.murathnakts.entity.Address;
import com.murathnakts.repository.AddressRepository;
import com.murathnakts.service.IAddressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    private Address createAddress(DtoAddressIU address) {
        Address newAddress = new Address();
        newAddress.setCreateTime(new Date());
        BeanUtils.copyProperties(address, newAddress);
        return newAddress;
    }

    @Override
    public DtoAddress saveAddress(DtoAddressIU address) {
        DtoAddress dtoAddress = new DtoAddress();
        Address saveAddress = addressRepository.save(createAddress(address));
        BeanUtils.copyProperties(saveAddress, dtoAddress);
        return dtoAddress;
    }
}

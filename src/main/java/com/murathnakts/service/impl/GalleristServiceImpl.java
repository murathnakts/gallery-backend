package com.murathnakts.service.impl;

import com.murathnakts.dto.DtoAddress;
import com.murathnakts.dto.DtoGallerist;
import com.murathnakts.dto.DtoGalleristIU;
import com.murathnakts.entity.Address;
import com.murathnakts.entity.Gallerist;
import com.murathnakts.exception.BaseException;
import com.murathnakts.exception.ErrorMessage;
import com.murathnakts.exception.MessageType;
import com.murathnakts.repository.AddressRepository;
import com.murathnakts.repository.GalleristRepository;
import com.murathnakts.service.IGalleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristServiceImpl implements IGalleristService {

    @Autowired
    private GalleristRepository galleristRepository;

    @Autowired
    private AddressRepository addressRepository;

    private Gallerist createGallerist(DtoGalleristIU gallerist) {
        Optional<Address> optionalAddress = addressRepository.findById(gallerist.getAddressId());
        if (optionalAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, gallerist.getAddressId().toString()));
        }
        Gallerist newGallerist = new Gallerist();
        newGallerist.setCreateTime(new Date());
        BeanUtils.copyProperties(gallerist, newGallerist);
        newGallerist.setAddress(optionalAddress.get());
        return newGallerist;
    }

    @Override
    public DtoGallerist saveGallerist(DtoGalleristIU gallerist) {
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAddress dtoAddress = new DtoAddress();
        Gallerist savedGallerist = galleristRepository.save(createGallerist(gallerist));
        BeanUtils.copyProperties(savedGallerist, dtoGallerist);
        BeanUtils.copyProperties(savedGallerist.getAddress(), dtoAddress);
        dtoGallerist.setAddress(dtoAddress);
        return dtoGallerist;
    }
}

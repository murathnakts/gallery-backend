package com.murathnakts.controller.impl;

import com.murathnakts.controller.base.BaseController;
import com.murathnakts.controller.IAddressController;
import com.murathnakts.controller.base.RootEntity;
import com.murathnakts.dto.DtoAddress;
import com.murathnakts.dto.DtoAddressIU;
import com.murathnakts.service.IAddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressControllerImpl extends BaseController implements IAddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU address) {
        return success(addressService.saveAddress(address));
    }
}

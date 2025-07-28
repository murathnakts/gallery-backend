package com.murathnakts.controller.impl;

import com.murathnakts.controller.BaseController;
import com.murathnakts.controller.ICustomerController;
import com.murathnakts.controller.RootEntity;
import com.murathnakts.dto.DtoCustomer;
import com.murathnakts.dto.DtoCustomerIU;
import com.murathnakts.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerControllerImpl extends BaseController implements ICustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU customer) {
        return success(customerService.saveCustomer(customer));
    }
}

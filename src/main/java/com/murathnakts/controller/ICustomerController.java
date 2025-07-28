package com.murathnakts.controller;

import com.murathnakts.dto.DtoCustomer;
import com.murathnakts.dto.DtoCustomerIU;

public interface ICustomerController {

    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU customer);
}

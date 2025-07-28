package com.murathnakts.service;

import com.murathnakts.dto.DtoCustomer;
import com.murathnakts.dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU customer);
}

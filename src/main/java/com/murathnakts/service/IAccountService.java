package com.murathnakts.service;

import com.murathnakts.dto.DtoAccount;
import com.murathnakts.dto.DtoAccountIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU account);
}

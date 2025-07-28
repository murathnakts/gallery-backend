package com.murathnakts.controller;

import com.murathnakts.dto.DtoAccount;
import com.murathnakts.dto.DtoAccountIU;

public interface IAccountController {

    public RootEntity<DtoAccount> saveAccount(DtoAccountIU account);
}

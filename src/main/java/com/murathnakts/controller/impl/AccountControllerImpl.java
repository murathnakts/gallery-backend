package com.murathnakts.controller.impl;

import com.murathnakts.controller.BaseController;
import com.murathnakts.controller.IAccountController;
import com.murathnakts.controller.RootEntity;
import com.murathnakts.dto.DtoAccount;
import com.murathnakts.dto.DtoAccountIU;
import com.murathnakts.service.IAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountControllerImpl extends BaseController implements IAccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU account) {
        return success(accountService.saveAccount(account));
    }
}

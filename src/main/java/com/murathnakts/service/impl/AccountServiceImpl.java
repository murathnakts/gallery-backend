package com.murathnakts.service.impl;

import com.murathnakts.dto.DtoAccount;
import com.murathnakts.dto.DtoAccountIU;
import com.murathnakts.entity.Account;
import com.murathnakts.repository.AccountRepository;
import com.murathnakts.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    private Account createAccount(DtoAccountIU account) {
        Account newAccount = new Account();
        newAccount.setCreateTime(new Date());
        BeanUtils.copyProperties(account, newAccount);
        return newAccount;
    }

    @Override
    public DtoAccount saveAccount(DtoAccountIU account) {
        DtoAccount dtoAccount = new DtoAccount();
        Account savedAccount = accountRepository.save(createAccount(account));
        BeanUtils.copyProperties(savedAccount, dtoAccount);
        return dtoAccount;
    }
}

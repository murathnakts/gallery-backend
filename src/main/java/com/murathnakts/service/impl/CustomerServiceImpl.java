package com.murathnakts.service.impl;

import com.murathnakts.dto.DtoAccount;
import com.murathnakts.dto.DtoAddress;
import com.murathnakts.dto.DtoCustomer;
import com.murathnakts.dto.DtoCustomerIU;
import com.murathnakts.entity.Account;
import com.murathnakts.entity.Address;
import com.murathnakts.entity.Customer;
import com.murathnakts.exception.BaseException;
import com.murathnakts.exception.ErrorMessage;
import com.murathnakts.exception.MessageType;
import com.murathnakts.repository.AccountRepository;
import com.murathnakts.repository.AddressRepository;
import com.murathnakts.repository.CustomerRepository;
import com.murathnakts.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Customer createCustomer(DtoCustomerIU customer) {
        Optional<Address> optionalAddress = addressRepository.findById(customer.getAddressId());
        if (optionalAddress.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, customer.getAddressId().toString()));
        }
        Optional<Account> optionalAccount = accountRepository.findById(customer.getAccountId());
        if (optionalAccount.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, customer.getAccountId().toString()));
        }
        Customer newCustomer = new Customer();
        newCustomer.setCreateTime(new Date());
        BeanUtils.copyProperties(customer, newCustomer);
        newCustomer.setAddress(optionalAddress.get());
        newCustomer.setAccount(optionalAccount.get());
        return newCustomer;
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU customer) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        DtoAccount dtoAccount = new DtoAccount();
        Customer savedCustomer = customerRepository.save(createCustomer(customer));
        BeanUtils.copyProperties(savedCustomer, dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);
        dtoCustomer.setAddress(dtoAddress);
        dtoCustomer.setAccount(dtoAccount);
        return dtoCustomer;
    }
}

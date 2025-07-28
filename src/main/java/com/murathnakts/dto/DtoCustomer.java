package com.murathnakts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoCustomer extends DtoBase{
    private String firstName;
    private String lastName;
    private String tckn;
    private Date dateOfBirth;
    private DtoAddress address;
    private DtoAccount account;
}

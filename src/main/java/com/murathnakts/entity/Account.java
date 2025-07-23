package com.murathnakts.entity;

import com.murathnakts.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {

    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "iban")
    private String iban;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
}

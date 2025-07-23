package com.murathnakts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tckn")
    private String tckn;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @OneToOne
    private Address address;

    @OneToOne
    private Account account;
}

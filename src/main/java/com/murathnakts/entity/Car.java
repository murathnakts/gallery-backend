package com.murathnakts.entity;

import com.murathnakts.enums.CarStatusType;
import com.murathnakts.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car extends BaseEntity {

    @Column(name = "plate")
    private String plate;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    @Column(name = "damage_price")
    private BigDecimal damagePrice;

    @Column(name = "car_status_type")
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatusType;
}

package com.murathnakts.dto;

import com.murathnakts.enums.CarStatusType;
import com.murathnakts.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoCar extends DtoBase {
    private String plate;
    private String brand;
    private String model;
    private Integer productionYear;
    private BigDecimal price;
    private CurrencyType currency;
    private BigDecimal damagePrice;
    private CarStatusType carStatusType;
}

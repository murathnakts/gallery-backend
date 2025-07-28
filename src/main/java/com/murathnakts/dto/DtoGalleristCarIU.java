package com.murathnakts.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DtoGalleristCarIU {

    @NotNull
    private Long galleristId;

    @NotNull
    private Long carId;
}

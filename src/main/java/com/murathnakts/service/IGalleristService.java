package com.murathnakts.service;

import com.murathnakts.dto.DtoGallerist;
import com.murathnakts.dto.DtoGalleristIU;

public interface IGalleristService {

    public DtoGallerist saveGallerist(DtoGalleristIU gallerist);
}

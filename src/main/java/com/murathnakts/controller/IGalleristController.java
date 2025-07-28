package com.murathnakts.controller;

import com.murathnakts.controller.base.RootEntity;
import com.murathnakts.dto.DtoGallerist;
import com.murathnakts.dto.DtoGalleristIU;

public interface IGalleristController {

    public RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU gallerist);
}

package com.murathnakts.controller.impl;

import com.murathnakts.controller.IGalleristController;
import com.murathnakts.controller.base.BaseController;
import com.murathnakts.controller.base.RootEntity;
import com.murathnakts.dto.DtoGallerist;
import com.murathnakts.dto.DtoGalleristIU;
import com.murathnakts.service.IGalleristService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gallerist")
public class GalleristControllerImpl extends BaseController implements IGalleristController {

    @Autowired
    private IGalleristService galleristService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoGallerist> saveGallerist(@Valid @RequestBody DtoGalleristIU gallerist) {
        return success(galleristService.saveGallerist(gallerist));
    }
}

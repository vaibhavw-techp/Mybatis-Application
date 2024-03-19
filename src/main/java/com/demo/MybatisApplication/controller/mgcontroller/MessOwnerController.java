package com.demo.MybatisApplication.controller.mgcontroller;

import com.demo.MybatisApplication.dto.mgdto.MessDisplayDto;
import com.demo.MybatisApplication.dto.mgdto.MessOwnerAdditionDto;
import com.demo.MybatisApplication.dto.mgdto.MessOwnerDisplayDto;
import com.demo.MybatisApplication.mapstruct.mgmapstruct.MessOwnerMapper;
import com.demo.MybatisApplication.model.mgmodel.MessEntity;
import com.demo.MybatisApplication.model.mgmodel.MessOwnerEntity;
import com.demo.MybatisApplication.service.mgservice.MessOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mess-owners")
public class MessOwnerController {

    @Autowired
    private MessOwnerService messOwnerService;


    @PostMapping
    public ResponseEntity<MessOwnerDisplayDto> createMessOwner(@RequestBody MessOwnerAdditionDto messOwnerAdditionDto) {
        return ResponseEntity.ok().body(messOwnerService.createMessOwner(messOwnerAdditionDto));
    }

    @GetMapping
    public ResponseEntity<List<MessOwnerDisplayDto>> getAllMessOwners() {
        return ResponseEntity.ok().body(messOwnerService.getAllMessOwners());
    }

}
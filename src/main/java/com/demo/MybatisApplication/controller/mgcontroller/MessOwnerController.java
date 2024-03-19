package com.demo.MybatisApplication.controller.mgcontroller;

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
    public ResponseEntity<MessOwnerEntity> createMessOwner(@RequestBody MessOwnerEntity messOwner) {
        MessOwnerEntity createdMessOwner = messOwnerService.createMessOwner(messOwner);
        return ResponseEntity.ok().body(createdMessOwner);
    }

    @GetMapping
    public ResponseEntity<List<MessOwnerEntity>> getAllMessOwners() {
        List<MessOwnerEntity> messOwners = messOwnerService.getAllMessOwners();
        return ResponseEntity.ok().body(messOwners);
    }

}
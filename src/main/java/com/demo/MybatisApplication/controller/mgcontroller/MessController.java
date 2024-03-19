package com.demo.MybatisApplication.controller.mgcontroller;

import com.demo.MybatisApplication.model.mgmodel.MessEntity;
import com.demo.MybatisApplication.service.mgservice.MessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mess")
public class MessController {

    @Autowired
    private MessService messService;

    @PostMapping
    public ResponseEntity<MessEntity> createMess(@RequestBody MessEntity mess) {
        MessEntity createdMess = messService.createMess(mess);
        return ResponseEntity.ok().body(createdMess);
    }

    @GetMapping
    public ResponseEntity<List<MessEntity>> getAllMess() {
        List<MessEntity> messList = messService.getAllMess();
        return ResponseEntity.ok().body(messList);
    }

}
package com.demo.MybatisApplication.controller.mgcontroller;

import com.demo.MybatisApplication.dto.mgdto.MessAdditionDto;
import com.demo.MybatisApplication.dto.mgdto.MessDisplayDto;
import com.demo.MybatisApplication.model.mgmodel.MessOwnerEntity;
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
    public ResponseEntity<MessDisplayDto> createMess(@RequestBody MessAdditionDto mess) {
        return ResponseEntity.ok().body(messService.createMess(mess));
    }

    @GetMapping
    public ResponseEntity<List<MessDisplayDto>> getAllMess() {
        return ResponseEntity.ok().body(messService.getAllMess());
    }

    @GetMapping("{messId}/owners")
    public ResponseEntity<MessOwnerEntity> getOwnerByMessId(@PathVariable Long messId){
        MessOwnerEntity messOwner = messService.getOwnerByMessId(messId);
        return ResponseEntity.ok().body(messOwner);
    }

}
package com.demo.MybatisApplication.controller.mgcontroller;

import com.demo.MybatisApplication.model.mgmodel.HostelEntity;
import com.demo.MybatisApplication.service.mgservice.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hostels")
public class HostelController {

    @Autowired
    private HostelService hostelService;

    @PostMapping
    public ResponseEntity<HostelEntity> createHostel(@RequestBody HostelEntity hostel) {
        HostelEntity createdHostel = hostelService.createHostel(hostel);
        return ResponseEntity.ok().body(createdHostel);
    }

    @GetMapping
    public ResponseEntity<List<HostelEntity>> getAllHostels() {
        List<HostelEntity> hostels = hostelService.getAllHostels();
        return ResponseEntity.ok().body(hostels);
    }

}

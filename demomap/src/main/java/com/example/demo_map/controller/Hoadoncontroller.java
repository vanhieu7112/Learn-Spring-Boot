package com.example.demo_map.controller;


import com.example.demo_map.domain.Hoadon;
import com.example.demo_map.service.HoadonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hoadon")
public class Hoadoncontroller {
    private final HoadonService hoadonService;
@Autowired
    public Hoadoncontroller(HoadonService hoadonService) {
        this.hoadonService = hoadonService;
    }

    /**
     * GET ALL
     */
    @GetMapping
    public List<HoaDonModel> getAll(){
        return hoadonService.getAll();
    }
    /**
     * CREATE
     */
    @PostMapping
    public HoaDonModel create(@RequestBody HoadonForm form){
        return hoadonService.create(form).toModel();
    }
}

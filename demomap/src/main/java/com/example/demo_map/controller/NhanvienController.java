package com.example.demo_map.controller;

import com.example.demo_map.domain.Nhanvien;
import com.example.demo_map.service.NhanvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/nhanvien")
public class NhanvienController {
    private final NhanvienService nhanvienService;

    @Autowired
    public NhanvienController(NhanvienService nhanvienService) {
        this.nhanvienService = nhanvienService;
    }
    /**
     * GET ALL
     */
    @GetMapping()
    public List<NhanVienModel> getAll(){
        return nhanvienService.getAll();
    }
    /**
     * CREATE
     */
    @PostMapping
    public Nhanvien create(@RequestBody NhanvienForm form){

        return nhanvienService.create(form);
    }
    /**
     * UPDATE
     */
    /**
     * DELETE
     */
}

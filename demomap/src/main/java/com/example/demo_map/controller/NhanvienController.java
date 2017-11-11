package com.example.demo_map.controller;

import com.example.demo_map.domain.Nhanvien;
import com.example.demo_map.repository.NhanvienRepository;
import com.example.demo_map.service.NhanvienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/nhanvien")
public class NhanvienController {
    private final NhanvienService nhanvienService;

    @Autowired
    public NhanvienController(NhanvienService nhanvienService) {
        this.nhanvienService = nhanvienService;
    }

    /**
     * GET ALL
     */
//    @GetMapping()
//    public List<NhanVienModel> getAll() {
//        return nhanvienService.getAll();
//    }
//    @GetMapping("/getall")
//    public PagingObject<NhanVienModel> getAllNhanviens(@RequestParam(defaultValue = "0") Integer page,
//                                                     @RequestParam(defaultValue = "10") Integer size) {
//        return nhanvienService.getAllNhanviens(page, size);
//    }

    @GetMapping()
    public PagingObject<NhanVienModel> getAllNhanviens(Pageable pageable) {
        return nhanvienService.getAllNhanviens(pageable);
    }

    /**
     * CREATE
     */
    @PostMapping
    public Nhanvien create(@RequestBody NhanvienForm form) {

        return nhanvienService.create(form);
    }

    @GetMapping("/dataTest")
    public void insertDataTest() {
        nhanvienService.insertDataTest();
    }

    /**
     * UPDATE
     */
    @PutMapping("/{id}")
    public String update(@RequestBody NhanvienForm form, @PathVariable BigInteger id) {
        return nhanvienService.update(form, id);
    }
    /**
     * DELETE
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable BigInteger id)
    {
         nhanvienService.delete(id);
    }

    @DeleteMapping
    public void deleteAll()
    {
        nhanvienService.deleteAll();

    }
}

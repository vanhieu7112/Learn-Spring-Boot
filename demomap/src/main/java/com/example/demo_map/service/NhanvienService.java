package com.example.demo_map.service;

import com.example.demo_map.controller.NhanVienModel;
import com.example.demo_map.domain.Nhanvien;
import com.example.demo_map.controller.NhanvienForm;
import com.example.demo_map.repository.NhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NhanvienService {
    private final NhanvienRepository nhanvientRepository;
    @Autowired
    public  NhanvienService(NhanvienRepository nhanvientRepository)
    {
        this.nhanvientRepository = nhanvientRepository;
    }
    public List<NhanVienModel> getAll(){
        return nhanvientRepository.findAll().stream().map(Nhanvien::toModel).collect(Collectors.toList());
    }

    public Nhanvien create(NhanvienForm form){
        Nhanvien rs = new Nhanvien();
        rs.setName(form.getName());
        rs.setSex(form.getSex());
        rs.setAddress(form.getAddress());

        return nhanvientRepository.save(rs);
    }
    public Nhanvien get(BigInteger id){
        return nhanvientRepository.findOne(id);
    }


}

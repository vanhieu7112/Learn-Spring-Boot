package com.example.demo_map.service;

import com.example.demo_map.controller.HoaDonModel;
import com.example.demo_map.controller.HoadonForm;
import com.example.demo_map.domain.Hoadon;
import com.example.demo_map.repository.hoadonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoadonService {
    private final hoadonRepository hoadonRepository;
    private final NhanvienService nhanvienService;
    @Autowired
    public HoadonService(hoadonRepository hoadonRepository, NhanvienService nhanvienService)
    {
        this.hoadonRepository = hoadonRepository;
        this.nhanvienService = nhanvienService;
    }
    public List<HoaDonModel> getAll(){
        return hoadonRepository.findAll().stream().map(Hoadon::toModel).collect(Collectors.toList());


    }

    public Hoadon create(HoadonForm form){
        Hoadon rs = new Hoadon();
        rs.setDate(form.getDate());
        rs.setDonghoadon(form.getDonghoadon());
        rs.setNhanvien(nhanvienService.get(form.getNhanvienId()));

        return hoadonRepository.save(rs);
    }
}

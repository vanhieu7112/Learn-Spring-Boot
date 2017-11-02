package com.example.demo_map.service;

import com.example.demo_map.controller.HoaDonModel;
import com.example.demo_map.controller.HoadonForm;
import com.example.demo_map.domain.Hoadon;
import com.example.demo_map.domain.Nhanvien;
import com.example.demo_map.repository.hoadonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoadonService {
    private final hoadonRepository hoadonRepository;

    @Autowired
    public HoadonService(hoadonRepository hoadonRepository) {
        this.hoadonRepository = hoadonRepository;

    }

    public List<HoaDonModel> getAll() {
        return hoadonRepository.findAll().stream().map(Hoadon::toModel).collect(Collectors.toList());


    }

    public Hoadon create(HoadonForm form) {
        Hoadon rs = new Hoadon();
        rs.setDate(form.getDate());
        rs.setDonghoadon(form.getDonghoadon());
        Nhanvien nhanvien = new Nhanvien(form.getNhanvienId());
        rs.setNhanvien(nhanvien);
        return hoadonRepository.save(rs);
    }
    public void delete(BigInteger id)
    {
        hoadonRepository.delete(id);

    }

}

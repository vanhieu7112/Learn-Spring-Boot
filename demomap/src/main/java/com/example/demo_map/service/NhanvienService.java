package com.example.demo_map.service;

import com.example.demo_map.controller.HoadonForm;
import com.example.demo_map.controller.NhanVienModel;
import com.example.demo_map.domain.Hoadon;
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
    private final NhanvienRepository nhanvienRepository;

    @Autowired
    public NhanvienService(NhanvienRepository nhanvientRepository) {
        this.nhanvienRepository = nhanvientRepository;
    }

    public List<NhanVienModel> getAll() {
        return nhanvienRepository.findAll().stream().map(Nhanvien::toModel).collect(Collectors.toList());
    }

    public Nhanvien create(NhanvienForm form) {
        Nhanvien rs = new Nhanvien();
        rs.setName(form.getName());
        rs.setSex(form.getSex());
        rs.setAddress(form.getAddress());
        return nhanvienRepository.save(rs);
    }

    public String update(NhanvienForm form, BigInteger id) {
        Nhanvien nhanvien = nhanvienRepository.findOne(id);
        if (form.getName() != null) {
            nhanvien.setName(form.getName());
            nhanvien.setSex(form.getSex());
            nhanvien.setAddress(form.getAddress());
        }
        if (form.getBillFormList() != null) {
            List<HoadonForm> hoadonFormList = form.getBillFormList();
            nhanvien.getHoadons().clear();

            for (HoadonForm hoadonForm : hoadonFormList) {
                Hoadon hoadon = new Hoadon();
                hoadon.setDate(hoadonForm.getDate());
                hoadon.setDonghoadon(hoadonForm.getDonghoadon());
                hoadon.setNhanvien(nhanvien);
                nhanvien.getHoadons().add(hoadon);
            }
        } else {
            System.out.println("Can not find data in From");
        }
        nhanvienRepository.save(nhanvien);
        return "Updated!";
    }

    public void delete(BigInteger id)
    {
        nhanvienRepository.delete(id);

    }


}

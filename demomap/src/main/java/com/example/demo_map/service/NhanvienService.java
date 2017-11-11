package com.example.demo_map.service;

import com.example.demo_map.controller.HoadonForm;
import com.example.demo_map.controller.NhanVienModel;
import com.example.demo_map.controller.PagingObject;
import com.example.demo_map.domain.Hoadon;
import com.example.demo_map.domain.Nhanvien;
import com.example.demo_map.controller.NhanvienForm;
import com.example.demo_map.repository.NhanvienRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NhanvienService {
    private final NhanvienRepository nhanvienRepository;

    @Autowired
    public NhanvienService(NhanvienRepository nhanvientRepository) {
        this.nhanvienRepository = nhanvientRepository;
    }

//    public PagingObject<NhanVienModel> getAllNhanviens(Integer page, Integer size) {
//        log.info("Paging size: " + size + "/Page: " + page);
//        if (size > 500) size = 10;
//        PageRequest pageRequest = new PageRequest(page, size);
//
//        PagingObject<NhanVienModel> rs = new PagingObject<>();
//
//        Page<Nhanvien> nhanvienPage = nhanvienRepository.findAll(pageRequest);
//
//        rs.setTotal(nhanvienPage.getTotalElements());
//        rs.setTotalPage(nhanvienPage.getTotalPages());
//
//        rs.setData(nhanvienPage.getContent().stream().map(Nhanvien::toModel).collect(Collectors.toList()));
//
//        return rs;
//    }
public PagingObject<NhanVienModel> getAllNhanviens(Pageable pageable) {
    log.info("Paging :" + pageable);
    if(pageable.getPageSize() > 500) throw new RuntimeException();

    PagingObject<NhanVienModel> rs = new PagingObject<>();

    Page<Nhanvien> nhanvienPage = nhanvienRepository.findAll(pageable);
    rs.setTotal(nhanvienPage.getTotalElements());
    rs.setTotalPage(nhanvienPage.getTotalPages());

    rs.setData(nhanvienPage.getContent().stream().map(Nhanvien::toModel).collect(Collectors.toList()));

    return rs;
}

    public List<NhanVienModel> getAll() {
        return nhanvienRepository.findAll().stream().map(Nhanvien::toModel).collect(Collectors.toList());
    }

    public void insertDataTest() {
        for (long i = 0; i < 1000; i++) {
            Nhanvien nhanvien = new Nhanvien();
            nhanvien.setName("Test 1");
            nhanvien.setSex("Sex " + i);
            nhanvien.setAddress("Address" +i);
            nhanvienRepository.save(nhanvien);
        }
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
        Nhanvien nv = nhanvienRepository.findOne(id);
        nhanvienRepository.delete(nv);

    }
    public void deleteAll()
    {
        nhanvienRepository.deleteAll();

    }

}

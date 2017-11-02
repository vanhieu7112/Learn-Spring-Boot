package com.example.demo_map.controller;

import lombok.Data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
public class NhanVienModel {
    private BigInteger nhanvienId;
    private String name;
    private String sex;
    private String address;
    private List<HoaDonModel> billModels;

    public NhanVienModel() {
        billModels = new ArrayList<>();
    }

    public NhanVienModel(BigInteger nhanvienId, String name, String sex, String address) {
        this.nhanvienId = nhanvienId;
        this.name = name;
        this.sex = sex;
        this.address = address;
    }
}

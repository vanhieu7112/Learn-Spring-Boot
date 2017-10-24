package com.example.demo_map.controller;

import java.math.BigInteger;
import java.util.List;

public class NhanVienModel {
    private BigInteger id;

    private String name;
    private String sex;

    private String address;
    private List<HoaDonModel> hoadon;
    public BigInteger getId() {
        return id;
    }

    public List<HoaDonModel> getHoadon() {
        return hoadon;
    }

    public void setHoadon(List<HoaDonModel> hoadon) {
        this.hoadon = hoadon;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

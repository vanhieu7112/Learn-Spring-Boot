package com.example.demo_map.controller;

import com.example.demo_map.domain.Nhanvien;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

public class HoaDonModel {
    private BigInteger id;
    private String date;
    private String donghoadon;


    private NhanVienModel nhanvien;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDonghoadon() {
        return donghoadon;
    }

    public void setDonghoadon(String donghoadon) {
        this.donghoadon = donghoadon;
    }

    public NhanVienModel getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(NhanVienModel nhanvien) {
        this.nhanvien = nhanvien;
    }
}

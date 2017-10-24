package com.example.demo_map.controller;

import java.math.BigInteger;

public class HoadonForm {
    private String date;
    private String donghoadon;

    private BigInteger nhanvienId;

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

    public BigInteger getNhanvienId() {
        return nhanvienId;
    }

    public void setNhanvienId(BigInteger nhanvienId) {
        this.nhanvienId = nhanvienId;
    }
}

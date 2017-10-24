package com.example.demo_map.domain;

import com.example.demo_map.controller.HoaDonModel;
import com.example.demo_map.controller.NhanVienModel;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="Hoadon")
public class Hoadon {
    @Id
    @GeneratedValue
    private BigInteger id;
    private String date;
    private String donghoadon;


    @ManyToOne
    @JoinColumn(name = "nhanvien_id")
    private Nhanvien nhanvien;

    public HoaDonModel toModel(){
        HoaDonModel rs = new HoaDonModel();
        rs.setId(id);
        rs.setDate(date);
        rs.setDonghoadon(donghoadon);
//        rs.setNhanvien(nhanvien.toModel());
        return rs;
    }
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

    public Nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(Nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }

    public void setDonghoadon(String donghoadon) {
        this.donghoadon = donghoadon;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Hoadon Hoadon = (Hoadon) o;
//
//        if (!getId().equals(Hoadon.getId())) return false;
//        if (!getDate().equals(Hoadon.getDate())) return false;
//        return getDonghoadon().equals(Hoadon.getDonghoadon());
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId().hashCode();
//        result = 31 * result + getDate().hashCode();
//        result = 31 * result + getDonghoadon().hashCode();
//        return result;
//    }
}

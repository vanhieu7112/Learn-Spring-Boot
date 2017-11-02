package com.example.demo_map.domain;

import com.example.demo_map.controller.HoaDonModel;
import com.example.demo_map.controller.NhanVienModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity

@Table(name = "bill")
public class Hoadon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigInteger id;
    private String date;
    @Column(name = "bill_line")
    private String donghoadon;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Nhanvien nhanvien;

    public HoaDonModel toModel() {
        HoaDonModel rs = new HoaDonModel();
        rs.setHoadonId(id);
        rs.setDate(date);
        rs.setDonghoadon(donghoadon);
//        rs.setNhanvien(nhanvien.toModel());
        return rs;
    }

}

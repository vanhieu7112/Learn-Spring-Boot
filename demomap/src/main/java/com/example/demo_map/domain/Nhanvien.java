package com.example.demo_map.domain;

import com.example.demo_map.controller.NhanVienModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "staff")
public class Nhanvien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private BigInteger id;

    private String name;
    private String sex;
    private String address;

    @OneToMany(mappedBy = "nhanvien", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hoadon> hoadons;

    public Nhanvien() {
    }

    public Nhanvien(BigInteger id) {
        this.id = id;
    }

    public NhanVienModel toModel() {
        NhanVienModel rs = new NhanVienModel();
        rs.setAddress(address);
        rs.setSex(sex);
        rs.setNhanvienId(id);
        rs.setName(name);
        for (Hoadon hoadon : hoadons) {
            rs.getBillModels().add(hoadon.toModel());
        }
        return rs;
    }
    @Override
    public String toString() {
        String result = String.format("Nhanvien[id=%d, name='%s', sex='%s',address='%s']%n",
                id, name, sex, address);
        if (hoadons != null) {
            for (Hoadon hoadon : hoadons) {
                result += String.format(
                        "Hoadon[id=%d, date='%s', donghoadon='%s']%n",
                        hoadon.getId(), hoadon.getDate(), hoadon.getDonghoadon());
            }
        }
        return result;
    }

}

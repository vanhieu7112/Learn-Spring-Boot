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

    @OneToMany(mappedBy = "nhanvien")

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


}

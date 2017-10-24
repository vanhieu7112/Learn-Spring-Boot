package com.example.demo_map.domain;

import com.example.demo_map.controller.NhanVienModel;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name="Nhanvien")
public class Nhanvien {
    @Id
    @GeneratedValue
    @Column(name = "nhanvien_id")
    private BigInteger id;

    private String name;
    private String sex;

    private String address;

    @OneToMany(mappedBy = "nhanvien")
    private List<Hoadon> hoadons;


    public NhanVienModel toModel(){
        NhanVienModel rs = new NhanVienModel();
        rs.setAddress(address);
        rs.setSex(sex);
        rs.setId(id);
        rs.setName(name);

        return rs;
    }

    public List<Hoadon> getHoadons() {
        return hoadons;
    }

    public void setHoadons(List<Hoadon> hoadons) {
        this.hoadons = hoadons;
    }


    public BigInteger getId() {
        return id;
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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Nhanvien Nhanvien = (Nhanvien) o;
//
//        if (!getId().equals(Nhanvien.getId())) return false;
//        if (!getName().equals(Nhanvien.getName())) return false;
//        if (!getSex().equals(Nhanvien.getSex())) return false;
//        return getAdress().equals(Nhanvien.getAdress());
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId().hashCode();
//        result = 31 * result + getName().hashCode();
//        result = 31 * result + getSex().hashCode();
//        result = 31 * result + getAdress().hashCode();
//        return result;
//    }
}

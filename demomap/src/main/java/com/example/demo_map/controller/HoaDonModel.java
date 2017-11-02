package com.example.demo_map.controller;

import com.example.demo_map.domain.Nhanvien;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigInteger;

@Data
public class HoaDonModel {
    private BigInteger hoadonId;
    private String date;
    private String donghoadon;


}

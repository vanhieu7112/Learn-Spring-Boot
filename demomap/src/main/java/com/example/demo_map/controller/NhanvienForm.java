package com.example.demo_map.controller;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

@Data
public class NhanvienForm {
    private BigInteger id;
    private String name;
    private String sex;
    private String address;
    private List<HoadonForm> billFormList;
}

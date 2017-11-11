package com.example.demo_map.controller;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PagingObject<T> {
    private Long total;
    private Integer totalPage;
    private List<T> data = new ArrayList<>();
}

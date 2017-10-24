package com.example.demo_map.repository;

import com.example.demo_map.domain.Hoadon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface hoadonRepository extends JpaRepository<Hoadon,BigInteger>{
}

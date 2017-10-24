package com.example.demo_map.repository;

import com.example.demo_map.domain.Nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface NhanvienRepository extends JpaRepository<Nhanvien,BigInteger> {
}

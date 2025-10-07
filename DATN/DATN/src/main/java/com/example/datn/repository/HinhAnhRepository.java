package com.example.datn.repository;

import com.example.datn.entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HinhAnhRepository extends JpaRepository<HinhAnh, UUID> {}

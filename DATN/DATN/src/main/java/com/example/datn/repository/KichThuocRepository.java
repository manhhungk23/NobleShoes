package com.example.datn.repository;

import com.example.datn.entity.KichThuoc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KichThuocRepository extends JpaRepository<KichThuoc, UUID> {}

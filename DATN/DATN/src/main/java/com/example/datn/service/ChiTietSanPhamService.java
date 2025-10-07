package com.example.datn.service;

import com.example.datn.entity.ChiTietSanPham;
import com.example.datn.repository.ChiTietSanPhamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChiTietSanPhamService {
    private final ChiTietSanPhamRepository repo;

    public ChiTietSanPhamService(ChiTietSanPhamRepository repo) { this.repo = repo; }

    public List<ChiTietSanPham> findAll() { return repo.findAll(); }
    public Optional<ChiTietSanPham> findById(UUID id) { return repo.findById(id); }
    public ChiTietSanPham save(ChiTietSanPham obj) { return repo.save(obj); }
    public void deleteById(UUID id) { repo.deleteById(id); }
}

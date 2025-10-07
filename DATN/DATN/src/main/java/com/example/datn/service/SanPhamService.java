package com.example.datn.service;

import com.example.datn.entity.SanPham;
import com.example.datn.repository.SanPhamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamService {
    private final SanPhamRepository repo;

    public SanPhamService(SanPhamRepository repo) { this.repo = repo; }

    public List<SanPham> findAll() { return repo.findAll(); }
    public Optional<SanPham> findById(UUID id) { return repo.findById(id); }
    public SanPham save(SanPham obj) { return repo.save(obj); }
    public void deleteById(UUID id) { repo.deleteById(id); }
}

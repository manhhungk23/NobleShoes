package com.example.datn.service;

import com.example.datn.entity.NhanVien;
import com.example.datn.repository.NhanVienRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienService {
    private final NhanVienRepository repo;

    public NhanVienService(NhanVienRepository repo) { this.repo = repo; }

    public List<NhanVien> findAll() { return repo.findAll(); }
    public Optional<NhanVien> findById(UUID id) { return repo.findById(id); }
    public NhanVien save(NhanVien obj) { return repo.save(obj); }
    public void deleteById(UUID id) { repo.deleteById(id); }
}

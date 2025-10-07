package com.example.datn.service;

import com.example.datn.entity.ThuongHieu;
import com.example.datn.repository.ThuongHieuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ThuongHieuService {
    private final ThuongHieuRepository repo;

    public ThuongHieuService(ThuongHieuRepository repo) { this.repo = repo; }

    public List<ThuongHieu> findAll() { return repo.findAll(); }
    public Optional<ThuongHieu> findById(UUID id) { return repo.findById(id); }
    public ThuongHieu save(ThuongHieu obj) { return repo.save(obj); }
    public void deleteById(UUID id) { repo.deleteById(id); }
}

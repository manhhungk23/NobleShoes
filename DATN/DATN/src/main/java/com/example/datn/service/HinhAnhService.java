package com.example.datn.service;

import com.example.datn.entity.HinhAnh;
import com.example.datn.repository.HinhAnhRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HinhAnhService {
    private final HinhAnhRepository repo;

    public HinhAnhService(HinhAnhRepository repo) { this.repo = repo; }

    public List<HinhAnh> findAll() { return repo.findAll(); }
    public Optional<HinhAnh> findById(UUID id) { return repo.findById(id); }
    public HinhAnh save(HinhAnh obj) { return repo.save(obj); }
    public void deleteById(UUID id) { repo.deleteById(id); }
}

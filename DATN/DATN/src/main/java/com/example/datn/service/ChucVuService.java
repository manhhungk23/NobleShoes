package com.example.datn.service;

import com.example.datn.entity.ChucVu;
import com.example.datn.repository.ChucVuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuService {
    private final ChucVuRepository repo;

    public ChucVuService(ChucVuRepository repo) { this.repo = repo; }

    public List<ChucVu> findAll() { return repo.findAll(); }
    public Optional<ChucVu> findById(UUID id) { return repo.findById(id); }
    public ChucVu save(ChucVu obj) { return repo.save(obj); }
    public void deleteById(UUID id) { repo.deleteById(id); }
}

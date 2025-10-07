package com.example.datn.service;

import com.example.datn.entity.HoaDon;
import com.example.datn.repository.HoaDonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HoaDonService {
    private final HoaDonRepository repo;

    public HoaDonService(HoaDonRepository repo) { this.repo = repo; }

    public List<HoaDon> findAll() { return repo.findAll(); }
    public Optional<HoaDon> findById(UUID id) { return repo.findById(id); }
    public HoaDon save(HoaDon obj) { return repo.save(obj); }
    public void deleteById(UUID id) { repo.deleteById(id); }
}

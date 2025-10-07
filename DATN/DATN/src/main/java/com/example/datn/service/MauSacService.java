package com.example.datn.service;

import com.example.datn.entity.MauSac;
import com.example.datn.repository.MauSacRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MauSacService {
    private final MauSacRepository repo;

    public MauSacService(MauSacRepository repo) { this.repo = repo; }

    public List<MauSac> findAll() { return repo.findAll(); }
    public Optional<MauSac> findById(UUID id) { return repo.findById(id); }
    public MauSac save(MauSac obj) { return repo.save(obj); }
    public void deleteById(UUID id) { repo.deleteById(id); }
}

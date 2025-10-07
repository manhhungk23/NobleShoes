package com.example.datn.service;

import com.example.datn.entity.KichThuoc;
import com.example.datn.repository.KichThuocRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KichThuocService {
    private final KichThuocRepository repo;

    public KichThuocService(KichThuocRepository repo) { this.repo = repo; }

    public List<KichThuoc> findAll() { return repo.findAll(); }
    public Optional<KichThuoc> findById(UUID id) { return repo.findById(id); }
    public KichThuoc save(KichThuoc obj) { return repo.save(obj); }
    public void deleteById(UUID id) { repo.deleteById(id); }
}

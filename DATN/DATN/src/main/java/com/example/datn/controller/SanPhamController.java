package com.example.datn.controller;

import com.example.datn.entity.SanPham;
import com.example.datn.service.SanPhamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/san-pham")
public class SanPhamController {
    private final SanPhamService service;
    public SanPhamController(SanPhamService service) { this.service = service; }

    @GetMapping
    public List<SanPham> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public SanPham one(@PathVariable UUID id) {
        return service.findById(id).orElseThrow(() -> new NoSuchElementException("SanPham not found"));
    }

    @PostMapping
    public SanPham create(@RequestBody SanPham obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public SanPham update(@PathVariable UUID id, @RequestBody SanPham obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.deleteById(id); }
}

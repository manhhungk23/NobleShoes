package com.example.datn.controller;

import com.example.datn.entity.ChiTietSanPham;
import com.example.datn.service.ChiTietSanPhamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/chi-tiet-san-pham")
public class ChiTietSanPhamController {
    private final ChiTietSanPhamService service;
    public ChiTietSanPhamController(ChiTietSanPhamService service) { this.service = service; }

    @GetMapping
    public List<ChiTietSanPham> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ChiTietSanPham one(@PathVariable UUID id) {
        return service.findById(id).orElseThrow(() -> new NoSuchElementException("ChiTietSanPham not found"));
    }

    @PostMapping
    public ChiTietSanPham create(@RequestBody ChiTietSanPham obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public ChiTietSanPham update(@PathVariable UUID id, @RequestBody ChiTietSanPham obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.deleteById(id); }
}

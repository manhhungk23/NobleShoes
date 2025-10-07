package com.example.datn.controller;

import com.example.datn.entity.PhuongThucThanhToan;
import com.example.datn.service.PhuongThucThanhToanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/phuong-thuc-thanh-toan")
public class PhuongThucThanhToanController {
    private final PhuongThucThanhToanService service;
    public PhuongThucThanhToanController(PhuongThucThanhToanService service) { this.service = service; }

    @GetMapping
    public List<PhuongThucThanhToan> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public PhuongThucThanhToan one(@PathVariable UUID id) {
        return service.findById(id).orElseThrow(() -> new NoSuchElementException("PhuongThucThanhToan not found"));
    }

    @PostMapping
    public PhuongThucThanhToan create(@RequestBody PhuongThucThanhToan obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public PhuongThucThanhToan update(@PathVariable UUID id, @RequestBody PhuongThucThanhToan obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.deleteById(id); }
}

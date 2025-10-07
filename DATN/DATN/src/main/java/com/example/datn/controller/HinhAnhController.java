package com.example.datn.controller;

import com.example.datn.entity.HinhAnh;
import com.example.datn.service.HinhAnhService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/hinh-anh")
public class HinhAnhController {
    private final HinhAnhService service;
    public HinhAnhController(HinhAnhService service) { this.service = service; }

    @GetMapping
    public List<HinhAnh> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public HinhAnh one(@PathVariable UUID id) {
        return service.findById(id).orElseThrow(() -> new NoSuchElementException("HinhAnh not found"));
    }

    @PostMapping
    public HinhAnh create(@RequestBody HinhAnh obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public HinhAnh update(@PathVariable UUID id, @RequestBody HinhAnh obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.deleteById(id); }
}

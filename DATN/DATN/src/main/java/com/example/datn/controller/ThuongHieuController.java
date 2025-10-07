package com.example.datn.controller;

import com.example.datn.entity.ThuongHieu;
import com.example.datn.service.ThuongHieuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/thuong-hieu")
public class ThuongHieuController {
    private final ThuongHieuService service;
    public ThuongHieuController(ThuongHieuService service) { this.service = service; }

    @GetMapping
    public List<ThuongHieu> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ThuongHieu one(@PathVariable UUID id) {
        return service.findById(id).orElseThrow(() -> new NoSuchElementException("ThuongHieu not found"));
    }

    @PostMapping
    public ThuongHieu create(@RequestBody ThuongHieu obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public ThuongHieu update(@PathVariable UUID id, @RequestBody ThuongHieu obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.deleteById(id); }
}

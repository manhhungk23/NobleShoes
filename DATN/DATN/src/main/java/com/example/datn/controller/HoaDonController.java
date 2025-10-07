package com.example.datn.controller;

import com.example.datn.entity.HoaDon;
import com.example.datn.service.HoaDonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonController {
    private final HoaDonService service;
    public HoaDonController(HoaDonService service) { this.service = service; }

    @GetMapping
    public List<HoaDon> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public HoaDon one(@PathVariable UUID id) {
        return service.findById(id).orElseThrow(() -> new NoSuchElementException("HoaDon not found"));
    }

    @PostMapping
    public HoaDon create(@RequestBody HoaDon obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public HoaDon update(@PathVariable UUID id, @RequestBody HoaDon obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.deleteById(id); }
}

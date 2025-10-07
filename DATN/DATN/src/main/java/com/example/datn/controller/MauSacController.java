package com.example.datn.controller;

import com.example.datn.entity.MauSac;
import com.example.datn.service.MauSacService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/mau-sac")
public class MauSacController {
    private final MauSacService service;
    public MauSacController(MauSacService service) { this.service = service; }

    @GetMapping
    public List<MauSac> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public MauSac one(@PathVariable UUID id) {
        return service.findById(id).orElseThrow(() -> new NoSuchElementException("MauSac not found"));
    }

    @PostMapping
    public MauSac create(@RequestBody MauSac obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public MauSac update(@PathVariable UUID id, @RequestBody MauSac obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.deleteById(id); }
}

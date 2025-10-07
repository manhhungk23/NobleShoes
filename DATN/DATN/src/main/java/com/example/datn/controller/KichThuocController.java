package com.example.datn.controller;

import com.example.datn.entity.KichThuoc;
import com.example.datn.service.KichThuocService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/kich-thuoc")
public class KichThuocController {
    private final KichThuocService service;
    public KichThuocController(KichThuocService service) { this.service = service; }

    @GetMapping
    public List<KichThuoc> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public KichThuoc one(@PathVariable UUID id) {
        return service.findById(id).orElseThrow(() -> new NoSuchElementException("KichThuoc not found"));
    }

    @PostMapping
    public KichThuoc create(@RequestBody KichThuoc obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public KichThuoc update(@PathVariable UUID id, @RequestBody KichThuoc obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.deleteById(id); }
}

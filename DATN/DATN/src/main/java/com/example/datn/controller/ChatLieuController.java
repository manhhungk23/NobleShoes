package com.example.datn.controller;

import com.example.datn.entity.ChatLieu;
import com.example.datn.service.ChatLieuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
@RequestMapping("/api/chat-lieu")
public class ChatLieuController {
    private final ChatLieuService service;
    public ChatLieuController(ChatLieuService service) { this.service = service; }

    @GetMapping
    public List<ChatLieu> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public ChatLieu one(@PathVariable UUID id) {
        return service.findById(id).orElseThrow(() -> new NoSuchElementException("ChatLieu not found"));
    }

    @PostMapping
    public ChatLieu create(@RequestBody ChatLieu obj) { return service.save(obj); }

    @PutMapping("/{id}")
    public ChatLieu update(@PathVariable UUID id, @RequestBody ChatLieu obj) {
        obj.setId(id);
        return service.save(obj);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) { service.deleteById(id); }
}

package com.example.datn.service;

import com.example.datn.entity.ChatLieu;
import com.example.datn.repository.ChatLieuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChatLieuService {
    private final ChatLieuRepository repo;

    public ChatLieuService(ChatLieuRepository repo) { this.repo = repo; }

    public List<ChatLieu> findAll() { return repo.findAll(); }
    public Optional<ChatLieu> findById(UUID id) { return repo.findById(id); }
    public ChatLieu save(ChatLieu obj) { return repo.save(obj); }
    public void deleteById(UUID id) { repo.deleteById(id); }
}

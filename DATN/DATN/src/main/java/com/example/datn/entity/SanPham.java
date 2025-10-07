package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "san_pham")
public class SanPham {
    @Id @GeneratedValue
    @Column(name="id", columnDefinition="uniqueidentifier")
    private UUID id;

    @ManyToOne @JoinColumn(name="id_thuong_hieu")
    private ThuongHieu thuongHieu;

    @ManyToOne @JoinColumn(name="id_chat_lieu")
    private ChatLieu chatLieu;

    @ManyToOne @JoinColumn(name="id_hinh")
    private HinhAnh hinhAnh;

    @Column(name="ma", nullable=false, unique=true)
    private String ma;

    @Column(name="ten", nullable=false)
    private String ten;
}

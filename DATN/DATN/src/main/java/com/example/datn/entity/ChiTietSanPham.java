package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "chi_tiet_san_pham")
public class ChiTietSanPham {
    @Id @GeneratedValue
    @Column(name="id", columnDefinition="uniqueidentifier")
    private UUID id;

    @ManyToOne @JoinColumn(name="id_san_pham", nullable=false)
    private SanPham sanPham;

    @ManyToOne @JoinColumn(name="id_mau")
    private MauSac mauSac;

    @ManyToOne @JoinColumn(name="id_kich")
    private KichThuoc kichThuoc;

    @Column(name="gia", precision=18, scale=2)
    private BigDecimal gia;

    @Column(name="so_luong")
    private Integer soLuong;
}

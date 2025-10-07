package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "hoa_don_chi_tiet")
public class HoaDonChiTiet {
    @Id @GeneratedValue
    @Column(name="id", columnDefinition="uniqueidentifier")
    private UUID id;

    @ManyToOne @JoinColumn(name="id_hd")
    private HoaDon hoaDon;

    @ManyToOne @JoinColumn(name="id_ctsp")
    private ChiTietSanPham chiTietSanPham;

    @Column(name="so_luong")
    private Integer soLuong;

    @Column(name="don_gia", precision=18, scale=2)
    private BigDecimal donGia;
}

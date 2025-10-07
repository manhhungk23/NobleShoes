package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "hoa_don")
public class HoaDon {
    @Id @GeneratedValue
    @Column(name="id", columnDefinition="uniqueidentifier")
    private UUID id;

    @Column(name="ma", nullable=false, unique=true)
    private String ma;

    @ManyToOne @JoinColumn(name="id_khach")
    private KhachHang khachHang;

    @ManyToOne @JoinColumn(name="id_nv")
    private NhanVien nhanVien;

    @Column(name="tong_tien", precision=18, scale=2)
    private BigDecimal tongTien;

    @ManyToOne @JoinColumn(name="id_pttt")
    private PhuongThucThanhToan phuongThucThanhToan;

    @Column(name="trang_thai")
    private Integer trangThai;

    @Column(name="ngay_tao")
    private Date ngayTao;
}

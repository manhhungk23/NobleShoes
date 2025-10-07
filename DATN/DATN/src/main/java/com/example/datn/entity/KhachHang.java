package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "khach_hang")
public class KhachHang {
    @Id @GeneratedValue
    @Column(name="id", columnDefinition="uniqueidentifier")
    private UUID id;

    @Column(name="ma", nullable=false, unique=true)
    private String ma;

    @Column(name="ho_ten")
    private String hoTen;

    @Column(name="sdt")
    private String sdt;

    @Column(name="email", unique=true)
    private String email;

    @Column(name="gioi_tinh")
    private Integer gioiTinh;

    @Column(name="ngay_sinh")
    private Date ngaySinh;

    @Column(name="tai_khoan", unique=true)
    private String taiKhoan;

    @Column(name="mat_khau")
    private String matKhau;

    @Column(name="trang_thai")
    private Integer trangThai;
}

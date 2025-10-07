package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "chuc_vu")
public class ChucVu {
    @Id @GeneratedValue
    @Column(name="id", columnDefinition="uniqueidentifier")
    private UUID id;

    @Column(name="ma", nullable=false, unique=true)
    private String ma;

    @Column(name="ten", nullable=false)
    private String ten;

    @Column(name="ngay_tao")
    private Date ngayTao;
}

package com.example.demo2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Truong")
public class Truong {

    @Id
    @Column(name = "maTruong")
    private String maTruong;

    @Column(name = "tenTruong")
    private String tenTruong;

    @Column(name = "diaChi")
    private String diaChi;

    public Truong() {
    }

    public Truong(String maTruong, String tenTruong, String diaChi) {
        this.maTruong = maTruong;
        this.tenTruong = tenTruong;
        this.diaChi = diaChi;
    }

    public String getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }

    public String getTenTruong() {
        return tenTruong;
    }

    public void setTenTruong(String tenTruong) {
        this.tenTruong = tenTruong;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
}


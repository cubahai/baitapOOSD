package com.example.demo2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Nganh")
public class Nganh {

    @Id
    @Column(name = "maNganh")
    private String maNganh;

    @Column(name = "tenNganh")
    private String tenNganh;

    @Column(name = "maTruong")
    private String maTruong;

    public Nganh() {
    }

    public Nganh(String maNganh, String tenNganh, String maTruong) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.maTruong = maTruong;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }
}


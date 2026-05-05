package com.example.demo2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SinhVien")
public class Table_SV {
    @Id
    @Column(name = "soCMND")
    private String soCMND;

    @Column(name = "hoTen")
    private String hoTen;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "email")
    private String email;

    @Column(name = "soDT")
    private String soDT;

    public Table_SV() {
    }

    public Table_SV(String soCMND, String hoTen, String diaChi, String email, String soDT) {
        this.soCMND = soCMND;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.email = email;
        this.soDT = soDT;
    }

    // Getters and Setters
    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }
}

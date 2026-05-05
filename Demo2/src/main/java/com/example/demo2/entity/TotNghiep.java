package com.example.demo2.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TotNghiep")
public class TotNghiep {

    @Id
    @Column(name = "soCMND")
    private String soCMND;

    @Column(name = "maTruong")
    private String maTruong;

    @Column(name = "maNganh")
    private String maNganh;

    @Column(name = "ngayTN")
    @Temporal(TemporalType.DATE)
    private Date ngayTN;

    public TotNghiep() {
    }

    public TotNghiep(String soCMND, String maTruong, String maNganh, Date ngayTN) {
        this.soCMND = soCMND;
        this.maTruong = maTruong;
        this.maNganh = maNganh;
        this.ngayTN = ngayTN;
    }

    // Getters and Setters
    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public String getMaTruong() {
        return maTruong;
    }

    public void setMaTruong(String maTruong) {
        this.maTruong = maTruong;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public Date getNgayTN() {
        return ngayTN;
    }

    public void setNgayTN(Date ngayTN) {
        this.ngayTN = ngayTN;
    }
}

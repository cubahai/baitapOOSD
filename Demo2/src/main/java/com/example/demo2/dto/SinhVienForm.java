package com.example.demo2.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class SinhVienForm {

    @NotBlank(message = "Số CMND là bắt buộc nhập")
    private String soCMND;

    @NotBlank(message = "Họ tên là bắt buộc nhập")
    private String hoTen;

    @NotBlank(message = "Địa chỉ là bắt buộc nhập")
    private String diaChi;

    @NotBlank(message = "Email là bắt buộc nhập")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Số điện thoại là bắt buộc nhập")
    @Pattern(regexp = "^[0-9]{10,11}$", message = "Số điện thoại phải có 10 hoặc 11 chữ số")
    private String soDT;

    @NotBlank(message = "Vui lòng chọn trường")
    private String maTruong;

    @NotBlank(message = "Vui lòng chọn ngành")
    private String maNganh;

    @NotNull(message = "Ngày tốt nghiệp không được để trống")
    @Past(message = "Ngày tốt nghiệp phải nhỏ hơn ngày hiện tại") // Yêu cầu 2.4 (Hợp lệ dữ liệu)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTN;

    public SinhVienForm() {
    }

    public SinhVienForm(String soCMND, String hoTen, String diaChi, String email, String soDT, String maTruong, String maNganh, Date ngayTN) {
        this.soCMND = soCMND;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.email = email;
        this.soDT = soDT;
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

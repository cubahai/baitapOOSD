package com.example.demo2.controller;

import com.example.demo2.dto.SinhVienForm;
import com.example.demo2.entity.Table_SV;
import com.example.demo2.entity.TotNghiep;
import com.example.demo2.repository.NganhRepository;
import com.example.demo2.repository.SinhVienRepository;
import com.example.demo2.repository.TruongRepository;
import com.example.demo2.repository.TotNghiepRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sinh-vien")
public class SinhVienController {

    @Autowired
    private TruongRepository truongRepo;

    @Autowired
    private NganhRepository nganhRepo;

    @Autowired
    private SinhVienRepository sinhVienRepo;

    @Autowired
    private TotNghiepRepository totNghiepRepo;

    /**
     * Hiển thị form khai báo sinh viên
     */
    @GetMapping("/khai-bao")
    public String showForm(Model model) {
        // Tạo object form để map dữ liệu
        model.addAttribute("sinhVienForm", new SinhVienForm());

        // Lấy danh sách để đổ vào ComboBox
        model.addAttribute("dsTruong", truongRepo.findAll());
        model.addAttribute("dsNganh", nganhRepo.findAll());

        return "khai-bao-form"; // Tên file template Thymeleaf
    }

    /**
     * Xử lý lưu dữ liệu sinh viên
     */
    @PostMapping("/luu-thong-tin")
    public String save(@Valid @ModelAttribute("sinhVienForm") SinhVienForm form,
                       BindingResult result, Model model) {

        // Nếu có lỗi Validation
        if (result.hasErrors()) {
            // Đổ lại dữ liệu ComboBox để người dùng chọn lại
            model.addAttribute("dsTruong", truongRepo.findAll());
            model.addAttribute("dsNganh", nganhRepo.findAll());
            return "khai-bao-form";
        }

        // Nếu không lỗi, tiến hành lưu vào Database
        try {
            Table_SV sinhVien = new Table_SV();
            sinhVien.setSoCMND(form.getSoCMND());
            sinhVien.setHoTen(form.getHoTen());
            sinhVien.setDiaChi(form.getDiaChi());
            sinhVien.setEmail(form.getEmail());
            sinhVien.setSoDT(form.getSoDT());

            sinhVienRepo.save(sinhVien);

            // Lưu thông tin tốt nghiệp
            TotNghiep totNghiep = new TotNghiep();
            totNghiep.setSoCMND(form.getSoCMND());
            totNghiep.setMaTruong(form.getMaTruong());
            totNghiep.setMaNganh(form.getMaNganh());
            totNghiep.setNgayTN(form.getNgayTN());

            totNghiepRepo.save(totNghiep);

            return "redirect:/sinh-vien/success";
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi lưu dữ liệu: " + e.getMessage());
            model.addAttribute("dsTruong", truongRepo.findAll());
            model.addAttribute("dsNganh", nganhRepo.findAll());
            return "khai-bao-form";
        }
    }

    /**
     * Trang th��nh công
     */
    @GetMapping("/success")
    public String success() {
        return "success";
    }
}

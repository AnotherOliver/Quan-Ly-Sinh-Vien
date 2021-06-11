package com.example.assignment.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String maSinhVien;
    private String tenSinhVien;
    private String maLop;

    public SinhVien() {
    }

    public SinhVien(String maSinhVien, String tenSinhVien, String maLop) {
        this.maSinhVien = maSinhVien;
        this.tenSinhVien = tenSinhVien;
        this.maLop = maLop;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getTenSinhVien() {
        return tenSinhVien;
    }

    public void setTenSinhVien(String tenSinhVien) {
        this.tenSinhVien = tenSinhVien;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }
}

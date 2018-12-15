package com.traudat.smartedu.View.TrangChu;

import com.traudat.smartedu.Model.ObjectClass.KhoaHoc;
import com.traudat.smartedu.Model.ObjectClass.QuanLyKhoaHoc;

import java.util.List;

public interface ViewKhoaHoc {
    void HienThiDanhSachKhoaHoc(List<QuanLyKhoaHoc> quanLyKhoaHocs);
    void HienThiDanhSach(List<KhoaHoc> khoaHocs);
}

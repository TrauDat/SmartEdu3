package com.traudat.smartedu.Presenter.ChiTietKhoaHoc;

import com.traudat.smartedu.Model.ChiTietKhoaHoc.ModelChiTietKhoaHoc;
import com.traudat.smartedu.Model.ObjectClass.ChiTietKhoaHoc;
import com.traudat.smartedu.Model.ObjectClass.KhoaHoc;
import com.traudat.smartedu.View.ChiTietKhoaHoc.ViewChiTietKhoaHoc;

import java.util.List;

public class PresenterLogicChiTietKhoaHoc implements IPresenterChiTietKhoaHoc {


    ViewChiTietKhoaHoc viewChiTietKhoaHoc;
    ModelChiTietKhoaHoc modelChiTietKhoaHoc;

    public PresenterLogicChiTietKhoaHoc(ViewChiTietKhoaHoc viewChiTietKhoaHoc) {
        this.viewChiTietKhoaHoc = viewChiTietKhoaHoc;
        modelChiTietKhoaHoc = new ModelChiTietKhoaHoc();
    }



    @Override
    public void LayChiTietKhoaHoc(int makhoahoc) {
        KhoaHoc khoaHoc = modelChiTietKhoaHoc.DanhSachChiTietKhoaHoc(makhoahoc);

        if (khoaHoc.getMAKHOAHOC() > 0) {
            viewChiTietKhoaHoc.HienThiChiTietKhoaHoc(khoaHoc);
        }
    }
}

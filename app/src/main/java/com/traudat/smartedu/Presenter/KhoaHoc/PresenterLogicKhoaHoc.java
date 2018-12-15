package com.traudat.smartedu.Presenter.KhoaHoc;


import com.traudat.smartedu.Model.KhoaHoc.ModelKhoaHoc;
import com.traudat.smartedu.Model.ObjectClass.KhoaHoc;
import com.traudat.smartedu.View.TrangChu.ViewKhoaHoc;

import java.util.List;

public class PresenterLogicKhoaHoc implements IPresenterKhoaHoc  {

    ViewKhoaHoc viewKhoaHoc;
    ModelKhoaHoc modelKhoaHoc;


    public PresenterLogicKhoaHoc(ViewKhoaHoc viewKhoaHoc) {
        this.viewKhoaHoc  = viewKhoaHoc;
        modelKhoaHoc = new ModelKhoaHoc();
    }
    @Override
    public void LayDanhSachKhoaHoc() {
        List<KhoaHoc> khoaHocList = modelKhoaHoc.LayDanhSachKhoaHocDuocMo();

        if (khoaHocList.size() > 0) {
            viewKhoaHoc.HienThiDanhSach(khoaHocList);
        }

    }
}

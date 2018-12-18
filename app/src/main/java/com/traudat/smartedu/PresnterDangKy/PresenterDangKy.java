package com.traudat.smartedu.PresnterDangKy;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;

import com.traudat.smartedu.Model.DangNhap_DangKy.ModelDangKy;
import com.traudat.smartedu.Model.ObjectClass.NhanVien;
import com.traudat.smartedu.View.DangNhap_DangKy.Frangment.DangNhapActivity;
import com.traudat.smartedu.View.DangNhap_DangKy.ViewDangKy;
import com.traudat.smartedu.View.TrangChu.TrangChuActivity;

public class PresenterDangKy implements IPresenterDangKy {
    ViewDangKy viewDangKy;
    ModelDangKy modelDangKy;

    public PresenterDangKy(ViewDangKy viewDangKy){
        this.viewDangKy = viewDangKy;
        modelDangKy = new ModelDangKy();
    }

    @Override
    public void ThucHienDangKy(NhanVien nhanvien) {
        boolean kiemtra = modelDangKy.DangKyThanhVien(nhanvien);
        if(kiemtra){
            viewDangKy.DangKyThangCong();

        }else{
            viewDangKy.DangKyThatBai();
        }

    }
}

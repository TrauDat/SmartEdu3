package com.traudat.smartedu.View.ChiTietKhoaHoc;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;

import com.traudat.smartedu.Model.ObjectClass.ChiTietKhoaHoc;
import com.traudat.smartedu.Model.ObjectClass.KhoaHoc;
import com.traudat.smartedu.Presenter.ChiTietKhoaHoc.PresenterLogicChiTietKhoaHoc;
import com.traudat.smartedu.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ChiTietKhoaHocActivity extends AppCompatActivity implements ViewChiTietKhoaHoc,ViewPager.OnPageChangeListener {

    PresenterLogicChiTietKhoaHoc presenterLogicChiTietKhoaHoc;
    TextView txtTenKhoaHoc,txtHocPhi,txtDiaChi,txtGiangVien,txtNgayBatDau,txtNgayKetThuc;
    Toolbar toolbar;
    int makhoahoc;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_chitietkhoahoc);

        txtTenKhoaHoc = findViewById(R.id.txtTenKhoaHoc);
        txtHocPhi = findViewById(R.id.txtHocPhi);
        txtDiaChi = findViewById(R.id.txtDiaChi);
        txtGiangVien = findViewById(R.id.txtGiangVien);
        txtNgayBatDau = findViewById(R.id.txtNgayBatDau);
        txtNgayKetThuc = findViewById(R.id.txtNgayKetThuc);


        toolbar = findViewById(R.id.toolbar);

        makhoahoc = getIntent().getIntExtra("makhoahoc",0);
        presenterLogicChiTietKhoaHoc = new PresenterLogicChiTietKhoaHoc(this);
        presenterLogicChiTietKhoaHoc.LayChiTietKhoaHoc(makhoahoc);
        Log.d("kiemtraba", String.valueOf(makhoahoc));



    }

    @Override
    public void HienThiChiTietKhoaHoc(final KhoaHoc khoaHoc) {

//        makhoahoc = khoaHoc.getMAKHOAHOC();

//        txtTenKhoaHoc.setText(khoaHoc.getTENKHOAHOC());
        txtTenKhoaHoc.setText(khoaHoc.getMAKHOAHOC());
        int giaTien = khoaHoc.getHOCPHI();
        NumberFormat numberFormat = new DecimalFormat("###,###");
        String gia = numberFormat.format(giaTien);
        txtHocPhi.setText(gia + " VNĐ");


        ChiTietKhoaHoc chiTietKhoaHoc = new ChiTietKhoaHoc();
        txtDiaChi.setText(chiTietKhoaHoc.getDIACHI());
        txtNgayBatDau.setText(chiTietKhoaHoc.getNGAYBATDAU());
        txtNgayKetThuc.setText(chiTietKhoaHoc.getNGAYKETTHUC());
        txtGiangVien.setText(chiTietKhoaHoc.getTENGIANGVIEN());


    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}

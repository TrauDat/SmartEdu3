package com.traudat.smartedu.View.DangNhap_DangKy.Frangment;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.traudat.smartedu.Adapter.ViewPagerAdaterDangNhap;
import com.traudat.smartedu.R;

public class DangNhapActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        tabLayout = findViewById(R.id.tabDangNhap);
        viewPager =findViewById(R.id.viewPagerDangNhap);
        toolbar =  findViewById(R.id.toolBarDangNhap);

//        setSupportActionBar(toolbar);

        ViewPagerAdaterDangNhap viewPagerAdaterDangNhap = new ViewPagerAdaterDangNhap(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdaterDangNhap);
        viewPagerAdaterDangNhap.notifyDataSetChanged();

        tabLayout.setupWithViewPager(viewPager);
    }
}

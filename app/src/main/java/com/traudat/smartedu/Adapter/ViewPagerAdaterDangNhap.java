package com.traudat.smartedu.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.traudat.smartedu.View.DangNhap_DangKy.Frangment.FrangmentDangNhap;
import com.traudat.smartedu.View.DangNhap_DangKy.Frangment.FrangmentDanhKy;

public class ViewPagerAdaterDangNhap extends FragmentPagerAdapter {
    public ViewPagerAdaterDangNhap(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0 :
                FrangmentDangNhap fragmentDangNhap = new FrangmentDangNhap();
                return fragmentDangNhap;
            case 1 :
                FrangmentDanhKy fragmentDangKy = new FrangmentDanhKy();
                return fragmentDangKy;

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0 :
                return "Đăng nhập";
            case 1 :
                return "Đăng ký";

            default: return null;
        }

    }
}

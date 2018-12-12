package com.traudat.smartedu.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.traudat.smartedu.View.TrangChu.Fragment.FragmentCamera;
import com.traudat.smartedu.View.TrangChu.Fragment.FragmentDangKyNhapHoc;
import com.traudat.smartedu.View.TrangChu.Fragment.FragmentThongBao;
import com.traudat.smartedu.View.TrangChu.Fragment.FragmentThucDon;
import com.traudat.smartedu.View.TrangChu.Fragment.FragmentTrangChu;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentTitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList.add(new FragmentTrangChu());
        fragmentList.add(new FragmentThucDon());
        fragmentList.add(new FragmentThongBao());
        fragmentList.add(new FragmentDangKyNhapHoc());
        fragmentList.add(new FragmentCamera());

        fragmentTitle.add("Trang chủ");
        fragmentTitle.add("Thực đơn");
        fragmentTitle.add("Thông báo");
        fragmentTitle.add("Đăng ký nhập học");
        fragmentTitle.add("Camera");
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }
}

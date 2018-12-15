package com.traudat.smartedu.View.TrangChu.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.traudat.smartedu.Adapter.AdapterQuanLyKhoaHoc;
import com.traudat.smartedu.Model.ObjectClass.KhoaHoc;
import com.traudat.smartedu.Model.ObjectClass.QuanLyKhoaHoc;
import com.traudat.smartedu.Presenter.KhoaHoc.PresenterLogicKhoaHoc;
import com.traudat.smartedu.R;
import com.traudat.smartedu.View.TrangChu.ViewKhoaHoc;

import java.util.ArrayList;
import java.util.List;

public class FragmentDangKyNhapHoc extends Fragment implements ViewKhoaHoc {

    RecyclerView recyclerView;
    List<KhoaHoc> quanLyKhoaHocList;;
    PresenterLogicKhoaHoc presenterLogicKhoaHoc;
    List<KhoaHoc> khoaHocList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_fragmentdangkynhaphoc,container,false);

        recyclerView = view.findViewById(R.id.recyclerKhoaHoc);

        presenterLogicKhoaHoc = new PresenterLogicKhoaHoc(this);

        quanLyKhoaHocList  = new ArrayList<>();

        presenterLogicKhoaHoc.LayDanhSachKhoaHoc();

        return view;
    }


    @Override
    public void HienThiDanhSachKhoaHoc(List<QuanLyKhoaHoc> quanLyKhoaHocs) {
        quanLyKhoaHocList = quanLyKhoaHocs;

        AdapterQuanLyKhoaHoc adapterQuanLyKhoaHoc = new AdapterQuanLyKhoaHoc(getContext(),quanLyKhoaHocList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterQuanLyKhoaHoc);

        adapterQuanLyKhoaHoc.notifyDataSetChanged();
    }

    @Override
    public void HienThiDanhSach(List<KhoaHoc> khoaHocs) {
        quanLyKhoaHocList = khoaHocs;

        AdapterQuanLyKhoaHoc adapterQuanLyKhoaHoc = new AdapterQuanLyKhoaHoc(getContext(),quanLyKhoaHocList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterQuanLyKhoaHoc);

        adapterQuanLyKhoaHoc.notifyDataSetChanged();
    }
}

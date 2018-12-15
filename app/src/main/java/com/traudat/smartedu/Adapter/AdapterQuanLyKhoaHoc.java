package com.traudat.smartedu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.traudat.smartedu.Model.ObjectClass.QuanLyKhoaHoc;
import com.traudat.smartedu.R;

import java.util.List;

public class AdapterQuanLyKhoaHoc extends RecyclerView.Adapter<AdapterQuanLyKhoaHoc.ViewHolderQuanLyKhoaHoc> {


    Context context;
    List<QuanLyKhoaHoc> quanLyKhoaHocList;

    public AdapterQuanLyKhoaHoc(Context context, List<QuanLyKhoaHoc> quanLyKhoaHocList) {
        this.context = context;
        this.quanLyKhoaHocList = quanLyKhoaHocList;
    }

    public class ViewHolderQuanLyKhoaHoc extends RecyclerView.ViewHolder {

        RecyclerView recyclerViewDanhSachKhoaHoc;

        public ViewHolderQuanLyKhoaHoc(@NonNull View itemView) {
            super(itemView);

            recyclerViewDanhSachKhoaHoc = itemView.findViewById(R.id.recyclerDanhSachKhoaHoc);


        }
    }

    @NonNull
    @Override
    public AdapterQuanLyKhoaHoc.ViewHolderQuanLyKhoaHoc onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_recycler_dangkykhoahoc,viewGroup,false);

        ViewHolderQuanLyKhoaHoc viewHolderQuanLyKhoaHoc = new ViewHolderQuanLyKhoaHoc(view);

        return viewHolderQuanLyKhoaHoc;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterQuanLyKhoaHoc.ViewHolderQuanLyKhoaHoc viewHolderQuanLyKhoaHoc, int i) {
        QuanLyKhoaHoc quanLyKhoaHoc = quanLyKhoaHocList.get(i);

        AdapterKhoaHoc adapterKhoaHoc = new AdapterKhoaHoc(context,R.layout.custom_layout_dangkykhoahoc,quanLyKhoaHoc.getKhoaHocs());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);


        viewHolderQuanLyKhoaHoc.recyclerViewDanhSachKhoaHoc.setLayoutManager(layoutManager);
        viewHolderQuanLyKhoaHoc.recyclerViewDanhSachKhoaHoc.setAdapter(adapterKhoaHoc);
    }

    @Override
    public int getItemCount() {
        return quanLyKhoaHocList.size();
    }


}

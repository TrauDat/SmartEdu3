package com.traudat.smartedu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.traudat.smartedu.Model.ObjectClass.KhoaHoc;
import com.traudat.smartedu.R;

import java.util.List;

public class AdapterKhoaHoc extends RecyclerView.Adapter<AdapterKhoaHoc.ViewHolderKhoaHoc> {


    Context context;
    List<KhoaHoc> khoaHocList;

    public AdapterKhoaHoc(Context context, List<KhoaHoc> khoaHocList) {
        this.context = context;
        this.khoaHocList = khoaHocList;
    }


    public class ViewHolderKhoaHoc extends RecyclerView.ViewHolder {
        ImageView imKhoaHoc;
        RecyclerView recyclerKhoaHoc;

        public ViewHolderKhoaHoc(@NonNull View itemView) {
            super(itemView);
            recyclerKhoaHoc = itemView.findViewById(R.id.recyclerDanhSachKhoaHoc);
            imKhoaHoc = itemView.findViewById(R.id.imKhoaHoc);

        }
    }


    @NonNull
    @Override
    public AdapterKhoaHoc.ViewHolderKhoaHoc onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_recycler_dangkykhoahoc,viewGroup,false);

        ViewHolderKhoaHoc viewHolderKhoaHoc = new ViewHolderKhoaHoc(view);
        return viewHolderKhoaHoc;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKhoaHoc.ViewHolderKhoaHoc viewHolderKhoaHoc, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

}

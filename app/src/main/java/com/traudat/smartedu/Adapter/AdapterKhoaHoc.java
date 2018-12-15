package com.traudat.smartedu.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.traudat.smartedu.Model.ObjectClass.KhoaHoc;
import com.traudat.smartedu.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class AdapterKhoaHoc extends RecyclerView.Adapter<AdapterKhoaHoc.ViewHolderKhoaHoc> {


    Context context;
    List<KhoaHoc> khoaHocList;
    int layout;

    public AdapterKhoaHoc(Context context,int layout, List<KhoaHoc> khoaHocList) {
        this.context = context;
        this.khoaHocList = khoaHocList;
        this.layout = layout;
    }


    public class ViewHolderKhoaHoc extends RecyclerView.ViewHolder {
        ImageView imKhoaHoc;

        TextView txtTenKhoaHoc,txtHocPhi;
        CardView cardView;


        public ViewHolderKhoaHoc(@NonNull View itemView) {
            super(itemView);
            imKhoaHoc = itemView.findViewById(R.id.imKhoaHoc);
            txtTenKhoaHoc = itemView.findViewById(R.id.txtTenKhoaHoc);
            txtHocPhi = itemView.findViewById(R.id.txtHocPhi);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }


    @NonNull
    @Override
    public AdapterKhoaHoc.ViewHolderKhoaHoc onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layout,viewGroup,false);

        ViewHolderKhoaHoc viewHolderKhoaHoc = new ViewHolderKhoaHoc(view);
        return viewHolderKhoaHoc;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterKhoaHoc.ViewHolderKhoaHoc viewHolderKhoaHoc, int i) {
        KhoaHoc khoaHoc = khoaHocList.get(i);

        Picasso.with(context).load(khoaHoc.getANHBIA()).resize(70,70).centerInside().into(viewHolderKhoaHoc.imKhoaHoc);
        viewHolderKhoaHoc.txtTenKhoaHoc.setText(khoaHoc.getTENKHOAHOC());

        int giaTien = khoaHoc.getHOCPHI();
        NumberFormat numberFormat = new DecimalFormat("###,###");
        String gia = numberFormat.format(giaTien);

        viewHolderKhoaHoc.txtHocPhi.setText(gia + "VNĐ");

        viewHolderKhoaHoc.cardView.setTag(khoaHoc.getMAKHOAHOC());




    }

    @Override
    public int getItemCount() {
        return khoaHocList.size();
    }

}

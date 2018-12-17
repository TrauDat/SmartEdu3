package com.traudat.smartedu.Model.ChiTietKhoaHoc;

import com.traudat.smartedu.ConnectInternet.DownloadJSON;
import com.traudat.smartedu.Model.ObjectClass.ChiTietKhoaHoc;
import com.traudat.smartedu.Model.ObjectClass.KhoaHoc;
import com.traudat.smartedu.View.TrangChu.TrangChuActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelChiTietKhoaHoc {
    public KhoaHoc DanhSachChiTietKhoaHoc(int makhoahoc){


        KhoaHoc khoaHoc = new KhoaHoc();
        List<ChiTietKhoaHoc> chiTietKhoaHocs = new ArrayList<>();

        List<HashMap<String,String>> attrs= new ArrayList<>();
        String dataJSON= "";

        String duongdan = TrangChuActivity.SERVER_NAME;

        HashMap<String,String> hsHam= new HashMap<>();
        hsHam.put("ham","LayChiTietKhoaHocTheoMaKhoaHoc");

        HashMap<String,String> hsMAKH = new HashMap<>();
        hsMAKH.put("makhoahoc",String.valueOf(makhoahoc));

        attrs.add(hsHam);
        attrs.add(hsMAKH);

        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();

            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonArrayDanhSachChiTietKhoaHoc = jsonObject.getJSONArray("CHITIETKHOAHOC");
            int dem = jsonArrayDanhSachChiTietKhoaHoc.length();

            for (int i=0;i< dem;i++){



                JSONObject object = jsonArrayDanhSachChiTietKhoaHoc.getJSONObject(i);
                ChiTietKhoaHoc chiTietKhoaHoc = new ChiTietKhoaHoc();

                chiTietKhoaHoc.setDIACHI(object.getString("DIACHI"));
                chiTietKhoaHoc.setNGAYBATDAU(object.getString("NGAYBATDAU"));
                chiTietKhoaHoc.setNGAYKETTHUC(object.getString("NGAYKETTHUC"));
                chiTietKhoaHoc.setTENGIANGVIEN(object.getString("TENGIANGVIEN"));


                chiTietKhoaHocs.add(chiTietKhoaHoc);
            }

            khoaHoc.setChiTietKhoaHocList(chiTietKhoaHocs);

        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }catch (JSONException e){
            e.printStackTrace();
        }

        return khoaHoc;
    }
}

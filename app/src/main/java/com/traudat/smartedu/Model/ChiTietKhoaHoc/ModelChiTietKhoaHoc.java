package com.traudat.smartedu.Model.ChiTietKhoaHoc;

import android.util.Log;

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
//    public KhoaHoc DanhSachChiTietKhoaHoc(int makhoahoc){
//
//
//        KhoaHoc khoaHoc = new KhoaHoc();
//        List<ChiTietKhoaHoc> chiTietKhoaHocs = new ArrayList<>();
//
//        List<HashMap<String,String>> attrs= new ArrayList<>();
//        String dataJSON= "";
//
//        String duongdan = TrangChuActivity.SERVER_NAME;
//
//        HashMap<String,String> hsHam= new HashMap<>();
//        hsHam.put("ham","LayChiTietKhoaHocTheoMaKhoaHoc");
//
//        HashMap<String,String> hsMAKH = new HashMap<>();
//        hsMAKH.put("makhoahoc",String.valueOf(makhoahoc));
//
//        attrs.add(hsHam);
//        attrs.add(hsMAKH);
//
//        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
//        downloadJSON.execute();
//
//        try {
//            dataJSON = downloadJSON.get();
//            Log.d("kiemtra",dataJSON.toString());
//            JSONObject jsonObject = new JSONObject(dataJSON);
//            JSONArray jsonArrayDanhSachKhoaHoc = jsonObject.getJSONArray("CHITIETKHOAHOC");
//            int dem = jsonArrayDanhSachKhoaHoc.length();
//
//            for (int i=0;i< dem;i++){
//
//                JSONObject object = jsonArrayDanhSachKhoaHoc.getJSONObject(i);
//
//                khoaHoc.setMAKHOAHOC(object.getInt("MAKHOAHOC"));
//                khoaHoc.setANHBIA(object.getString("ANHBIA"));
//                khoaHoc.setHOCPHI(object.getInt("HOCPHI"));
//                khoaHoc.setTENKHOAHOC(object.getString("TENKHOAHOC"));
//                khoaHoc.setMOTA(object.getString("MOTA"));
//
//            }
//
//            khoaHoc.setChiTietKhoaHocList(chiTietKhoaHocs);
//
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }catch (ExecutionException e){
//            e.printStackTrace();
//        }catch (JSONException e){
//            e.printStackTrace();
//        }
//
//        return khoaHoc;
//    }



    public  KhoaHoc DanhSachChiTietKhoaHoc(String tenham,String tenmang,int makhoahoc){
        KhoaHoc khoaHoc = new KhoaHoc();
        List<ChiTietKhoaHoc> chiTietKhoaHocs = new ArrayList<>();

        List<HashMap<String,String>> attrs = new ArrayList<>();
        String dataJSON = "";

       String duongdan = TrangChuActivity.SERVER_NAME;

       HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham",tenham);

        HashMap<String,String> hsMasp = new HashMap<>();
        hsMasp.put("masp",String.valueOf(makhoahoc));

        attrs.add(hsHam);
        attrs.add(hsMasp);

        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        //end phương thức post
        downloadJSON.execute();
//
        try {
            dataJSON = downloadJSON.get();

            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonArrayDanhSachSanPham = jsonObject.getJSONArray(tenmang);
           int dem = jsonArrayDanhSachSanPham.length();

           for (int i = 0; i<dem; i++){

               JSONObject object = jsonArrayDanhSachSanPham.getJSONObject(i);

               khoaHoc.setMAKHOAHOC(object.getInt("MAKHOAHOC"));
                khoaHoc.setANHBIA(object.getString("ANHBIA"));
                khoaHoc.setHOCPHI(object.getInt("HOCPHI"));
                khoaHoc.setTENKHOAHOC(object.getString("TENKHOAHOC"));
                khoaHoc.setMOTA(object.getString("MOTA"));

//                JSONArray jsonArrayThongSoKyThuat = object.getJSONArray("THONGSOKYTHUAT");
//                for (int j=0 ;j<jsonArrayThongSoKyThuat.length() ;j++){
//                    JSONObject jsonObject1 = jsonArrayThongSoKyThuat.getJSONObject(j);
//                    for(int k=0;k<jsonObject1.names().length();k++){
//                        String tenchitiet = jsonObject1.names().getString(k);
//                        ChiTietKhoaHoc chiTietSanPham = new ChiTietSanPham();
//                        chiTietSanPham.setDIACHI(tenchitiet);
//                        chiTietSanPham.setGIATRI(jsonObject1.getString(tenchitiet));
//                        chiTietSanPhams.add(chiTietSanPham);
//                    }
//                }

                khoaHoc.setChiTietKhoaHocList(chiTietKhoaHocs);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return khoaHoc;
    }
}

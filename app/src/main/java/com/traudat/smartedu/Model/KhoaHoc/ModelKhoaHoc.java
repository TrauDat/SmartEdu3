package com.traudat.smartedu.Model.KhoaHoc;

import com.traudat.smartedu.ConnectInternet.DownloadJSON;
import com.traudat.smartedu.Model.ObjectClass.KhoaHoc;
import com.traudat.smartedu.View.TrangChu.TrangChuActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelKhoaHoc {
    public List<KhoaHoc> LayDanhSachKhoaHocDuocMo(String tenham, String tenmang) {

        List<KhoaHoc> khoaHocs = new ArrayList<>();
        List<HashMap<String,String>> attrs = new ArrayList<>();
        String dataJSON = "";

        String duongdan = TrangChuActivity.SERVER_NAME;

        HashMap<String,String> hsHam = new HashMap<>();
        hsHam.put("ham",tenham);

        attrs.add(hsHam);

        DownloadJSON downloadJSON  = new DownloadJSON(duongdan,attrs);
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dataJSON);
            JSONArray jsonArrayDanhSachKhoaHoc = jsonObject.getJSONArray("DANHSACHKHOAHOC");
            int dem = jsonArrayDanhSachKhoaHoc.length();

            for (int i = 0 ; i < dem; i++){
                KhoaHoc khoaHoc = new KhoaHoc();
                JSONObject object = jsonArrayDanhSachKhoaHoc.getJSONObject(i);

                khoaHoc.setMAKHOAHOC(object.getInt("MAKHOAHOC"));
                khoaHoc.setTENKHOAHOC(object.getString("TENKHOAHOC"));
                khoaHoc.setHOCPHI(object.getInt("HOCPHI"));
                khoaHoc.setANHBIA(object.getString("ANHBIA"));

                khoaHocs.add(khoaHoc);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return khoaHocs;
    }
}

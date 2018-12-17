package com.traudat.smartedu.Model.ObjectClass;

import java.util.List;

public class KhoaHoc {
    int MAKHOAHOC,HOCPHI;
    String TENKHOAHOC,MOTA,ANHBIA;
    boolean TRANGTHAI;
    ChiTietKhoaHoc chiTietKhoaHoc;

    List<ChiTietKhoaHoc> chiTietKhoaHocList;

    public List<ChiTietKhoaHoc> getChiTietKhoaHocList() {
        return chiTietKhoaHocList;
    }

    public void setChiTietKhoaHocList(List<ChiTietKhoaHoc> chiTietKhoaHocList) {
        this.chiTietKhoaHocList = chiTietKhoaHocList;
    }


    public ChiTietKhoaHoc getChiTietKhoaHoc() {
        return chiTietKhoaHoc;
    }

    public void setChiTietKhoaHoc(ChiTietKhoaHoc chiTietKhoaHoc) {
        this.chiTietKhoaHoc = chiTietKhoaHoc;
    }







    public int getMAKHOAHOC() {
        return MAKHOAHOC;
    }

    public void setMAKHOAHOC(int MAKHOAHOC) {
        this.MAKHOAHOC = MAKHOAHOC;
    }

    public int getHOCPHI() {
        return HOCPHI;
    }

    public void setHOCPHI(int HOCPHI) {
        this.HOCPHI = HOCPHI;
    }

    public String getTENKHOAHOC() {
        return TENKHOAHOC;
    }

    public void setTENKHOAHOC(String TENKHOAHOC) {
        this.TENKHOAHOC = TENKHOAHOC;
    }

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }

    public String getANHBIA() {
        return ANHBIA;
    }

    public void setANHBIA(String ANHBIA) {
        this.ANHBIA = ANHBIA;
    }

    public boolean isTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(boolean TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }



}

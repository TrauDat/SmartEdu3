package com.traudat.smartedu.View.TrangChu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import com.traudat.smartedu.Adapter.ViewPagerAdapter;

import com.traudat.smartedu.Model.DangNhap_DangKy.ModelDangNhap;
import com.traudat.smartedu.R;
import com.traudat.smartedu.View.DangNhap_DangKy.Frangment.DangNhapActivity;

public class TrangChuActivity extends AppCompatActivity {





    public static final String SERVER_NAME = "http://maugiaosmartedu.tk/smartedu/loaisanpham.php";
    public static final String SERVER = "http://maugiaosmartedu.tk/smartedu";

//    public static final String SERVER_NAME= "http://192.168.1.107:81/weblazada/loaisanpham.php";
//    public static final String SERVER= "http://192.168.1.107:81/weblazada";
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    Menu menu;
    ModelDangNhap modelDangNhap;
    MenuItem itemDangNhap,menuITDangXuat;
    ActionBarDrawerToggle drawerToggle;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu_layout);

        viewPager = findViewById(R.id.viewpage);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        toolbar.setTitle("");


        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerToggle.syncState();


        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        modelDangNhap=new ModelDangNhap();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutrangchu,menu);

        this.menu = menu;

        itemDangNhap = menu.findItem(R.id.itDangNhap);
        menuITDangXuat = menu.findItem(R.id.itDangXuat);
        String tennv = modelDangNhap.LayCachedDangNhap(this);
        if(!tennv.equals("")){
            itemDangNhap.setTitle(tennv);
        }


        if(!tennv .equals("")){
            menuITDangXuat.setVisible(true);
        }

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        int id = item.getItemId();
        switch (id){
            case R.id.itDangNhap:
                if(modelDangNhap.LayCachedDangNhap(this).equals("")){
                    Intent iDangNhap = new Intent(this, DangNhapActivity.class);
                    startActivity(iDangNhap);
                };break;

            case R.id.itDangXuat:


                if(!modelDangNhap.LayCachedDangNhap(this).equals("")){
                    modelDangNhap.CapNhatCachedDangNhap(this,"");
                    this.menu.clear();
                    this.onCreateOptionsMenu(this.menu);
                }
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}

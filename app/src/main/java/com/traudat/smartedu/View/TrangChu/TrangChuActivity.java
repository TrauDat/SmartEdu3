package com.traudat.smartedu.View.TrangChu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.traudat.smartedu.Adapter.ViewPagerAdapter;

import com.traudat.smartedu.R;
public class TrangChuActivity extends AppCompatActivity {




    public static final String SERVER_NAME= "http://192.168.1.36:8080/SmartEdu/loaisanpham.php";
    public static final String SERVER= "http://192.168.1.36:8080/SmartEdu";
    android.support.v7.widget.Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    AppBarLayout appBarLayout;
    Menu menu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trangchu_layout);
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewpager);


        toolbar.setTitle("");


        ViewPagerAdapter adapter  = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menutrangchu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}

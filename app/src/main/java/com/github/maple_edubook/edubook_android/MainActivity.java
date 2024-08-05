package com.github.maple_edubook.edubook_android;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {
    HomeFragment homeF;
    UploadFragment imagef;
    MypageFragment mypagef;
    NavigationBarView naviMenu;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeF = new HomeFragment();
        imagef = new UploadFragment();
        mypagef = new MypageFragment();
        naviMenu = findViewById(R.id.bottom_navigation);
        menu=naviMenu.getMenu();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        naviMenu.setItemIconTintList(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeF).commit();
        naviMenu.setItemIconSize(150);

        naviMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.home_tab){
                    item.setIcon(R.drawable.menuicon_t_home);
                    menu.findItem(R.id.mp_tab).setIcon(R.drawable.menuicon_f_mp);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeF).commit();
                }else if(id == R.id.cam_tab){
                    menu.findItem(R.id.mp_tab).setIcon(R.drawable.menuicon_f_mp);
                    menu.findItem(R.id.home_tab).setIcon(R.drawable.menuicon_f_home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, imagef).commit();
                }else if(id == R.id.mp_tab){
                    item.setIcon(R.drawable.menuicon_t_mp);
                    menu.findItem(R.id.home_tab).setIcon(R.drawable.menuicon_f_home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, mypagef).commit();
                }
                return false;
            }
        });


    }

}
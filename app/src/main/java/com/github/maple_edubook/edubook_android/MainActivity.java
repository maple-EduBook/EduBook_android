package com.github.maple_edubook.edubook_android;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    HomeFragment homeF;
    ImageFragment imagef;
    MypageFragment mypagef;
    NavigationBarView naviMenu;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);


        homeF = new HomeFragment();
        imagef = new ImageFragment();
        mypagef = new MypageFragment();
        naviMenu = findViewById(R.id.bottom_navigation);
        menu = naviMenu.getMenu();

        boolean imageUploaded = false;

        naviMenu.setItemIconTintList(null);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeF).commit();
        naviMenu.setItemIconSize(150);

        naviMenu.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home_tab) {
                    item.setIcon(R.drawable.menuicon_t_home);
                    menu.findItem(R.id.mp_tab).setIcon(R.drawable.menuicon_f_mp);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeF).commit();
                } else if (id == R.id.cam_tab) {
                    if (imageUploaded == true) {
                        menu.findItem(R.id.mp_tab).setIcon(R.drawable.menuicon_f_mp);
                        menu.findItem(R.id.home_tab).setIcon(R.drawable.menuicon_f_home);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, imagef).commit();
                    } else {
                        homeF.triggerPicBtn();
                    }
                } else if (id == R.id.mp_tab) {
                    item.setIcon(R.drawable.menuicon_t_mp);
                    menu.findItem(R.id.home_tab).setIcon(R.drawable.menuicon_f_home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, mypagef).commit();
                }
                return false;
            }
        });
    }
}

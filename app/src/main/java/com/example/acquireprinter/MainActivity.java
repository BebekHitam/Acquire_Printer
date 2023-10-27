package com.example.acquireprinter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.authenticate.Profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.rental.path.HomeFragment;
import com.stall.Chat;
import com.stall.FavouriteFragment;
import com.stall.MyStall;
import com.example.acquireprinter.R;

public class MainActivity extends AppCompatActivity {
    Button profile;
    BottomNavigationView navigationView;
    private DrawerLayout thedrawer;
    private long backPressedOww;
    int stackCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mengarahkan bottom navigation view ke id
        //membuat bottom navigation view xmlnya mengikuti https://developer.android.com/reference/com/google/android/material/bottomnavigation/BottomNavigationView
        navigationView = (BottomNavigationView) findViewById(R.id.navigationMain);
        moveFragment(new HomeFragment());
        //navigationView.setSelectedItemId(R.id.nav_item_home);
        //https://developer.android.com/reference/com/google/android/material/navigation/NavigationBarView.OnItemSelectedListener
        // to make value constant in the declaration of id i make value in res/values/ids
        //buatlah new ids.xml dalam value untuk membuat konstan
        //masalah konstan ini akan terus muncul dalam switch case jika tidak dibuat di values/ids.xml
        //masalah sampai sekarang belum selesai

        //------------------------------------------------------------------------------------------
        //ini membuat drawer tapi gajadi-jadi
        /*
        thedrawer = findViewById(R.id.drawer_layout);

        // Set up navigation drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, thedrawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        thedrawer.addDrawerListener(toggle);
        toggle.syncState();
        */


        /*



        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_item_home:
                        return false;
                }

                return false;
            }
        });*/


        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //case meminta untuk constant expression required, jdi pindah if else

                if (item.getItemId()==R.id.nav_item_profile){
                    moveFragment(new Profile());
                }
                if (item.getItemId()==R.id.nav_item_home){
                    moveFragment(new HomeFragment());
                }
                if (item.getItemId()==R.id.nav_item_favourite){
                    moveFragment(new FavouriteFragment());
                }
                if (item.getItemId()==R.id.nav_item_stall){
                    moveFragment(new MyStall());
                }
                if (item.getItemId()==R.id.nav_item_chat){
                    moveFragment(new Chat());
                }
                return false;
            }
        });
    }



    public void moveFragment (Fragment frame){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, frame);
        //fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


}

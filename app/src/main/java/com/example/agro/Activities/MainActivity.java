package com.example.agro.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.agro.Fragments.AddToCartFragment;
import com.example.agro.Fragments.HomeFragment;
import com.example.agro.Fragments.ProfileFragment;
import com.example.agro.Fragments.SearchFragment;
import com.example.agro.Fragments.SettingsFragment;
import com.example.agro.R;
import com.example.agro.Session.SessionManagement;
import com.example.agro.databinding.ActivityMainBinding;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainXml;
    BottomNavigationView bottomNavigationView;
    Toolbar toolBar;

    SessionManagement sessionManagement;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainXml = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainXml.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

        bottomNavigationView = findViewById(R.id.myBottomNavi);
        toolBar = findViewById(R.id.toolBar);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment temp = null;
                switch (item.getItemId()) {
                    case R.id.homeTab:
                        temp = new HomeFragment();
                        toolBar.setTitle("Home");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, temp).commit();
                        break;

                    case R.id.searchTab:
                        temp = new SearchFragment();
                        toolBar.setTitle("Search");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, temp).commit();
                        break;
                    case R.id.cartTab:
                        temp = new AddToCartFragment();
                        toolBar.setTitle("Add to Cart");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, temp).commit();
                        break;
                    case R.id.profileTab:
                        temp = new ProfileFragment();
                        toolBar.setTitle("Profile");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, temp).commit();
                        break;
                }

                return true;
            }
        });


        setSupportActionBar(toolBar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mainXml.drawer, toolBar, R.string.open, R.string.close);

        mainXml.drawer.addDrawerListener(toggle);
        toggle.syncState();

        mainXml.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment temp2 = null;
                switch (item.getItemId()) {
                    case R.id.homeTab2:
                        Toast.makeText(MainActivity.this, "siuuuuuu", Toast.LENGTH_SHORT).show();
                        temp2 = new HomeFragment();
                        toolBar.setTitle("Home");
                        mainXml.navigationView.getMenu().clear();
                        mainXml.navigationView.inflateMenu(R.menu.icon_menu);
                        bottomNavigationView.setSelectedItemId(R.id.homeTab);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, temp2).commit();
                        mainXml.drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.searchTab2:
                        temp2 = new SearchFragment();
                        toolBar.setTitle("Search");
                        mainXml.navigationView.getMenu().clear();
                        mainXml.navigationView.inflateMenu(R.menu.icon_menu);
                        bottomNavigationView.setSelectedItemId(R.id.searchTab);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, temp2).commit();
                        mainXml.drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.setting:
                        temp2 = new SettingsFragment();
                        toolBar.setTitle("Setting");
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, temp2).commit();
                        mainXml.drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.profileTab2:
                        temp2 = new ProfileFragment();
                        toolBar.setTitle("Profile");
                        mainXml.navigationView.getMenu().clear();
                        mainXml.navigationView.inflateMenu(R.menu.icon_menu);
                        bottomNavigationView.setSelectedItemId(R.id.profileTab);
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, temp2).commit();
                        mainXml.drawer.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.cartTab);

        badgeDrawable.setVisible(true);

        sessionManagement=new SessionManagement(this);
        badgeDrawable.setNumber(sessionManagement.getCartDetails().size());

    }

    @Override
    protected void onStart() {
        super.onStart();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.cartTab);

        badgeDrawable.setVisible(true);

        sessionManagement=new SessionManagement(this);
        badgeDrawable.setNumber(sessionManagement.getCartDetails().size());
    }

    @Override
    protected void onResume() {
        super.onResume();

        BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.cartTab);

        badgeDrawable.setVisible(true);

        sessionManagement=new SessionManagement(this);
        badgeDrawable.setNumber(sessionManagement.getCartDetails().size());
    }
}
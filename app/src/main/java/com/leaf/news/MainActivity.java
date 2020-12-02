package com.leaf.news;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ArrayList<String> tab_title_list = new ArrayList<>();
    private ArrayList<Fragment> fragment_list = new ArrayList<>();
    private Fragment fragment1, fragment2, fragment3, fragment4, fragment5, fragment6, fragment7;
    private MyFragmentPagerAdapter adapter;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_main);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_main:
                        break;
                    case R.id.nav_about:
                        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        break;
                }
                navigationView.setCheckedItem(R.id.nav_main);
                drawerLayout.closeDrawers();
                return true;
            }
        });

        tab_title_list.add("头条");
        tab_title_list.add("社会");
        tab_title_list.add("国内");
        tab_title_list.add("国际");
        tab_title_list.add("体育");
        tab_title_list.add("科技");
        tab_title_list.add("IT");
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(4)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(5)));
        tabLayout.addTab(tabLayout.newTab().setText(tab_title_list.get(6)));
        fragment1 = new Fragment_top();
        fragment2 = new Fragment_social();
        fragment3 = new Fragment_county();
        fragment4 = new Fragment_world();
        fragment5 = new Fragment_sport();
        fragment6 = new Fragment_tech();
        fragment7 = new Fragment_it();
        fragment_list.add(fragment1);
        fragment_list.add(fragment2);
        fragment_list.add(fragment3);
        fragment_list.add(fragment4);
        fragment_list.add(fragment5);
        fragment_list.add(fragment6);
        fragment_list.add(fragment7);
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), tab_title_list, fragment_list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            finish();
        }
    }
}
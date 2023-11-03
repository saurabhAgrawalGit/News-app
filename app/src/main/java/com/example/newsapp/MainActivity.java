package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayoutin;
    TabItem homein,sciencein,sportin,entertainmentin,techin,healthin;
    ViewPager viewPager;
    pagerAdapter pagerAdapterOBJ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayoutin=findViewById(R.id.tablayout);

        homein=findViewById(R.id.home);
        sciencein=findViewById(R.id.science);
        techin=findViewById(R.id.tech);
        entertainmentin=findViewById(R.id.Entertainment);
        healthin=findViewById(R.id.health);
        sportin=findViewById(R.id.sports);
        viewPager=findViewById(R.id.frag);

        pagerAdapterOBJ =new pagerAdapter(getSupportFragmentManager(),6);

        viewPager.setAdapter(pagerAdapterOBJ);

        tabLayoutin.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5)
                {
                    pagerAdapterOBJ.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayoutin));
    }
}
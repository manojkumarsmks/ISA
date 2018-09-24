package com.csuisa.manoj.isa;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class FromIndia extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_to_pack);

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
        viewPageAdapter.addFragment(new FragmentOne(), "ONE");
        viewPageAdapter.addFragment(new FragmentTwo(), "TWO");
        viewPageAdapter.addFragment(new FragmentThree(), "THREE");
        viewPager.setAdapter(viewPageAdapter);
    }

    class ViewPageAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragementList = new ArrayList<>();
        private final List<String> mFragementTitleList = new ArrayList<> ();

        public ViewPageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int i) {
            return mFragementList.get(i);
        }

        @Override
        public int getCount() {
            return mFragementList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragementList.add(fragment);
            mFragementTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragementTitleList.get(position);
        }
    }
}

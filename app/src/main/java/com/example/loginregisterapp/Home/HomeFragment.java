package com.example.loginregisterapp.Home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.loginregisterapp.R;
import com.example.loginregisterapp.adapters.SectionPagerAdapter;
import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment {

    View myFragment;
    ViewPager viewPager;
    TabLayout tabLayout;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment getInstance()    {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = myFragment.findViewById(R.id.viewPagerHome);
        tabLayout = myFragment.findViewById(R.id.tabLayoutHome);

        return myFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());


        adapter.addFragment(new CitasFragment(), "Citas");
        adapter.addFragment(new MascotasFragment(), "Mascotas");

        viewPager.setAdapter(adapter);
    }
}
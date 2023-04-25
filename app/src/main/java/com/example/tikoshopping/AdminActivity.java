package com.example.tikoshopping;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.tikoshopping.adapters.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AdminActivity extends AppCompatActivity {
    private BottomNavigationView btnNavigationViewAdmin;
    private ViewPager mViewPagerAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_admin);

        btnNavigationViewAdmin = findViewById(R.id.bottom_nav_admin);
        mViewPagerAdmin  = findViewById(R.id.view_pager_admin);
        setUpViewPager();

        btnNavigationViewAdmin.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_user:
                        mViewPagerAdmin.setCurrentItem(0);
                        break;
                    case R.id.navigation_pending:
                        mViewPagerAdmin.setCurrentItem(1);
                        break;
                    case R.id.navigation_profile_admin:
                        mViewPagerAdmin.setCurrentItem(2);
                        break;
                }

                return true;
            }
        });
    }

    private void setUpViewPager()
    {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPagerAdmin.setAdapter(viewPagerAdapter);

        // vuot sang de chuyen fragment

        mViewPagerAdmin.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        btnNavigationViewAdmin.getMenu().findItem(R.id.navigation_user).setChecked(true);
                        break;
                    case 1:
                        btnNavigationViewAdmin.getMenu().findItem(R.id.navigation_pending).setChecked(true);
                        break;
                    case 2:
                        btnNavigationViewAdmin.getMenu().findItem(R.id.navigation_profile_admin).setChecked(true);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}

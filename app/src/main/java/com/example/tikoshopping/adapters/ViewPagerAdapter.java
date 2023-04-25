package com.example.tikoshopping.adapters;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tikoshopping.CartFragment;
import com.example.tikoshopping.HomeAdminFragment;
import com.example.tikoshopping.HomeFragment;
import com.example.tikoshopping.ProfileFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new CartFragment();
            case 2:
                return new ProfileFragment();
            case 3:
                return new HomeAdminFragment();
            case 4:
                return new HomeAdminFragment();
            case 5:
                return new HomeAdminFragment();


        }
        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return 6;
    }

}

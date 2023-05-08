package com.example.tikoshopping.adapters;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tikoshopping.AdminProfileActivity;
import com.example.tikoshopping.CartFragment;
import com.example.tikoshopping.HomeAdminFragment;
import com.example.tikoshopping.HomeFragment;
import com.example.tikoshopping.ProfileFragment;
import com.example.tikoshopping.PendingFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private int logintype = 0;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, int logintype) {
        super(fm, behavior);
        this.logintype = logintype;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (logintype==1) {
            position = 3;
            logintype = 0;
        }
        else if (logintype==2) {
            position = 0;
            logintype = 0;
        }
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
                return new PendingFragment();
            case 5:
                return new AdminProfileActivity();
        }
        return new HomeAdminFragment();
    }

    @Override
    public int getCount() {
        return 6;
    }

}

package Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.First_Fragment;
import fragment.Login_Fragment;
import fragment.Second_Fragment;


/**
 * Created by wolfsoft on 10/11/2015.
 */
public class SignupWithMobileNumPagerAdapter extends FragmentStatePagerAdapter {



    public SignupWithMobileNumPagerAdapter(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Login_Fragment tab1 = new Login_Fragment();
                return tab1;

            case 1:
                Login_Fragment tab6 = new Login_Fragment();
                return tab6;



            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
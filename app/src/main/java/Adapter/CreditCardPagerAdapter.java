package Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.First_Fragment;
import fragment.Second_Fragment;


/**
 * Created by wolfsoft on 10/11/2015.
 */
public class CreditCardPagerAdapter extends FragmentStatePagerAdapter {



    public CreditCardPagerAdapter(FragmentManager fm) {
        super(fm);

    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                First_Fragment tab1 = new First_Fragment();
                return tab1;

            case 1:
                Second_Fragment tab6 = new Second_Fragment();
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
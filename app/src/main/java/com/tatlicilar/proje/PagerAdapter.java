package com.tatlicilar.proje;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import fragment.OneFragment;

/**
 * Created by sezinkokum on 18.08.2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter{
        int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    OneFragment tab1 = new OneFragment();
                    return tab1;
                case 1:
                    fragment.TwoFragment tab2 = new fragment.TwoFragment();
                    return tab2;
                case 2:
                    fragment.ThreeFragment tab3 = new fragment.ThreeFragment();
                    return tab3;
                default:
                    return null;
            }
        }

    @Override
    public int getCount() {
        return 0;
    }
}

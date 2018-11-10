package com.dsman.uaapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;

public class View_Pager extends AppCompatActivity {

    private static final int NUM_PAGES = 2;

    @BindView(R.id.pager) ViewPager mPager;
    private PagerAdapter mPagerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__pager);
        ButterKnife.bind(this);
        mPagerAdapter = new ScreenSlideFragment(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);



    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
    private int numOfTabs;




    public int getCount() {
        return numOfTabs;
    }
    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlideFragment extends FragmentStatePagerAdapter {
        public ScreenSlideFragment(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new FormDataFrag1();
                case 1:
                    return new FormDataFrag1();
                default:
                    return new FormDataFrag1();
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }


    }



}

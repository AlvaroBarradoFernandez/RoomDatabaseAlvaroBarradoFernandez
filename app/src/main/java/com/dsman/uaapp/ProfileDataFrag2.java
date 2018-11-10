package com.dsman.uaapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import butterknife.BindView;

public class ProfileDataFrag2 extends Fragment {
    @BindView(R.id.frag2)
    FrameLayout mPag2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View mView;
        mView = inflater.inflate(R.layout.activity_profile_data, container, false);

        return  mView;
    }

}

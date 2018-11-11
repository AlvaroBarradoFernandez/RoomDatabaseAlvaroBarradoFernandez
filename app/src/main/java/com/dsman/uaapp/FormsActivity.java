package com.dsman.uaapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.dsman.uaapp.General_Course.General_Course;


public class FormsActivity extends FragmentActivity implements FormDataFrag1.OnFragmentInteractionListener {

    private User user;
    public static final String USER = "USER";



    public static Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_forms);
        if (findViewById(R.id.pager) != null) {
            if (savedInstanceState != null) {
                return;
            }
            FormDataFrag1 formDataFragment = new FormDataFrag1();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.pager, formDataFragment).commit();
        }

    }


    @Override
    public void comunicationWithButtonClickNext(View view) {

        ProfileDataFrag2 profileDataFrag2 = new ProfileDataFrag2();
        Bundle args = new Bundle();
        args.putParcelable(USER, user);
        profileDataFrag2.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        transaction.replace(R.id.pager, profileDataFrag2);
        transaction.addToBackStack(null);

        transaction.commit();
    }

    public static Context getContextOfApplication() {
        return mContext;
    }



    public void comunicationWithButtonClickSave(View view) {
        Intent intent = new Intent(this, General_Course.class);
        startActivity(intent);
    }


    public void comunicationWithButtonClickSkip(View view) {
        Intent intent = new Intent(this, General_Course.class);
        startActivity(intent);
    }
}


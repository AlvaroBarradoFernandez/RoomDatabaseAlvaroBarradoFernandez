package com.dsman.uaapp.General_Course;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsman.uaapp.FormsActivity;
import com.dsman.uaapp.MainActivity;
import com.dsman.uaapp.ProfileDataFrag2;
import com.dsman.uaapp.R;
import com.dsman.uaapp.User;

import java.io.FileNotFoundException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;

public class General_Course extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Toolbar toolbar;
    private  TextView mName;
    private TextView mSurname;
    private ImageView mImageView;
    public static final String USER = "USER";
    private static User user;
    private String mUri, sUserName, sSurname, sEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_course);
         mName = findViewById(R.id.textView1);
        mSurname = findViewById(R.id.textView2);
        mImageView = findViewById(R.id.imageViewU);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerActivity
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //TODO Arreglar esto XD;
        user = new User();
       Intent intent_receive = this.getIntent();
        if(intent_receive != null){
            user = (User) intent_receive.getParcelableExtra(MainActivity.USER);
             mUri = user.getUrl();
             sEmail = user.getEmail();
             sUserName = user.getName();
             sSurname = user.getSurname();

        }

//        mName.setText(sUserName);
//        mSurname.setText(sSurname);

        try {
            Context mContext = FormsActivity.getContextOfApplication();
            if (mUri != null) {

                Uri mUserImage = Uri.parse(mUri);
                final InputStream imageStream = mContext.getContentResolver().openInputStream(mUserImage);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                mImageView.setImageBitmap(selectedImage);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // specify an adapter (see also next example)
        CardView_General_Course database = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.basedatos, null),"Database Access");
        CardView_General_Course android = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.android, null),"Android");
        CardView_General_Course fct = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.fct, null),"FCT");
        CardView_General_Course computing = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.computing, null),"Computing");
        CardView_General_Course english = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.english, null),"English");
        CardView_General_Course swift = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.swift, null),"Swift");
        CardView_General_Course tfg = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.tfg, null),"TFG");
        CardView_General_Course odoo = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.odoo, null),"Management");
        CardView_General_Course company = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.company, null),"Company");
        CardView_General_Course[] elementos = {database,android,fct,computing,english,swift,tfg,odoo, company};
        mAdapter = new RecyclerAdapter_General_Course(elementos);
        mRecyclerView.setAdapter(mAdapter);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onclicklogout(MenuItem item) {
        //TODO Intentar arreglar el Warning
        Intent navigate = new Intent(General_Course.this, MainActivity.class);
        navigate.setFlags(navigate.FLAG_ACTIVITY_NEW_TASK | navigate.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(navigate);
        finish();
    }
}
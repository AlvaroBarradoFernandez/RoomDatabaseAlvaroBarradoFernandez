package com.dsman.uaapp;

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

public class General_Course extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_course);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerActivity
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        CardView_General_Course usuario1 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Usuario1");
        CardView_General_Course usuario2 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Usuario2");
        CardView_General_Course usuario3 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Usuario3");
        CardView_General_Course usuario4 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Usuario4");
        CardView_General_Course usuario5 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Usuario5");
        CardView_General_Course usuario6 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Usuario6");
        CardView_General_Course usuario7 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Usuario7");
        CardView_General_Course usuario8 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Usuario8");
        CardView_General_Course[] elementos = {usuario1,usuario2,usuario3,usuario4,usuario5,usuario6,usuario7,usuario8};
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
}

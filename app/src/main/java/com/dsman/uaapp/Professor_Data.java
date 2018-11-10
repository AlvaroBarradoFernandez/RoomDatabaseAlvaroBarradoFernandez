package com.dsman.uaapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class Professor_Data extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView mRecyclerViewSubjects;
    private RecyclerView.Adapter mAdapterSubjects;
    private RecyclerView.LayoutManager mLayoutManagerSubjects;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_course);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mRecyclerViewSubjects = (RecyclerView) findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerActivity
        mRecyclerViewSubjects.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManagerSubjects = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewSubjects.setLayoutManager(mLayoutManagerSubjects);

        // specify an adapter (see also next example)
        CardView_General_Course asignatura1 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura1");
        CardView_General_Course asignatura2 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura2");
        CardView_General_Course asignatura3 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura3");
        CardView_General_Course asignatura4 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura4");
        CardView_General_Course asignatura5 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura5");
        CardView_General_Course asignatura6 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura6");
        CardView_General_Course asignatura7 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura7");
        CardView_General_Course asignatura8 = new CardView_General_Course(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura8");
        CardView_General_Course[] elementos = {asignatura1,asignatura2,asignatura3,asignatura4,asignatura5,asignatura6,asignatura7,asignatura8};
        mAdapterSubjects = new RecyclerAdapter_General_Course(elementos);
        mRecyclerViewSubjects.setAdapter(mAdapterSubjects);
        mRecyclerViewSubjects.setAdapter(mAdapterSubjects);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_subjects);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout_subjects);
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

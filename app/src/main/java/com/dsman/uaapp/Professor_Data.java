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

public class Professor_Data extends AppCompatActivity {
    private RecyclerView mRecyclerViewSubjects;
    private RecyclerView.Adapter mAdapterSubjects;
    private RecyclerView.LayoutManager mLayoutManagerSubjects;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_data);
        mRecyclerViewSubjects = (RecyclerView) findViewById(R.id.recyclerViewSubject);
        mLayoutManagerSubjects = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewSubjects.setLayoutManager(mLayoutManagerSubjects);

        // specify an adapter (see also next example)
        CardView_Professor_Data asignatura1 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura1");
        CardView_Professor_Data asignatura2 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura2");
        CardView_Professor_Data asignatura3 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura3");
        CardView_Professor_Data asignatura4 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura4");
        CardView_Professor_Data asignatura5 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura5");
        CardView_Professor_Data asignatura6 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura6");
        CardView_Professor_Data asignatura7 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura7");
        CardView_Professor_Data asignatura8 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"asignatura8");
        CardView_Professor_Data[] elementos = {asignatura1,asignatura2,asignatura3,asignatura4,asignatura5,asignatura6,asignatura7,asignatura8};
        mAdapterSubjects = new RecyclerAdapter_Professor_Data(elementos);
        mRecyclerViewSubjects.setAdapter(mAdapterSubjects);
        mRecyclerViewSubjects.setAdapter(mAdapterSubjects);

    }


}

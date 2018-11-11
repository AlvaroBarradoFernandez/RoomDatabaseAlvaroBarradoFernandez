package com.dsman.uaapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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
import android.view.View;
import android.widget.TextView;

public class Professor_Data extends AppCompatActivity {
    private RecyclerView mRecyclerViewSubjects;
    private RecyclerView.Adapter mAdapterSubjects;
    private RecyclerView.LayoutManager mLayoutManagerSubjects;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FloatingActionButton my_fab = (FloatingActionButton) findViewById(R.id.my_fab);
        setContentView(R.layout.activity_professor_data);
        mRecyclerViewSubjects = (RecyclerView) findViewById(R.id.recyclerViewSubject);
        mLayoutManagerSubjects = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewSubjects.setLayoutManager(mLayoutManagerSubjects);

        // specify an adapter (see also next example)
        CardView_Professor_Data asignatura1 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 1");
        CardView_Professor_Data asignatura2 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 2");
        CardView_Professor_Data asignatura3 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 3");
        CardView_Professor_Data asignatura4 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 4");
        CardView_Professor_Data[] elementos = {asignatura1,asignatura2,asignatura3,asignatura4};
        mAdapterSubjects = new RecyclerAdapter_Professor_Data(elementos);
        mRecyclerViewSubjects.setAdapter(mAdapterSubjects);
        mRecyclerViewSubjects.setAdapter(mAdapterSubjects);

    }


    public void onclick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("prueba@gmail.com"));
        intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        startActivity(intent.createChooser(intent, "Send email via..."));

    }
}

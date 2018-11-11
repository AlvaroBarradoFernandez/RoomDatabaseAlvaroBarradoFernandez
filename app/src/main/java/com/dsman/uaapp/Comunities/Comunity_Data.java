package com.dsman.uaapp.Comunities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dsman.uaapp.R;

public class Comunity_Data extends AppCompatActivity {
    private RecyclerView mRecyclerViewComunity;
    private RecyclerView.Adapter mAdapterComunity;
    private RecyclerView.LayoutManager mLayoutManagerComunity;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FloatingActionButton my_fab = (FloatingActionButton) findViewById(R.id.my_fab);
        setContentView(R.layout.activity_professor_data);
        mRecyclerViewComunity = (RecyclerView) findViewById(R.id.recyclerViewSubject);
        mLayoutManagerComunity = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewComunity.setLayoutManager(mLayoutManagerComunity);

        // specify an adapter (see also next example)
        CardView_Comunity_Data asignatura1 = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 1");
        CardView_Comunity_Data asignatura2 = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 2");
        CardView_Comunity_Data asignatura3 = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 3");
        CardView_Comunity_Data asignatura4 = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 4");
        CardView_Comunity_Data[] elementos = {asignatura1,asignatura2,asignatura3,asignatura4};
        mAdapterComunity = new RecyclerAdapter_Comunity_Data(elementos);
        mRecyclerViewComunity.setAdapter(mAdapterComunity);
        mRecyclerViewComunity.setAdapter(mAdapterComunity);

    }


    public void onclick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("prueba@gmail.com"));
        intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        startActivity(intent.createChooser(intent, "Send email via..."));

    }
}

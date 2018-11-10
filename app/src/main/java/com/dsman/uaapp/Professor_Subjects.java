package com.dsman.uaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Professor_Subjects extends AppCompatActivity {

    private RecyclerView mRecyclerViewSubject;
    private RecyclerView.LayoutManager mLayoutManagerSubject;
    private RecyclerView.Adapter mAdapterSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor__subjects);
            mRecyclerViewSubject = (RecyclerView) findViewById(R.id.recyclerViewSubject);
            mRecyclerViewSubject.setHasFixedSize(true);
            mLayoutManagerSubject = new LinearLayoutManager(this);
            mRecyclerViewSubject.setLayoutManager(mLayoutManagerSubject);
            mAdapterSubject = new MainAdapter();
            mRecyclerViewSubject.setAdapter(mAdapterSubject);

    }
}

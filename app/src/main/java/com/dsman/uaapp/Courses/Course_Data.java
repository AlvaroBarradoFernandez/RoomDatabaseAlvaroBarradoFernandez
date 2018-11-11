package com.dsman.uaapp.Courses;

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

public class Course_Data extends AppCompatActivity {
    private RecyclerView mRecyclerViewCourse;
    private RecyclerView.Adapter mAdapterCourse;
    private RecyclerView.LayoutManager mLayoutManagerCourse;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_data);
        mRecyclerViewCourse = (RecyclerView) findViewById(R.id.recyclerViewSubject);
        mLayoutManagerCourse = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerViewCourse.setLayoutManager(mLayoutManagerCourse);

        // specify an adapter (see also next example)
        CardView_Course_Data asignatura1 = new CardView_Course_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 1");
        CardView_Course_Data asignatura2 = new CardView_Course_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 2");
        CardView_Course_Data asignatura3 = new CardView_Course_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 3");
        CardView_Course_Data asignatura4 = new CardView_Course_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 4");
        CardView_Course_Data[] elementos = {asignatura1,asignatura2,asignatura3,asignatura4};
        mAdapterCourse = new RecyclerAdapter_Course_Data(elementos);
        mRecyclerViewCourse.setAdapter(mAdapterCourse);
        mRecyclerViewCourse.setAdapter(mAdapterCourse);

    }

}

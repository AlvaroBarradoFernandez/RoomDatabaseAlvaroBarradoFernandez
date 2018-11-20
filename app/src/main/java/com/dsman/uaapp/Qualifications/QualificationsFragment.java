package com.dsman.uaapp.Qualifications;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsman.uaapp.R;

public class QualificationsFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public QualificationsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycleview, container, false);
        configRecyclerViewNotes(view);
        configAdaparterNotes();

        return view;
    }

    public void configRecyclerViewNotes(View view){
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void configAdaparterNotes(){
        mAdapter = new QualificationsAdapter(createData());
        mRecyclerView.setAdapter(mAdapter);
    }

    public QualificationsObject[] createData() {
        QualificationsObject notes1 = new QualificationsObject("2018/11/19", "Enpresa", "5.00", "Curriculum");
        QualificationsObject notes2 = new QualificationsObject("2018/07/21", "IOS", "10.00","Post");
        QualificationsObject notes3 = new QualificationsObject("2018/08/14", "GG Empresarial", "7.00","Tabajo Final");
        QualificationsObject notes4 = new QualificationsObject("2018/12/30", "Ingles","8.50","Writing");
        QualificationsObject notes5 = new QualificationsObject("2018/09/15", "Acceso a datos","7.00","Hibernate");
        QualificationsObject notes6 = new QualificationsObject("2018/10/21", "Android","9.00","Singleton");
        QualificationsObject notes7 = new QualificationsObject("2018/09/16", "Procesos","4.90","Hilos");

        QualificationsObject[] data = {notes1,notes2,notes3,notes4,notes5,notes6,notes7};
        return data;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
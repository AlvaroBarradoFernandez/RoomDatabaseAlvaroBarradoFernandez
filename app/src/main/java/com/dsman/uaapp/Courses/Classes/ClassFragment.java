package com.dsman.uaapp.Courses.Classes;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dsman.uaapp.R;

import java.util.ArrayList;
import java.util.List;

public class ClassFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String image;
    private String name;
    private String surname;

    public ClassFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycleview, container, false);
        configRecyclerViewClass(view);
        configAdaparterClass();
        return view;
    }

    public void configRecyclerViewClass(View view){
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    public void configAdaparterClass(){
        mAdapter = new ClassAdapter(createData(), new ClassAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ClassObject item) {
                Toast.makeText(getActivity(),"Class " + item.getNameclass(),Toast.LENGTH_LONG).show();


                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    transaction.remove(prev);
                }
                transaction.addToBackStack(null);

                Class_FragmentDialog cfd = Class_FragmentDialog.newInstance(item);
                cfd.show(transaction, "dialog");
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    public List<ClassObject> createData() {
        ClassObject database = new ClassObject("Database Access",R.drawable.basedatos,"2ª Curso");
        ClassObject android = new ClassObject("Android", R.drawable.android,"2ª Curso");
        ClassObject fct = new ClassObject("FCT", R.drawable.fct,"2ª Curso");
        ClassObject computing = new ClassObject("Computing", R.drawable.computing,"2ª Curso");
        ClassObject english = new ClassObject("English", R.drawable.english,"2ª Curso");
        ClassObject swift = new ClassObject("Swift", R.drawable.swift,"2ª Curso");
        ClassObject tfg = new ClassObject("TFG", R.drawable.tfg,"2ª Curso");
        ClassObject odoo = new ClassObject("Management", R.drawable.odoo,"2ª Curso");
        ClassObject company = new ClassObject("Company", R.drawable.company,"2ª Curso");
        List<ClassObject> data = new ArrayList<>();
        data.add(database);
        data.add(android);
        data.add(fct);
        data.add(computing);
        data.add(english);
        data.add(swift);
        data.add(tfg);
        data.add(odoo);
        data.add(company);
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
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
                CardView_Class_Data data = new CardView_Class_Data(item);
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    transaction.remove(prev);
                }
                transaction.addToBackStack(null);

                Class_FragmentDialog cfd = new Class_FragmentDialog();
                cfd.newInstance(data);
                cfd.show(transaction, "dialog");
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    public List<ClassObject> createData() {
        ClassObject database = new ClassObject("Database Access",R.drawable.basedatos);
        ClassObject android = new ClassObject("Android", R.drawable.android);
        ClassObject fct = new ClassObject("FCT", R.drawable.fct);
        ClassObject computing = new ClassObject("Computing", R.drawable.computing);
        ClassObject english = new ClassObject("English", R.drawable.english);
        ClassObject swift = new ClassObject("Swift", R.drawable.swift);
        ClassObject tfg = new ClassObject("TFG", R.drawable.tfg);
        ClassObject odoo = new ClassObject("Management", R.drawable.odoo);
        ClassObject company = new ClassObject("Company", R.drawable.company);
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
package com.dsman.uaapp.Qualifications;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dsman.uaapp.R;

import java.util.ArrayList;
import java.util.List;

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
        configRecyclerViewNotification(view);
        configAdaparterNotification();
        return view;
    }

    public void configRecyclerViewNotification(View view){
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
    }
    public void configAdaparterNotification(){
        mAdapter = new QualificationsAdapter(createData(), new QualificationsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(QualificationsObject item) {
                Log.d("Celda","Informacion: "+item.toString());

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    transaction.remove(prev);
                }
                transaction.addToBackStack(null);

                /*ClassDialogFragment newFragment = ClassDialogFragment.newInstance(item);
                newFragment.show(transaction, "dialog");*/
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
    public List<QualificationsObject> createData() {
        QualificationsObject database = new QualificationsObject("Database Access");
        QualificationsObject android = new QualificationsObject("Android");
        QualificationsObject fct = new QualificationsObject("FCT");
        QualificationsObject computing = new QualificationsObject("Computing");
        QualificationsObject english = new QualificationsObject("English");
        QualificationsObject swift = new QualificationsObject("Swift");
        QualificationsObject tfg = new QualificationsObject("TFG");
        QualificationsObject odoo = new QualificationsObject("Management");
        QualificationsObject company = new QualificationsObject("Company");
        List<QualificationsObject> data = new ArrayList<>();
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
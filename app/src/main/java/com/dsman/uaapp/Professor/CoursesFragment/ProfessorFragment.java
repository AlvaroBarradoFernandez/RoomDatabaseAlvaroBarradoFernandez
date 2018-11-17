package com.dsman.uaapp.Professor.CoursesFragment;

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

import com.dsman.uaapp.R;

import java.util.ArrayList;
import java.util.List;

public class ProfessorFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ProfessorFragment() {
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
        mAdapter = new ProfessorAdapter(createData(), new ProfessorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ProfessorObject item) {
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

    public List<ProfessorObject> createData() {
        ProfessorObject cibersegurity = new ProfessorObject("Pedro",R.drawable.basedatos);
        ProfessorObject development = new ProfessorObject("Jaime", R.drawable.android);
        ProfessorObject big_data = new ProfessorObject("Laura", R.drawable.fct);
        ProfessorObject videogames = new ProfessorObject("David", R.drawable.computing);
        List<ProfessorObject> data = new ArrayList<>();
        data.add(cibersegurity);
        data.add(development);
        data.add(big_data);
        data.add(videogames);
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
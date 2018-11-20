package com.dsman.uaapp.Professor.Professor;

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

import com.dsman.uaapp.Courses.Classes.Class_FragmentDialog;
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
    // Método que configura el recycler view del fragment
    public void configRecyclerViewClass(View view){
        mRecyclerView = view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }
    //Método que configura el adapter del fragment,
    //en este metodo se hace la transicion del fragment al dialog fragmet pasando item como parametro
    public void configAdaparterClass(){
        mAdapter = new ProfessorAdapter(createData(), new ProfessorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ProfessorObject item) {

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                if (prev != null) {
                    transaction.remove(prev);
                }
                transaction.addToBackStack(null);

                Professor_FragmentDialog cfd = Professor_FragmentDialog.newInstance(item);
                cfd.show(transaction, "dialog");
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
    //Lista de datos del fragment
    public List<ProfessorObject> createData() {
        ProfessorObject pedro = new ProfessorObject("Pedro",R.drawable.pedro);
        ProfessorObject jaime = new ProfessorObject("Jaime", R.drawable.jaime);
        ProfessorObject laura = new ProfessorObject("Laura", R.drawable.fct);
        ProfessorObject meritxell = new ProfessorObject("Meritxell", R.drawable.meritxel);
        ProfessorObject david = new ProfessorObject("David", R.drawable.david);
        ProfessorObject cristina = new ProfessorObject("Pedro",R.drawable.pedro);
        ProfessorObject dani = new ProfessorObject("Jaime", R.drawable.jaime);
        ProfessorObject carlos = new ProfessorObject("Laura", R.drawable.fct);
        List<ProfessorObject> data = new ArrayList<>();
        data.add(pedro);
        data.add(jaime);
        data.add(meritxell);
        data.add(david);
        data.add(laura);
        data.add(cristina);
        data.add(dani);
        data.add(carlos);
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
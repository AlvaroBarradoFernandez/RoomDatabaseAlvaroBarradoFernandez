package com.dsman.uaapp.Comunities.FragmentComunity;

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

public class ComunityFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public ComunityFragment() {
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
        mAdapter = new ComunityAdapter(createData(), new ComunityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ComunityObject item) {
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

    public List<ComunityObject> createData() {
        ComunityObject cibersegurity = new ComunityObject("Cibersegurity",R.drawable.basedatos);
        ComunityObject development = new ComunityObject("Development", R.drawable.android);
        ComunityObject big_data = new ComunityObject("Big Data", R.drawable.fct);
        ComunityObject videogames = new ComunityObject("Videogames", R.drawable.computing);
        List<ComunityObject> data = new ArrayList<>();
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
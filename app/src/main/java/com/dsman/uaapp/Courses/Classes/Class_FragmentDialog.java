package com.dsman.uaapp.Courses.Classes;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsman.uaapp.R;

import java.util.Objects;

public class Class_FragmentDialog extends DialogFragment {

    private ImageView classImg;
    private TextView classDescription;
    private TextView className;
    private TextView classyear;
    private TextView classDescriptionTwo;
    private DrawerLayout drawer;
    private RecyclerView recycle;
    private RecyclerView.Adapter mAdapterClass;
    private RecyclerView.LayoutManager mLayoutManagerClass;
    private FloatingActionButton my_fab;
    private ClassObject item;
    public static final String CLASS = "CLASS";

    public static Class_FragmentDialog newInstance(ClassObject classObject) {
        Class_FragmentDialog dialog = new Class_FragmentDialog();
        Bundle data = new Bundle();
        data.putParcelable(CLASS,classObject);
        dialog.setArguments(data);
        return dialog;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
             item = getArguments().getParcelable(CLASS);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_class__fragment_dialog, null);
        CardView_Class_Data num_alum = new CardView_Class_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Nº Students");
        CardView_Class_Data professor = new CardView_Class_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Professor");
        CardView_Class_Data average = new CardView_Class_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Average");
        CardView_Class_Data my_average = new CardView_Class_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"My Average");
        CardView_Class_Data ranking = new CardView_Class_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Ranking");
        CardView_Class_Data[] elementos = {num_alum,professor,average,my_average, ranking};
        builder.setMessage("This is my dialog.....").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        className = view.findViewById(R.id.name_class);
        classyear = view.findViewById(R.id.year_class);
        classImg = view.findViewById(R.id.img_class);
        drawer = view.findViewById(R.id.drawer_layout_class);
        recycle = view.findViewById(R.id.recyclerViewClass);
        classDescription = view.findViewById(R.id.description);
        classDescriptionTwo = view.findViewById(R.id.text_desc);
        mLayoutManagerClass = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recycle.setLayoutManager(mLayoutManagerClass);
        updateDialog(item);
        mAdapterClass = new RecyclerAdapter_Class_Data(elementos);
        recycle.setAdapter(mAdapterClass);
        my_fab = view.findViewById(R.id.my_fab);
    return dialog;
    }

    public void updateDialog(ClassObject item){
        if (item!=null) {
            className.setText(item.getNameclass());
            classImg.setImageResource(item.getImgclass());
        }
    }

    public void onclick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("prueba@gmail.com"));
        intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        startActivity(intent.createChooser(intent, "Send email via..."));

    }

}

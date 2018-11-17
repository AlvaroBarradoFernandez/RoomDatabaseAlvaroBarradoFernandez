package com.dsman.uaapp.Comunities;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.dsman.uaapp.R;
import java.util.Objects;

public class Comunity_FragmentDialog extends AppCompatDialogFragment {

    private ImageView logo;
    private TextView description;
    private TextView title_comunity;
    private TextView name_comunity;
    private TextView text_description;
    private TextView topic_name;
    private DrawerLayout drawer;
    private RecyclerView recycle;
    private RecyclerView.Adapter mAdapterComunity;
    private RecyclerView.LayoutManager mLayoutManagerComunity;

    public Dialog onCreateDialog(Bundle savedInstaceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_comunity__fragment_dialog, null);
        CardView_Comunity_Data asignatura1 = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 1");
        CardView_Comunity_Data asignatura2 = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 2");
        CardView_Comunity_Data asignatura3 = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 3");
        CardView_Comunity_Data asignatura4 = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Computing 4");
        CardView_Comunity_Data[] elementos = {asignatura1,asignatura2,asignatura3,asignatura4};
        builder.setView(view)
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                })
                .setPositiveButton("acept", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                    }
                });
        title_comunity = view.findViewById(R.id.title_Comunity);
        name_comunity = view.findViewById(R.id.name_comunity);
        logo = view.findViewById(R.id.imgcomunity);
        topic_name = view.findViewById(R.id.title_topic);
        drawer = view.findViewById(R.id.drawer_layout_comunity);
        recycle = view.findViewById(R.id.recyclerViewComunity);
        description = view.findViewById(R.id.description);
        text_description = view.findViewById(R.id.text_desc);
        mLayoutManagerComunity = new GridLayoutManager(view.getContext(), 1);
        recycle.setLayoutManager(mLayoutManagerComunity);
        mAdapterComunity = new RecyclerAdapter_Comunity_Data(elementos);
        recycle.setAdapter(mAdapterComunity);

    return builder.create();
    }

}

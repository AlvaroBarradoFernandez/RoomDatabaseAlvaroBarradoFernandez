package com.dsman.uaapp.Comunities;

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
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsman.uaapp.Comunities.FragmentComunity.ComunityObject;
import com.dsman.uaapp.R;
import java.util.Objects;

public class Comunity_FragmentDialog extends DialogFragment {

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
    private FloatingActionButton my_fab;
    private ComunityObject item;
    public static final String COMUNITY = "COMUNITY";

    public static Comunity_FragmentDialog newInstance(ComunityObject comunityObject) {
        Comunity_FragmentDialog dialog = new Comunity_FragmentDialog();
        Bundle data = new Bundle();
        data.putParcelable(COMUNITY,comunityObject);
        dialog.setArguments(data);
        return dialog;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable(COMUNITY);
        }
    }

    public Dialog onCreateDialog(Bundle savedInstaceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_comunity__fragment_dialog, null);
        CardView_Comunity_Data num_alumComunity = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Nº Students");
        CardView_Comunity_Data classroom = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Classroom");
        CardView_Comunity_Data events = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Events");
        CardView_Comunity_Data projects = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Projects");
        CardView_Comunity_Data valuation = new CardView_Comunity_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null), "Valuation");
        CardView_Comunity_Data[] elementos = {num_alumComunity,classroom,events,projects,valuation};
        builder.setView(view);
        title_comunity = view.findViewById(R.id.title_Comunity);
        name_comunity = view.findViewById(R.id.name_comunity);
        logo = view.findViewById(R.id.imgcomunity);
        topic_name = view.findViewById(R.id.title_topic);
        drawer = view.findViewById(R.id.drawer_layout_comunity);
        recycle = view.findViewById(R.id.recyclerViewComunity);
        description = view.findViewById(R.id.description);
        text_description = view.findViewById(R.id.text_desc);
        mLayoutManagerComunity = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recycle.setLayoutManager(mLayoutManagerComunity);
        updateDialog(item);
        mAdapterComunity = new RecyclerAdapter_Comunity_Data(elementos);
        recycle.setAdapter(mAdapterComunity);
        my_fab = view.findViewById(R.id.my_fab);

        return builder.create();
    }

    public void updateDialog(ComunityObject item){
        if (item!=null) {
            name_comunity.setText(item.getNamecomunity());
            logo.setImageResource(item.getImgcomunity());
        }
    }

    public void onclick(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL, "prueba@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT,"subject");
        intent.putExtra(Intent.EXTRA_TEXT,"text");
        startActivity(Intent.createChooser(intent,"Send Email via..."));

    }
}
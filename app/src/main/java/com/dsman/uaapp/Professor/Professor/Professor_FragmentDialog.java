package com.dsman.uaapp.Professor.Professor;

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

import com.dsman.uaapp.Comunities.CardView_Comunity_Data;
import com.dsman.uaapp.Comunities.RecyclerAdapter_Comunity_Data;
import com.dsman.uaapp.R;

import java.util.Objects;

public class Professor_FragmentDialog extends DialogFragment {

    private ImageView professorImg;
    private TextView professorDescription;
    private TextView professorName;
    private TextView professorSurname;
    private TextView professorDescriptionTwo;
    private DrawerLayout drawer;
    private RecyclerView recycle;
    private RecyclerView.Adapter mAdapterProfessor;
    private RecyclerView.LayoutManager mLayoutManagerProfessor;
    private FloatingActionButton my_fab;
    private ProfessorObject item;
    public static final String TEACHER = "TEACHER";
    //Método para recoger el objeto que lo pasas como parametro en el fragment
    //Creo un nuevo dialogo para poner los argumentos del objeton en el dialogo creado
    public static Professor_FragmentDialog newInstance(ProfessorObject teacherObject) {
        Professor_FragmentDialog dialog = new Professor_FragmentDialog();
        Bundle data = new Bundle();
        data.putParcelable(TEACHER,teacherObject);
        dialog.setArguments(data);
        return dialog;
    }
    //Aqui recoges los argumentos del objeto y se los igualas al objeto del dialog fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            item = getArguments().getParcelable(TEACHER);
        }
    }
    //En estas lineas de codigo se crea el AlertDialog poniendo los datos del cardview y del objeto anteriormente escogido
    public Dialog onCreateDialog(Bundle savedInstaceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = Objects.requireNonNull(getActivity()).getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_professor__fragment_dialog, null);
        CardView_Professor_Data subject1 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Subject 1");
        CardView_Professor_Data subject2 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Subject 2");
        CardView_Professor_Data subject3 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Subject 3");
        CardView_Professor_Data subject4 = new CardView_Professor_Data(ResourcesCompat.getDrawable(getResources(), R.drawable.u_logo, null),"Subject 4");
        CardView_Professor_Data[] elements = {subject1,subject2,subject3,subject4};
        builder.setView(view).setPositiveButton("Email", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:teacher@u-tad.com"));
                startActivity(Intent.createChooser(emailIntent,"Send Email via..."));
            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {


                    }
                });
        professorName = view.findViewById(R.id.name_professor);
        professorSurname = view.findViewById(R.id.surname_professor);
        professorImg = view.findViewById(R.id.img_professor);
        drawer = view.findViewById(R.id.drawer_layout_professor);
        recycle = view.findViewById(R.id.recyclerViewProfessor);
        professorDescription = view.findViewById(R.id.description);
        professorDescriptionTwo = view.findViewById(R.id.text_desc);
        mLayoutManagerProfessor = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recycle.setLayoutManager(mLayoutManagerProfessor);
        updateDialog(item);
        mAdapterProfessor = new RecyclerAdapter_Professor_Data(elements);
        recycle.setAdapter(mAdapterProfessor);
        my_fab = view.findViewById(R.id.my_fab);
    return builder.create();
    }
    //En este método se ponen los datos del item en los textview y en la imageview
    public void updateDialog(ProfessorObject item){
        if (item!=null) {
            professorName.setText(item.getNameprofessor());
            professorImg.setImageResource(item.getImgprofessor());
            professorSurname.setText(item.getSurnameprofessor());
            professorDescriptionTwo.setText(item.getTextDescProfessor());
}
    }

}

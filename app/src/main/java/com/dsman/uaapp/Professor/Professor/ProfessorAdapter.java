package com.dsman.uaapp.Professor.Professor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsman.uaapp.R;

import java.util.List;

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.professorViewHolder> {

    private List<ProfessorObject> mDataset;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ProfessorObject item);
    }


    public ProfessorAdapter(List<ProfessorObject> myDataset, ProfessorAdapter.OnItemClickListener listener) {
        this.mDataset = myDataset;
        this.listener = listener;

    }

    @Override
    public ProfessorAdapter.professorViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recyclerview, viewGroup, false);
        return new professorViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(professorViewHolder professorViewHolder, int i) {
        final ProfessorObject item = mDataset.get(i);
        professorViewHolder.textView.setText(item.getNameprofessor());
        professorViewHolder.imageView.setImageResource(item.getImgprofessor());
        professorViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener!=null){
                    listener.onItemClick(item);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    static class professorViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;

        public professorViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.tvnameitem);
            imageView = v.findViewById(R.id.imageViewitem);
        }
    }
}

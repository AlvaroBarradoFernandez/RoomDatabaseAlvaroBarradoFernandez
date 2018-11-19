package com.dsman.uaapp.Professor.Professor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsman.uaapp.R;

import java.util.List;

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.ClassViewHolder> {

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
    public ProfessorAdapter.ClassViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recyclerview, viewGroup, false);
        return new ClassViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ClassViewHolder classViewHolder, int i) {
        final ProfessorObject item = mDataset.get(i);
        classViewHolder.textView.setText(item.getNameprofessor());
        classViewHolder.imageView.setImageResource(item.getImgprofessor());
        classViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    static class ClassViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;

        public ClassViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.tvnameitem);
            imageView = v.findViewById(R.id.imageViewitem);
        }
    }
}

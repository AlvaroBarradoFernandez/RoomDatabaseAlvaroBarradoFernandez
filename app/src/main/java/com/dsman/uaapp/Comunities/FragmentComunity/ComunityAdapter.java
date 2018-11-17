package com.dsman.uaapp.Comunities.FragmentComunity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsman.uaapp.R;

import java.util.List;

public class ComunityAdapter extends RecyclerView.Adapter<ComunityAdapter.ClassViewHolder> {

    private List<ComunityObject> mDataset;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ComunityObject item);
    }


    public ComunityAdapter(List<ComunityObject> myDataset, ComunityAdapter.OnItemClickListener listener) {
        this.mDataset = myDataset;
        this.listener = listener;

    }

    @Override
    public ComunityAdapter.ClassViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recyclerview, viewGroup, false);
        return new ClassViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ClassViewHolder classViewHolder, int i) {
        final ComunityObject item = mDataset.get(i);
        classViewHolder.textView.setText(item.getNamecomunity());
        classViewHolder.imageView.setImageResource(item.getImgcomunity());
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

        public void bind(final ComunityObject item, final OnItemClickListener listener) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}

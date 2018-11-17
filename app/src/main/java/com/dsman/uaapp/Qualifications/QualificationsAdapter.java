package com.dsman.uaapp.Qualifications;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsman.uaapp.R;

import java.util.List;

public class QualificationsAdapter extends RecyclerView.Adapter<QualificationsAdapter.NotificationViewHolder> {

    private List<QualificationsObject> mDataset;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(QualificationsObject item);
    }


    public QualificationsAdapter(List<QualificationsObject> myDataset, QualificationsAdapter.OnItemClickListener listener) {
        this.mDataset = myDataset;
        this.listener = listener;

    }

    @Override
    public QualificationsAdapter.NotificationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_recyclerview, viewGroup, false);
        return new NotificationViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder notificationViewHolder, int i) {
        final QualificationsObject item = mDataset.get(i);
        notificationViewHolder.textView.setText(item.getNameclass());
    }



    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    static class NotificationViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;

        public NotificationViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.tvnameitem);
        }
    }
}

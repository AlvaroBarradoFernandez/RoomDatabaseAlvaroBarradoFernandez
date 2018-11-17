package com.dsman.uaapp.Notifications;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dsman.uaapp.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private List<NotificationObject> mDataset;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(NotificationObject item);
    }


    public NotificationAdapter(List<NotificationObject> myDataset, NotificationAdapter.OnItemClickListener listener) {
        this.mDataset = myDataset;
        this.listener = listener;

    }

    @Override
    public NotificationAdapter.NotificationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_recyclerview, viewGroup, false);
        return new NotificationViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(NotificationViewHolder notificationViewHolder, int i) {
        final NotificationObject item = mDataset.get(i);
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

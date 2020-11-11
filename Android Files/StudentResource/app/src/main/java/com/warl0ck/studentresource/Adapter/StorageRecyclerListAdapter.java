package com.warl0ck.studentresource.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;


public class StorageRecyclerListAdapter extends RecyclerView.Adapter<StorageRecyclerListAdapter.SRViewHolder> {
    @NonNull
    @Override
    public SRViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull SRViewHolder srViewHoldere, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class SRViewHolder extends RecyclerView.ViewHolder{

        public SRViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}

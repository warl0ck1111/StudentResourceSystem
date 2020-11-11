package com.warl0ck.studentresource.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class ResourceRecyclerViewAdapter extends RecyclerView.Adapter<ResourceRecyclerViewAdapter.RRViewHolder> {
  @NonNull
  @Override
  public RRViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull RRViewHolder srViewHoldere, int i) {

  }

  @Override
  public int getItemCount() {
    return 0;
  }

  class RRViewHolder extends RecyclerView.ViewHolder{

    public RRViewHolder(@NonNull View itemView) {
      super(itemView);
    }
  }

}

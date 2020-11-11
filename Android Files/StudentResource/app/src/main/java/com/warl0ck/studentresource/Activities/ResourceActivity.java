package com.warl0ck.studentresource.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.warl0ck.studentresource.R;
import com.warl0ck.studentresource.Adapter.ResourceRecyclerViewAdapter;

public class ResourceActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    ResourceRecyclerViewAdapter mAdapter;
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource);

        recyclerView = findViewById(R.id.QUestionList);

        mAdapter = new ResourceRecyclerViewAdapter();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);
    }
}

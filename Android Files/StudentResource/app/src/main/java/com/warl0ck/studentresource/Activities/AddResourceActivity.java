package com.warl0ck.studentresource.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.warl0ck.studentresource.R;

import java.util.ArrayList;
import java.util.List;

public class AddResourceActivity extends AppCompatActivity {

    TextView username,edInstitution, edCourseTitle, edCourseCode, edDescription, edTag;
    Button addResource, getContent;
    Spinner spResourceType;
    final String Description = "Description can include meta data about the resource whether Test, past Questions, Handouts, Year, lectures name and any other details for more clearity about the resource You re uploading";
    final String tag ="keywords for finding this item resource";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resource);

        //initializing widgets
        username = findViewById(R.id.username);
        edCourseCode = findViewById(R.id.edCourseCode);
        edInstitution = findViewById(R.id.edInstitution);
        edCourseTitle = findViewById(R.id.edCourseTitle);
        edDescription = findViewById(R.id.edDescription);
        edTag = findViewById(R.id.edTag);
        spResourceType = findViewById(R.id.spResourcetype);
        getContent = findViewById(R.id.getContent);


        //button widgets
        addResource = findViewById(R.id.addResource);


        //spinner code for  listing items

        List<String> arr = new ArrayList<>();
        arr.add("Past Questions");
        arr.add("Handouts");
        arr.add("Notes");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line);
        spResourceType.setAdapter(adapter);

        getContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // intent to media library

            }
        });


        edDescription.setHint(Description);
        edTag. setHint(tag);

    }

        public void addResource(){


        }

}

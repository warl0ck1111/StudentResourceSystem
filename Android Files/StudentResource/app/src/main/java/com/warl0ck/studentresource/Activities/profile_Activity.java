package com.warl0ck.studentresource.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.warl0ck.studentresource.R;
import com.warl0ck.studentresource.data.Data;
import com.warl0ck.studentresource.model.User;

import org.json.JSONArray;

public class profile_Activity extends AppCompatActivity {

    TextView name, phone, email, institution;
    Button takePhoto;
    ImageView profilePic;
    User mUser;
    String lkjh = get().getIntent().getStringExtra("ID");

    final String TAG= "profileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);

        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        institution = findViewById(R.id.Institution);
        takePhoto = findViewById(R.id.button_user_profile_take_photo);
        profilePic = findViewById(R.id.profilePic);

      //getProfile();


    }


    public void getProfile(){

        Intent i = new Intent();

        i.getExtras().get("phone");
        i.getExtras().get("email");
        i.getExtras().get("password");


        Data.LOGGED_IN = mUser;

        name.setText(mUser.getName());
        phone.setText(mUser.getPhoneNo());
        email.setText(mUser.getEmail());
        institution.setText(null);


    }
}


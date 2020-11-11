package com.warl0ck.studentresource.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.warl0ck.studentresource.R;

import org.json.JSONArray;

public class StorageActivity extends AppCompatActivity {

     TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);


        textView = findViewById(R.id.SaTextView);

// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url ="http://localhost:8080/getUsers";

// Request a string response from the provided URL.
        JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Display the first 500 characters of the response string.
                        textView.setText("Response is: "+ response.toString());
                        System.out.println(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Response is: "+ error.toString(), Toast.LENGTH_LONG);

            }
        });




// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
}

package com.warl0ck.studentresource.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.warl0ck.studentresource.R;
import com.warl0ck.studentresource.VolleySingleton;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestActivity extends AppCompatActivity {


    EditText name, phone, email, pwd;
    Button send;
    TextView tvError;


    //system ip Address:: 192.168.43.59
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        //instantiate widgets
        name = findViewById(R.id.edName);
        phone = findViewById(R.id.edPhone);
        email = findViewById(R.id.edEmail);
        tvError = findViewById(R.id.tvError);
        pwd = findViewById(R.id.edPassword);
        send = findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

// Instantiate the RequestQueue.
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                String url ="http://localhost:8080/getUsers";

// Request a string response from the provided URL.
                JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                // Display the first 500 characters of the response string.
                                tvError.setText("Response is: "+ response.toString());
                                System.out.println(response.toString());
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        tvError.setText("That didn't work!");

                    }
                });




// Add the request to the RequestQueue.
                queue.add(stringRequest);
            }
        });
    }

    public void test(){
        String url = "http://localhost:8080/register-user";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        tvError.setText("Response: " + response.toString());
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

// Access the RequestQueue through your singleton class.
        VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectRequest);
    }
}

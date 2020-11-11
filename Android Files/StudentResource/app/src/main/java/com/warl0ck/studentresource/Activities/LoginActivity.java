package com.warl0ck.studentresource.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import com.warl0ck.studentresource.R;
import com.warl0ck.studentresource.VolleySingleton;
import com.warl0ck.studentresource.data.Data;
import com.warl0ck.studentresource.model.User;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

        private String TAG = "RegistrationActivity";
        private EditText email, pwd;
        private TextView textView2;
        private Button SignIn;
        private ProgressBar progressBar;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            SignIn = findViewById(R.id.login);
            email = findViewById(R.id.email);
            pwd = findViewById(R.id.password);
            textView2 = findViewById(R.id.textView2);


            textView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);

                }
            });


            SignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (validateForm()) {
                        signIn();

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Login validation error", Toast.LENGTH_LONG).show();
                    }

                }
            });


    }

    // @Todo
    private boolean validateForm() {
        boolean valid = true;

        // Validate Email, and Password
        String EMAIL = email.getText().toString();
        if (TextUtils.isEmpty(EMAIL)) {
            email.setError(getString(R.string.error_field_required));
            valid = false;
        } else {
            email.setError(null);
        }

        String password = pwd.getText().toString();
        if (TextUtils.isEmpty(password)) {
            pwd.setError(getString(R.string.error_field_required));
            valid = false;
        } else {
            pwd.setError(null);
        }

        return valid;
    }

    // Sign in user
    private void signIn() {
        Log.d(TAG, "signIn:" );
        if (!validateForm()) {
            return;
        }

        // Sign in user with email and password

        final String url = "http://192.168.43.59:8080/find-user"; //Network Ip of system

        final HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("email", email.getText().toString());
        hashMap.put("password", pwd.getText().toString());


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response == null){
                    Toast.makeText(getApplicationContext(), "User not found!!", Toast.LENGTH_LONG).show();
                    Log.d(TAG, "onResponse: signIn: " + response.toString());
                }
                else{
                    User user = new Gson().fromJson(response.toString(), User.class);
                    Data.LOGGED_IN = user;

                    Toast.makeText(getApplicationContext(), "Welcome "  + user.getName() +"!!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //dialog.cancel();
                try{

                    Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_LONG).show();
                    Log.e("MainActivity:save Error", error.networkResponse.statusCode + "");

                }
                catch (RuntimeException e){
                    System.out.println(e.toString());
                }
            }
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                return params;
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                return params;
            }

        };

        VolleySingleton.getInstance(getBaseContext()).addToRequestQueue(jsonObjectRequest);
    }

}

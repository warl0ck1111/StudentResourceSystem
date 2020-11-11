package com.warl0ck.studentresource.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.warl0ck.studentresource.R;
import com.warl0ck.studentresource.VolleySingleton;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {


    private String TAG = "RegistrationActivity";
    private EditText email, phone, pwd, confpwd, name;
    private Button Register;
    private TextView signIn;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Register = findViewById(R.id.register);
        email = findViewById(R.id.email);
        pwd = findViewById(R.id.password);
        confpwd = findViewById(R.id.ConfirmPassword);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        signIn = findViewById(R.id.link_login_account);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = pwd.getText().toString();
                String ConPwd = confpwd.getText().toString();
                String Name = name.getText().toString();
                String Phone = phone.getText().toString();

                if (validateForm() == true){
                    save(Name, Email,Phone,Password);

                }

            }
        });

    }

    public void save(String Name, String email, String phone, String password) {


        String url = "http://192.168.43.59:8080/register-user"; //Network Ip of system

        final HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name",Name);
        hashMap.put("phone", phone);
        hashMap.put("email", email);
        hashMap.put("password", password);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse: Object Saved to db successfull");
                Toast.makeText(getApplicationContext(), "saved to db successfull", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //dialog.cancel();
                Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_LONG).show();
                Log.e("", error.networkResponse.statusCode + "");
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

    private void updateUI(Object o) {
        if (o != null) {
            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
            //i.putExtras("user",o); write code to  pass object BUndle here
            startActivity(i);
        }
    }

//
//    private boolean isFormValidated() {
//        boolean result;
//        String Email = email.getText().toString();
//        String Password = pwd.getText().toString();
//        String Phone = phone.getText().toString();
//        String ConFirmPwd = confpwd.getText().toString();
//
//        if (!Email.equals("") || !Password.equals("") || !Phone.equals("") || !ConFirmPwd.equals("")) {
//            result = false;
//            Toast.makeText(getApplicationContext(), "please enter a valid email or Password", Toast.LENGTH_SHORT).show();
//        }
//
////        else if{
////            //line for validating with the DB
////            // return true for Success
////
////            result = false;
////        }
//        else
//            result = true;
//        return result;
//    }
//
//

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
        } String Name = name.getText().toString();
        if (TextUtils.isEmpty(password)) {
            name.setError(getString(R.string.error_field_required));
            valid = false;
        } else {
            pwd.setError(null);
        } String confPwd = confpwd.getText().toString();
        if (TextUtils.isEmpty(password)) {
            confpwd.setError(getString(R.string.error_field_required));
            valid = false;
        } else {
            pwd.setError(null);
        } String Phone = phone.getText().toString();
        if (TextUtils.isEmpty(password)) {
            confpwd.setError(getString(R.string.error_field_required));
            valid = false;
        } else {
            pwd.setError(null);
        }

        if (!TextUtils.equals(pwd.getText().toString(), confpwd.getText().toString())){
            valid = false;
            confpwd.setError("Password mismatch!");
        }

        return valid;
    }


}




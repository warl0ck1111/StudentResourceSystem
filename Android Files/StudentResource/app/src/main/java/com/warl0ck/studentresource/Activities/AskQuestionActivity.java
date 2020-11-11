package com.warl0ck.studentresource.Activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.warl0ck.studentresource.R;
import com.warl0ck.studentresource.VolleySingleton;
import com.warl0ck.studentresource.data.Data;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AskQuestionActivity extends AppCompatActivity {

    TextView edAskQuestion;
    TextView approvedAnswer;
    FloatingActionButton addQuestion;
    String TAG = "AskQuestionActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);

        edAskQuestion = findViewById(R.id.edAskQuestion);
        addQuestion = findViewById(R.id.addQuestion);


        addQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            String questionTitle = edAskQuestion.getText().toString();
            String questionDescription = edAskQuestion.getText().toString();



            final String url = "http://192.168.43.59:8080/addQuestion"; //Network Ip of system
            //get edittext fields

            final HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("questionTitle", questionTitle);
            hashMap.put("questionDescription", questionDescription);
            hashMap.put("User", Data.LOGGED_IN.getId().toString());
            hashMap.put("viewCount", null);
            hashMap.put("timestamp", null);
            hashMap.put("approvedAnswer", null);


            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, new JSONObject(hashMap), new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    if (response == null){
                        Toast.makeText(getApplicationContext(), "Question not Added!!", Toast.LENGTH_LONG).show();
                        Log.d(TAG, "onResponse: signIn: " + response.toString());
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Question Added Successfully!!", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(AskQuestionActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();

                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //dialog.cancel();
                    Toast.makeText(AskQuestionActivity.this, "Failed", Toast.LENGTH_LONG).show();
                    Log.e("MainActivity:save Error", error.networkResponse.statusCode + "");

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
        });
    }
}

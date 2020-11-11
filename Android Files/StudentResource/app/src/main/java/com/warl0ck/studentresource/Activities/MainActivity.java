package com.warl0ck.studentresource.Activities;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.warl0ck.studentresource.Adapter.QuestionRecyclerViewAdapter;
import com.warl0ck.studentresource.R;
import com.warl0ck.studentresource.data.Data;
import com.warl0ck.studentresource.model.Question;
import com.warl0ck.studentresource.model.User;

import org.json.JSONArray;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    QuestionRecyclerViewAdapter mAdapter;
    LinearLayoutManager layoutManager;
    TextView edTypeQuestion;
    private DrawerLayout mDrawerLayout;
    // Use Navigation options
    private NavigationView mNavigationView;
    private static final String TAG = "MainActivity";
    private Question[] mQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTypeQuestion = findViewById(R.id.edTypeQuestion);
        recyclerView = findViewById(R.id.QUestionList);


        recyclerView = findViewById(R.id.QUestionList);
        getQUestionsList();
        mAdapter = new QuestionRecyclerViewAdapter();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);


        edTypeQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AskQuestionActivity.class);
                startActivity(i);
            }
        });

        mNavigationView = findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);

        SearchView sv = (SearchView) menu.findItem(R.id.search).getActionView();
        SearchManager sm = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        sv.setSearchableInfo(sm.getSearchableInfo(getComponentName()));
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(), "tf are you searching?? you knw damn well u didput any info there", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        // Handle item selection
        switch (item.getItemId()) {


            case R.id.askQuestion:
                //newGame();
                //Toast.makeText(getApplicationContext(),"add question button clicked", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, AskQuestionActivity.class);
                startActivity(i);


                return true;

            case R.id.profile:
                Intent intent = new Intent(MainActivity.this, profile_Activity.class);

                User details = Data.LOGGED_IN;
                intent.putExtra("name",details.getName());
                intent.putExtra("email",details.getEmail());
                intent.putExtra("password",details.getPassword());
                intent.putExtra("phone",details.getPhoneNo());

                startActivity(intent);



            case R.id.search:
                //showHelp();
                Toast.makeText(getApplicationContext(), "Search button clicked", Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        Toast.makeText(getApplicationContext(), menuItem.getTitle() + " has been Clicked", Toast.LENGTH_LONG).show();
        if (menuItem.getItemId() == R.id.nav_home) {
            mDrawerLayout.closeDrawer(mNavigationView);



        }

        return true;
    }

    public void getQUestionsList(){


// Instantiate the RequestQueue.

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        final String url ="http://192.168.43.59:8080/getQuestionsList";

// Request a string response from the provided URL.
        final JsonArrayRequest stringRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Gson gson = new Gson();
                        Question[] questions =  gson.fromJson(response.toString(), Question[].class);
                        mQuestion = questions;
                        for(Question question : questions){
                            Log.d(TAG, "onResponse: ID" + question.getId());
                            Log.d(TAG, "onResponse: name" + question.getDescription());
                            Log.d(TAG, "onResponse: phone" + question.getQuestionTitle());
                            Log.d(TAG, "onResponse: Passwprd" + question.getApprovedAnswer());
                            Log.d(TAG, "onResponse: Email" + question.getTimestamp());

                        }
                        mAdapter.setQuestions(Arrays.asList(mQuestion));

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Response is: "+ error.toString(), Toast.LENGTH_LONG);


                    }
                });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }


}




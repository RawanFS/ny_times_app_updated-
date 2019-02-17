package com.example.rawanalsh.ny_times_app;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MostPopularListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    RequestQueue requestQueue;
    String baseUrl = "https://api.nytimes.com/svc/mostpopular/v2/viewed/1.json?api-key=fV0gAkQAeAGOtDd7CtQDQ9oEucK57N71";  // This is the API base URL (GitHub API)
    String url;
    List<MostPopularItem> articles ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_most_popular_list);
        setTitle("Most Popular Articles");
//        ArrayList<MostPopularItem> itemsList = new ArrayList<>();
//        itemsList.add(new MostPopularItem(R.drawable.nylogo, "Test Title", "Test Author" ));



        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

//        mAdapter = new MostPopularAdapter((ArrayList<MostPopularItem>) articles);


        mRecyclerView.setLayoutManager(mLayoutManager);
//        mRecyclerView.setAdapter(mAdapter);

        requestQueue = Volley.newRequestQueue(this);

        getRepoList();
    }

    private void getRepoList() {
        // First, we insert the username into the repo url.
        // The repo url is defined in GitHubs API docs (https://developer.github.com/v3/repos/).
        this.url = this.baseUrl;

        // Next, we create a new JsonArrayRequest. This will use Volley to make a HTTP request
        // that expects a JSON Array Response.
        // To fully understand this, I'd recommend readng the office docs: https://developer.android.com/training/volley/index.html

        JsonRequest<JSONObject> jsonRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.i("onSite", "response -> " + response.get("results").toString());
                            Type listType = new TypeToken<List<MostPopularItem>>() {
                            }.getType();
                            JSONArray jsonArray = new JSONArray(response.get("results").toString());
                            articles = new Gson().fromJson(String.valueOf(jsonArray), listType);
                            Log.i("length", articles.size()+ "");
                            mAdapter = new MostPopularAdapter((ArrayList<MostPopularItem>) articles,
                                    new MostPopularAdapter.OnItemClickListener() {
                                        @Override public void onItemClick(MostPopularItem item) {
                                            Intent intent = new Intent(MostPopularListActivity.this, MostPopularDetail.class);
                                            intent.putExtra("item", (Serializable) item);
                                            startActivity(intent);
                                        }
                                    });
                            mRecyclerView.setAdapter(mAdapter);
                            Log.i("get title(0)", articles.get(0).getTitle());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
//                        respon.OnRespon(0, response.optString("id"));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                respon.OnRespon(1, error.toString());
                error.printStackTrace();
                Log.i("onSite", "sendDateToSite请求失败" + error.toString());
            }
        });



        // Add the request we just defined to our request queue.
        // The request queue will automatically handle the request as soon as it can.
        requestQueue.add(jsonRequest);
    }

}

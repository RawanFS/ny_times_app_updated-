package com.example.rawanalsh.ny_times_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MostPopularDetail extends AppCompatActivity{

    MostPopularItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.most_popular_detail);
        setTitle("Article Details");

        item = (MostPopularItem) getIntent().getSerializableExtra("item");

        TextView title = findViewById(R.id.titleTvDetail);
        TextView author = findViewById(R.id.authorTvDetails);
        TextView date = findViewById(R.id.dateTvDetails);


        title.setText((String) item.getTitle());
        author.setText((String) item.getByline());
        date.setText((String) item.getPublished_date());






    }
}

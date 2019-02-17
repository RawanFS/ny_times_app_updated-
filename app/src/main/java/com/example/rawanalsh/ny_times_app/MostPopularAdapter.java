package com.example.rawanalsh.ny_times_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class MostPopularAdapter extends RecyclerView.Adapter<MostPopularAdapter.MostPopularHolder> {
    private ArrayList<MostPopularItem> mMostPopularList;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(MostPopularItem item);
    }

    public static class MostPopularHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView titleTv;
        public TextView authorTv;
        public TextView dateTv;

        public void bind(final MostPopularItem item, final OnItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }





        public MostPopularHolder(View itemView){
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            titleTv = itemView.findViewById(R.id.titleTv);
            authorTv = itemView.findViewById(R.id.authorTv);
            dateTv = itemView.findViewById(R.id.dateTv);



        }
    }

    public MostPopularAdapter(ArrayList<MostPopularItem> MostPopularList, OnItemClickListener listener){
        Log.i("the length in adaptor", MostPopularList.size()+"");
        mMostPopularList = MostPopularList;
        this.listener = listener;
        Log.i("list", mMostPopularList.get(0).getTitle());

    }
    @NonNull
    @Override
    public MostPopularHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.most_popular_item, viewGroup, false);
        MostPopularHolder evh = new MostPopularHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull MostPopularHolder mostPopularHolder, int i) {
        MostPopularItem currentItem = mMostPopularList.get(i);
        Log.i("current item title", currentItem.getTitle());

        mostPopularHolder.bind(mMostPopularList.get(i), listener);

        mostPopularHolder.mImageView.setImageResource(currentItem.getmImageResourse());
        mostPopularHolder.titleTv.setText(currentItem.getTitle());
        mostPopularHolder.authorTv.setText(currentItem.getByline());
        mostPopularHolder.dateTv.setText(currentItem.getPublished_date());




    }

    @Override
    public int getItemCount() {
        return  mMostPopularList.size();
    }


}

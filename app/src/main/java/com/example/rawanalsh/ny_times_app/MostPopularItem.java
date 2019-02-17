package com.example.rawanalsh.ny_times_app;

import java.io.Serializable;

public class MostPopularItem implements Serializable {
    private int mImageResourse;
    private String title;
    private String byline;
    private String published_date;



    public int getmImageResourse() {
        return mImageResourse;
    }

    public void setmImageResourse(int mImageResourse) {
        this.mImageResourse = mImageResourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getPublished_date() {
        return published_date;
    }

    public void setPublished_date(String published_date) {
        this.published_date = published_date;
    }

    public MostPopularItem(int mImageResourse, String title, String byline, String published_date) {
        this.mImageResourse = mImageResourse;
        this.title = title;
        this.byline = byline;
        this.published_date = published_date;
    }
}

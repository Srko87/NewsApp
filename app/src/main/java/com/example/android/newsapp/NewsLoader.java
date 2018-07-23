package com.example.android.newsapp;

import android.content.Context;
import android.content.AsyncTaskLoader;

import java.util.ArrayList;

public class NewsLoader extends AsyncTaskLoader<ArrayList<News>> {
    private String mUrl;

    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    public ArrayList<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        ArrayList<News> news = Query.fetchNewsdata(mUrl, getContext());
        return news;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}


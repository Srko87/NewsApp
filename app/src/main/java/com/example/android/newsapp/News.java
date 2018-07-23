package com.example.android.newsapp;

public class News {
    private String mTitle;
    private String mSection;
    private String mUrl;
    private String mImageUrl;
    private String mDateTime;
    private String mContributor;

    public News(String Title, String Section, String Url, String ImageUrl, String DateTime, String Contributor) {
        mSection = Section;
        mTitle = Title;
        mUrl = Url;
        mImageUrl = ImageUrl;
        mDateTime = DateTime;
        mContributor = Contributor;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmSection() {
        return mSection;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmDateTime() {
        return mDateTime;
    }

    public String getmContributor() {
        return mContributor;
    }
}

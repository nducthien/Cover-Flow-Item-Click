package com.example.coverflow_itemclick.model;

public class Movie {
    public String title;
    public String url;
    public String summary;

    public Movie() {
    }

    public Movie(String title, String url, String summary) {
        this.title = title;
        this.url = url;
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}

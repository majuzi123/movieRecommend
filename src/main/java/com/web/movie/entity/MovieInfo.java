package com.web.movie.entity;


public class MovieInfo {

    private int mid;
    private String title;
    private String rating;
    private String releasedata;
    private String introduction;


    public MovieInfo() {
    }

    public MovieInfo(int mid, String title, String rating, String releasedata, String introduction) {
        this.mid = mid;
        this.title = title;
        this.rating = rating;
        this.releasedata = releasedata;
        this.introduction = introduction;
    }

    public int getMid() {
        return mid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReleasedata() {
        return releasedata;
    }

    public void setReleasedate(String releasedata) {
        this.releasedata = releasedata;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "MovieInfo{" + "id=" + mid;
    }
}


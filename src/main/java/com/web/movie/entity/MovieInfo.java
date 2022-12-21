package com.web.movie.entity;

import java.util.List;

public class MovieInfo {

    private int movieId;
    private String title;
    private String region;
    private String language;
    private String introduction;
    private String releaseYear;
    private List<Genre> genreList;
    private List<Actor> actorList;
    private List<Director> directorList;

    public MovieInfo() {
    }

    public MovieInfo(int movieId, String title, String region, String language, String introduction,String releaseYear) {
        this.movieId = movieId;
        this.title = title;
        this.region = region;
        this.language = language;
        this.introduction = introduction;
        this.releaseYear = releaseYear;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenreList() {
        return genreList.toString();
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public String getActorList() {
        return actorList.toString();
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public String getDirectorList() {
        return directorList.toString();
    }

    public void setDirectorList(List<Director> directorList) {
        this.directorList = directorList;
    }
    @Override
    public String toString() {
        return "MovieInfo{" + "title=" + title;
    }
}


package com.web.movie.entity;

public class Genre {
    private int gid;
    private String type;

    public Genre(){

    }
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return type;
    }
}

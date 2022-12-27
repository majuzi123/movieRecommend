package com.web.movie.entity;

public class Comment implements Comparable<Comment>{
    private int commentId;
    private String content;
    private int grading;
    private String timeStamp;
    private String movieTitle;
    private String userName;

    public Comment(){

    }
    public Comment(String content, int score,String timeStamp,String userName) {
        this.content=content;
        this.grading=score;
        this.timeStamp=timeStamp;
        this.userName=userName;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getGrading() {
        return grading;
    }

    public void setGrading(int grading) {
        this.grading = grading;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", content='" + content + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", grading='" + grading + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Comment o) {
        return grading > o.grading ? -1 : 1;
    }
}

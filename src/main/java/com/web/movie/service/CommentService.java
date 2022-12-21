package com.web.movie.service;

import com.web.movie.entity.Comment;
import java.util.List;

public interface CommentService {

    List<Comment> getCommentsByMovie(int movie_id);

    List<Comment> getCommentsByUser(int user_id);

    int insertComment(Comment comment,int userId,int movieId);

    void deleteComment(int comment_id);

}

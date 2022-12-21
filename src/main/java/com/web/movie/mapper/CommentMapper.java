package com.web.movie.mapper;

import com.web.movie.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    int getCommentCount();
    List<Comment> getCommentsByUser(int user_id);

    List<Comment> getCommentsByMovie(int movie_id);

    int insertComment(@Param("comment") Comment comment,@Param("userId") int userId, @Param("movieId") int movieId);
    //int insertComment(Comment comment,int userId, int movieId);

    void deleteCommentById(int comment_id);

}

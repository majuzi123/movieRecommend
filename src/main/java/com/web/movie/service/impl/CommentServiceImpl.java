package com.web.movie.service.impl;

import com.web.movie.entity.Comment;
import com.web.movie.mapper.CommentMapper;
import com.web.movie.mapper.MovieInfoMapper;
import com.web.movie.mapper.UserMapper;
import com.web.movie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired(required = false)
    CommentMapper commentMapper;
    @Autowired(required = false)
    UserMapper userMapper;

    @Autowired(required = false)
    MovieInfoMapper movieInfoMapper;

    @Override
    public List<Comment> getCommentsByMovie(int movie_id) {
        return commentMapper.getCommentsByMovie(movie_id);
    }

    @Override
    public List<Comment> getCommentsByUser(int user_id) {
        return commentMapper.getCommentsByUser(user_id);
    }

    @Override
    public int insertComment(Comment comment,int userId,int movieId) {
        commentMapper.insertComment(comment,userId,movieId);
        return 0;
    }

    @Override
    public void deleteComment(int comment_id) {
        commentMapper.deleteCommentById(comment_id);
    }
}

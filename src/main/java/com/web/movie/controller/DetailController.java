package com.web.movie.controller;

import com.web.movie.entity.*;
import com.web.movie.service.CommentService;
import com.web.movie.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DetailController {

    @Autowired
    MovieInfoService movieInfoService;

    @Autowired
    CommentService commentService;

    @RequestMapping("/detail")
    public String toDetail(int id, ModelMap map, HttpSession session) throws Exception{
        MovieInfo movie = movieInfoService.getMovieById(id);
        List<Genre> genreList = movieInfoService.getGenreById(id);
        List<Actor> actorList = movieInfoService.getActorsById(id);
        List<Director> directorList = movieInfoService.getDirectorsById(id);
        movie.setGenreList(genreList);
        movie.setActorList(actorList);
        movie.setDirectorList(directorList);
        List<Comment> commentList = commentService.getCommentsByMovie(movie.getMovieId());
        session.setAttribute("movieId", movie.getMovieId());
        map.addAttribute("movie", movie);
        map.addAttribute("commentList", commentList);
        return "detail";
    }

    @RequestMapping("/submitComment")
    public String toCommend(String content, String score, ModelMap map, HttpSession session) throws Exception{
        int userId = (int) session.getAttribute("id");
        String userName = (String) session.getAttribute("name");
        int movieId = (int) session.getAttribute("movieId");
        int grading = Integer.parseInt(score);

        if (content==null|| content.equals("")){
            content="该用户没有发表评论";
        }

        String timeStamp=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(timeStamp);
        Comment comment = new Comment(content,grading,timeStamp,userName);
        commentService.insertComment(comment,userId,movieId);

        MovieInfo movie = movieInfoService.getMovieById(movieId);
        List<Genre> genreList = movieInfoService.getGenreById(movieId);
        List<Actor> actorList = movieInfoService.getActorsById(movieId);
        List<Director> directorList = movieInfoService.getDirectorsById(movieId);
        movie.setGenreList(genreList);
        movie.setActorList(actorList);
        movie.setDirectorList(directorList);
        List<Comment> commentList = commentService.getCommentsByMovie(movieId);
        map.addAttribute("movie", movie);
        map.addAttribute("commentList", commentList);
        return "detail";
    }

}
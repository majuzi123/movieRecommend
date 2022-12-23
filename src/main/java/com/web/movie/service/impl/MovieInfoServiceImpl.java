package com.web.movie.service.impl;

import com.web.movie.entity.*;
import com.web.movie.mapper.MovieInfoMapper;
import com.web.movie.recommend.Recommend;
import com.web.movie.service.MovieInfoService;
import com.web.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

    @Autowired(required = false)
    private MovieInfoMapper movieInfoMapper;
   UserService userService;

    public List<MovieInfo> getRecommendMovies(int id){
        Recommend recommend = new Recommend();
        List<Comment> recommendationMovies = recommend.recommend(userService.getUserInfoById(id));
        List<MovieInfo> recommendMovieInfo = null;
        for (Comment recommendationMovie : recommendationMovies){
            recommendMovieInfo.add(getMovieInfoByTitle(recommendationMovie.getMovieTitle()));
        }
        return  recommendMovieInfo;
    }
    @Override
    public List<MovieInfo> getNewMovies() {

        return movieInfoMapper.getNewMovies();
    }
    public MovieInfo getMovieById(int movie_id) {
        return movieInfoMapper.getMovieById(movie_id);
    }

    public List<MovieInfo> getMovieByTitle(String movie_title) {
        return movieInfoMapper.getMovieByTitle(movie_title);
    }
    public MovieInfo getMovieInfoByTitle(String movie_title){
        return movieInfoMapper.getMovieInfoByTitle(movie_title);
    }
    public List<Genre> getGenreById(int movie_id){
        return movieInfoMapper.getGenreById(movie_id);
    }
    public List<Actor> getActorsById(int movie_id){
        return movieInfoMapper.getActorsById(movie_id);
    }
    public List<Director> getDirectorsById(int movie_id){
        return movieInfoMapper.getDirectorsById(movie_id);
    }

}

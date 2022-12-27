package com.web.movie.service.impl;

import com.web.movie.entity.Actor;
import com.web.movie.entity.Director;
import com.web.movie.entity.Genre;
import com.web.movie.entity.MovieInfo;
import com.web.movie.mapper.MovieInfoMapper;
import com.web.movie.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

    @Autowired(required = false)
    private MovieInfoMapper movieInfoMapper;

    @Override
    public List<MovieInfo> getNewMovies() {
        return movieInfoMapper.getNewMovies();
    }

    @Override
    public List<MovieInfo> getRecommendMovies(int id) {
        return null;
    }

    @Override
    public MovieInfo getMovieById(int movie_id) {
        return movieInfoMapper.getMovieById(movie_id);
    }

    @Override
    public MovieInfo getMovieInfoByTitle(String movie_title) {
        return null;
    }

    @Override
    public List<MovieInfo> getMovieByTitle(String movie_title) {
        return movieInfoMapper.getMovieByTitle(movie_title);
    }
    @Override
    public List<Genre> getGenreById(int movie_id){
        return movieInfoMapper.getGenreById(movie_id);
    }
    @Override
    public List<Actor> getActorsById(int movie_id){
        return movieInfoMapper.getActorsById(movie_id);
    }
    @Override
    public List<Director> getDirectorsById(int movie_id){
        return movieInfoMapper.getDirectorsById(movie_id);
    }
    @Override
    public List<MovieInfo> getNewMovieByGenre(int genre_id) {
        return movieInfoMapper.getNewMovieByGenre(genre_id);
    }

}

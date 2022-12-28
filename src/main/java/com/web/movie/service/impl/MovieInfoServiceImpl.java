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
    public List<MovieInfo> getHighMovies() {
        return movieInfoMapper.getHighMovies();
    }

    @Override
    public List<MovieInfo> getRecommendMovies(int user_id) {
        int commonUsers = movieInfoMapper.calculateSimilarity(user_id);
        List<MovieInfo> recommendMovies;
        if(commonUsers==0){
            return movieInfoMapper.getHighMovies();
        }else{
            recommendMovies=movieInfoMapper.getRecommendMovies(user_id);
        }
        if(recommendMovies.size()<6) return movieInfoMapper.getHighMovies();
        return recommendMovies;
    }

    @Override
    public MovieInfo getMovieById(int movie_id) {
        return movieInfoMapper.getMovieById(movie_id);
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

    @Override
    public List<MovieInfo> getMovieOfSameDirector(int movie_id) {
        return movieInfoMapper.getMovieOfSameDirector(movie_id);
    }
}

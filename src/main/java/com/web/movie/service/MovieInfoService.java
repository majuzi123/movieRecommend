package com.web.movie.service;

import com.web.movie.entity.Actor;
import com.web.movie.entity.Director;
import com.web.movie.entity.Genre;
import com.web.movie.entity.MovieInfo;
import java.util.List;

public interface MovieInfoService {

    List<MovieInfo> getHighMovies();
    List<MovieInfo> getRecommendMovies(int user_id);
    MovieInfo getMovieById(int movie_id);
    List<MovieInfo> getMovieByTitle(String movie_title);
    List<Genre> getGenreById(int movie_id);
    List<Actor> getActorsById(int movie_id);
    List<Director> getDirectorsById(int movie_id);
    List<MovieInfo> getNewMovieByGenre(int genre_id);

}

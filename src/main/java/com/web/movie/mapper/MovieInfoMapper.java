package com.web.movie.mapper;

import com.web.movie.entity.Actor;
import com.web.movie.entity.Director;
import com.web.movie.entity.Genre;
import com.web.movie.entity.MovieInfo;
import java.util.List;

public interface MovieInfoMapper {

    List<MovieInfo> getNewMovies();
    MovieInfo getMovieById(int movie_id);
    List<MovieInfo> getMovieByTitle(String title);
    MovieInfo getMovieInfoByTitle(String title);
    List<Genre> getGenreById(int movie_id);
    List<Actor> getActorsById(int movie_id);
    List<Director> getDirectorsById(int movie_id);

}

package com.web.movie.mapper;

import com.web.movie.entity.Actor;
import com.web.movie.entity.Director;
import com.web.movie.entity.Genre;
import com.web.movie.entity.MovieInfo;
import java.util.List;

public interface MovieInfoMapper {

    List<MovieInfo> getHighMovies();
    MovieInfo getMovieById(int movie_id);
    List<MovieInfo> getMovieByTitle(String title);
    List<Genre> getGenreById(int movie_id);
    List<Actor> getActorsById(int movie_id);
    List<Director> getDirectorsById(int movie_id);
    List<MovieInfo> getNewMovieByGenre(int genre_id);
    int calculateSimilarity(int user_id);
    List<MovieInfo> getRecommendMovies(int user_id);
    List<MovieInfo> getMovieOfSameDirector(int movie_id);

}

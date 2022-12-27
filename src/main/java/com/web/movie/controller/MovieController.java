package com.web.movie.controller;

import com.web.movie.entity.MovieInfo;
import com.web.movie.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MovieController {

    @Autowired
    MovieInfoService movieInfoService;

    @RequestMapping("/movie")
    public String toMovie(ModelMap map, HttpSession session)throws Exception{
       /* if (session.getAttribute("status").equals("login")){
            int id = (int) session.getAttribute("id");
            List<MovieInfo> list=movieInfoService.getRecommendedMovies(id);
            map.addAttribute("list",list);
        }
        else {
            List<MovieInfo> list=movieInfoService.getHighScoreMovies();
            map.addAttribute("list",list);
        }*/

        List<MovieInfo> newCartoonMovies =movieInfoService.getNewMovieByGenre(5);
        List<MovieInfo> newLoveMovies=movieInfoService.getNewMovieByGenre(1);
        List<MovieInfo> newActionMovies=movieInfoService.getNewMovieByGenre(2);
        List<MovieInfo> newComedyMovies=movieInfoService.getNewMovieByGenre(6);
        List<MovieInfo> newCrimeMovies=movieInfoService.getNewMovieByGenre(11);

        map.addAttribute("newCartoonMovies", newCartoonMovies);
        map.addAttribute("newLoveMovies",newLoveMovies);
        map.addAttribute("newActionMovies",newActionMovies);
        map.addAttribute("newComedyMovies",newComedyMovies);
        map.addAttribute("newCrimeMovies",newCrimeMovies);

        return "movie";
    }

}

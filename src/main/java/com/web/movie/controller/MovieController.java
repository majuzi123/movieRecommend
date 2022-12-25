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

        List<MovieInfo> newList=movieInfoService.getNewMovies();
        List<MovieInfo> newDramaMovies=movieInfoService.getNewMovieByGenre(0);
        List<MovieInfo> newLoveMovies=movieInfoService.getNewMovieByGenre(1);
        List<MovieInfo> newActionMovies=movieInfoService.getNewMovieByGenre(2);
        List<MovieInfo> newHistoryMovies=movieInfoService.getNewMovieByGenre(3);

        map.addAttribute("newList",newList);
        map.addAttribute("list",newList);
        map.addAttribute("highList",newList);

        map.addAttribute("newDramaMovies",newDramaMovies);
        map.addAttribute("newLoveMovies",newLoveMovies);
        map.addAttribute("newActionMovies",newActionMovies);
        map.addAttribute("newHistoryMovies",newHistoryMovies);

        //List<MovieInfo> highList=movieInfoService.getHighScoreMovies();
        //map.addAttribute("highList",highList);
        return "movie";
    }

}

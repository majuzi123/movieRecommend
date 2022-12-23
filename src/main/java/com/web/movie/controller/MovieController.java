package com.web.movie.controller;

import com.web.movie.entity.MovieInfo;
import com.web.movie.entity.User;
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
        int id = (int) session.getAttribute("id");

        List<MovieInfo> newList=movieInfoService.getRecommendMovies(id);
        //List<MovieInfo> newList=movieInfoService.getNewMovies();
        map.addAttribute("newList",newList);

        map.addAttribute("list",newList);
        map.addAttribute("highList",newList);

        //List<MovieInfo> highList=movieInfoService.getHighScoreMovies();
        //map.addAttribute("highList",highList);
        return "movie";
    }

}

package com.web.movie.controller;

import com.web.movie.entity.MovieInfo;
import com.web.movie.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SearchController {

    @Autowired
    MovieInfoService movieInfoService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String toSearch(String title, ModelMap map)throws Exception{

        List<MovieInfo> searchList=movieInfoService.getMovieByTitle(title);
        map.addAttribute("searchList",searchList);
        return "search";
    }

}

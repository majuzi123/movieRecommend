package com.web.movie.controller;

import com.web.movie.service.MovieInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    MovieInfoService movieInfoService;

    @RequestMapping("/")
    public String firstToIndex(HttpSession session)throws Exception{
        session.setAttribute("status","logout");
        return "index";
    }

    @RequestMapping("/index")
    public String toIndex(HttpSession session)throws Exception{
        return "index";
    }

}

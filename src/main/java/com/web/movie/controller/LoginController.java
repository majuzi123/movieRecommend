package com.web.movie.controller;

import com.web.movie.entity.User;
import com.web.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public String toLogin() throws Exception{
        return "login";
    }

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public String login(String userName, String passWord, ModelMap map, HttpSession session) throws Exception{
        User user = userService.loginIn(userName, passWord);
        if (user != null) {
            session.setAttribute("status", "login");
            session.setAttribute("id", user.getUserName());
            return "index";
        } else {
            map.addAttribute("flag", "yes");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String toLogout(HttpSession session) throws Exception{
        session.removeAttribute("id");
        session.setAttribute("status", "logout");
        return "index";
    }

    @RequestMapping("/register")
    public String toRegister()throws Exception {
        return "register";
    }

    @RequestMapping(value = "/registerIn", method = RequestMethod.POST)
    public String register(String userName,String passWord, HttpSession session) throws Exception{
        if (userService.register(userName,passWord)) {
            session.setAttribute("status", "login");
            session.setAttribute("id", userName);
            return "index";
        } else {
            return "register";
        }
    }

}
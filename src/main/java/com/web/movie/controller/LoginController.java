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
            System.out.println("登录用户："+user);
            session.setAttribute("status", "login");
            session.setAttribute("id", user.getUserId());
            session.setAttribute("name",userName);
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
        int newUserId = userService.register(userName,passWord);
        if (newUserId !=-1) {
            session.setAttribute("status", "login");
            session.setAttribute("id", newUserId);
            session.setAttribute("name",userName);
            return "index";
        } else {
            return "register";
        }
    }

}
package com.web.movie.controller;

import com.web.movie.entity.Comment;
import com.web.movie.entity.User;
import com.web.movie.service.CommentService;
import com.web.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PersonController {

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @RequestMapping("/person")
    public String toPerson(ModelMap map, HttpSession session)throws Exception {
        int id = (int) session.getAttribute("id");
        User user = userService.getUserInfoById(id);
        List<Comment> commentList = commentService.getCommentsByUser(id);
        map.addAttribute("user", user);
        map.addAttribute("commentList", commentList);
        return "person";
    }

    @RequestMapping(value = "/reverse", method = RequestMethod.POST)
    public String toReverse(User userInfo, ModelMap map, HttpSession session)throws Exception {
        userService.updateUserInfo(userInfo);
        int id = (int) session.getAttribute("id");
        User user = userService.getUserInfoById(id);
        List<Comment> commentList = commentService.getCommentsByUser(id);
        map.addAttribute("user", user);
        map.addAttribute("commentList", commentList);
        return "person";
    }


    @RequestMapping("delete")
    public String toDelete(int comment_id, ModelMap map, HttpSession session) throws Exception{
        commentService.deleteComment(comment_id);
        int id = (int) session.getAttribute("id");
        User user = userService.getUserInfoById(id);
        List<Comment> commentList = commentService.getCommentsByUser(id);
        map.addAttribute("user", user);
        map.addAttribute("commentList", commentList);
        return "person";
    }
}

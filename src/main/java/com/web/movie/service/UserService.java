package com.web.movie.service;

import com.web.movie.entity.User;

import java.util.List;

public interface UserService {

    User loginIn(String userName, String passWord);

    User getUserInfoById(int id);

    User getUserByName(String userName);

    int register(String userName, String passWord);
    void updateUserInfo(User userInfo);

   List<User> getUsersByComment(int user_id);
}

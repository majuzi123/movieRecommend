package com.web.movie.service;

import com.web.movie.entity.User;

public interface UserService {

    User loginIn(String userName, String passWord);

    User getUser(String userName);

    Boolean register(String userName, String passWord);


}

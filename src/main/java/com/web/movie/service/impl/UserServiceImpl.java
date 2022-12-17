package com.web.movie.service.impl;

import com.web.movie.entity.User;
import com.web.movie.mapper.UserMapper;
import com.web.movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User loginIn(String userName, String passWord) {
        passWord= DigestUtils.md5DigestAsHex(passWord.getBytes(StandardCharsets.UTF_8));
        return userMapper.getInfo(userName, passWord);
    }

    @Override
    public User getUser(String userName) {
        return userMapper.getUser(userName);
    }

    @Override
    public Boolean register(String userName, String passWord) {
        User user = userMapper.getUser(userName);
        if (user == null) {
            User newUser = new User();
            newUser.setUserName(userName);
            newUser.setPassWord(DigestUtils.md5DigestAsHex(passWord.getBytes(StandardCharsets.UTF_8)));
            userMapper.addUser(newUser);
            return true;
        } else {
            return false;
        }
    }

}

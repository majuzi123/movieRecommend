package com.web.movie.service.impl;

import com.web.movie.entity.User;
import com.web.movie.mapper.UserMapper;
import com.web.movie.service.UserService;
import java.util.List;
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
        return userMapper.getLoginInfo(userName, passWord);
    }

    @Override
    public User getUserInfoById(int id) {
        return userMapper.getUserInfoById(id);
    }

    @Override
    public User getUserByName(String userName){
        return userMapper.getUserByName(userName);
    }

    @Override
    public int register(String userName, String passWord) {
        User user = userMapper.getUserByName(userName);
        if (user == null) {
            int count=userMapper.getUserCount();
            User newUser = new User();
            newUser.setUserId(count+1);
            newUser.setUserName(userName);
            newUser.setPassWord(DigestUtils.md5DigestAsHex(passWord.getBytes(StandardCharsets.UTF_8)));
            userMapper.addUser(newUser);
            return newUser.getUserId();
        } else {
            return -1;
        }
    }
    public void updateUserInfo(User userInfo) {
        userMapper.updateUserInfo(userInfo);
    }

    @Override
    public List<User> getUsersByComment(int user_id) {
        return userMapper.getUsersByComment(user_id);
    }

}

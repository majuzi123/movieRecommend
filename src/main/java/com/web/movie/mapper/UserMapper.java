package com.web.movie.mapper;

import com.web.movie.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

     User getLoginInfo(@Param("userName") String userName, @Param("passWord") String passWord);

     User getUserInfoById(@Param("id") int id);

     User getUserByName(@Param("userName") String userName);

     void addUser(User newUser);

     int getUserCount();

     void updateUserInfo(User userInfo);

    List<User> getUsersByComment(int user_id);
}

package com.web.movie.mapper;

import com.web.movie.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

     User getInfo(@Param("userName") String userName, @Param("passWord") String passWord);

     User getUser(@Param("userName") String userName);

     void addUser(User newUser);


}

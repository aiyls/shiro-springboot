package springbootshiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import springbootshiro.entity.User;
import springbootshiro.mapper.UserMapper;
import springbootshiro.service.UserService;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
}

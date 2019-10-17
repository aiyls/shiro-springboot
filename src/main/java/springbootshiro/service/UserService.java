package springbootshiro.service;

import springbootshiro.entity.User;

public interface UserService {
    User findByUserName(String userName);
}

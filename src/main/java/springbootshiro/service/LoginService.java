package springbootshiro.service;


import springbootshiro.utils.LoginResult;

public interface LoginService {

    LoginResult login(String userName ,String password);

    void logout();

}

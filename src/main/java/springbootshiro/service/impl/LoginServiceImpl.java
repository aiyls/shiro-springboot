package springbootshiro.service.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootshiro.service.LoginService;
import springbootshiro.utils.LoginResult;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginService loginService;

    @Override
    public LoginResult login(String userName, String password) {
        LoginResult loginResult = new LoginResult();
        if (userName == null || userName.isEmpty()){
            loginResult.setLogin(false);
            loginResult.setResult("用户名为空");
            return loginResult;
        }
        String msg = "";
        //获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        //判断是否登陆
//        if (subject.isAuthenticated() == false)

        //将用户名和密码封装到UsernamePasswordToken
        UsernamePasswordToken token = new UsernamePasswordToken(userName , password);
        // 4、认证
        try {
            subject.login(token);// 传到MyAuthorizingRealm类中的方法进行认证
            Session session = subject.getSession();
            session.setAttribute("userName", userName);
            loginResult.setLogin(true);
            return loginResult;
            //return "/index";
        }catch (UnknownAccountException e)
        {
            e.printStackTrace();
            msg = "UnknownAccountException -- > 账号不存在：";
        }
        catch (IncorrectCredentialsException e)
        {
            msg = "IncorrectCredentialsException -- > 密码不正确：";
        }
        catch (AuthenticationException e) {
            e.printStackTrace();
            msg="用户验证失败";
        }
        loginResult.setLogin(false);
        loginResult.setResult(msg);
        return loginResult;
    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}

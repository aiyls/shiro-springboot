package springbootshiro.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@TableName("user")
public class User {
    @TableId
    private Integer userId;
    private String userName; //登录用户名
    private String name;//名称（昵称或者真实姓名，根据实际情况定义）
    private String password;
    private String salt;//加密密码的盐
    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.
    private List<SysRole> roleList;// 一个用户具有多个角色
    private Date createTime;//创建时间
    private Date expiredDate;//过期日期
    private String email;


    /**
     * 密码盐. 重新对盐重新进行了定义，用户名+salt，这样就不容易被破解，可以采用多种方式定义加盐
     * @return
     */
    public String getCredentialsSalt(){
        return this.userName+this.salt;
    }
}

package springbootshiro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import springbootshiro.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from user where userName = #{userName}")
    User findByUserName(String userName);


}

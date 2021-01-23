package top.zbawq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import top.zbawq.pojo.User;

import java.util.List;

@Mapper
@Component
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> selectAllUser();
}

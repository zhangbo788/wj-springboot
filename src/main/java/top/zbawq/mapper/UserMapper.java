package top.zbawq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zbawq.pojo.User;

import java.io.Serializable;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}

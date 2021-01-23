package top.zbawq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import top.zbawq.pojo.AdminRoleMenu;

@Mapper
@Component
public interface AdminRoleMenuMapper extends BaseMapper<AdminRoleMenu>{
}

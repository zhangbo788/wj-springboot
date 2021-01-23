package top.zbawq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.zbawq.pojo.AdminRole;

import java.util.List;

public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    @Select("select * from admin_role")
    List<AdminRole> findAllRole();
}

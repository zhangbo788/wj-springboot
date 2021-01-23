package top.zbawq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import top.zbawq.pojo.AdminPermission;

import java.util.List;

public interface AdminPermissionMapper extends BaseMapper<AdminPermission> {
    @Select("select * from admin_permission")
    List<AdminPermission> selectAllPermission();
}

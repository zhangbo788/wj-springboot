package top.zbawq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import top.zbawq.pojo.Category;

@Mapper
@Component
public interface CategoryMapper extends BaseMapper<Category> {

}

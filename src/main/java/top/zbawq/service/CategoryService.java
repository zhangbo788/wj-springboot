package top.zbawq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zbawq.pojo.Category;

import java.util.List;

public interface CategoryService extends IService<Category> {
    List<Category> findAllCategory();

    Category findCategoryById(int id);
}

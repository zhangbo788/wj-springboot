package top.zbawq.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zbawq.mapper.CategoryMapper;
import top.zbawq.pojo.Category;
import top.zbawq.service.CategoryService;

import java.util.List;
@Service
public class CategoryServiceImp extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public List<Category> findAllCategory() {
        List<Category> categories = categoryMapper.selectList(null);
        return categories;
    }

    @Override
    public Category findCategoryById(int id) {
        Category category = categoryMapper.selectById(id);
        return category;
    }
}

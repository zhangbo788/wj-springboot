package top.zbawq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Mapper;
import top.zbawq.pojo.Book;

import java.util.List;

public interface BookService extends IService<Book> {
    //增删改查  全部查  依据id查
    List<Book> findAllBooks();

    void addOrUpdate(Book book);

    void deleteById(int id);

    List<Book> findByCategory(int id);

}

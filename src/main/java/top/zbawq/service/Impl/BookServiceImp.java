package top.zbawq.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zbawq.mapper.BookMapper;
import top.zbawq.mapper.CategoryMapper;
import top.zbawq.pojo.Book;
import top.zbawq.pojo.Category;
import top.zbawq.service.BookService;
import java.util.List;

@Service
public class BookServiceImp extends ServiceImpl<BookMapper, Book> implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = bookMapper.selectAllBooks();
        return books;
    }

    @Override
    public void addOrUpdate(Book book) {
        Book book1 = bookMapper.selectById(book.getId());
        if (book1 == null){
            System.out.println("添加了");
             bookMapper.insertBook(book);
        }else {
            System.out.println("更新了");
            bookMapper.updateBook(book);
        }
//
    }


    @Override
    public void deleteById(int id) {
        bookMapper.deleteById(id);
    }

    @Override
    public List<Book> findByCategory(int cid) {
        List<Book> books = bookMapper.findByCategory(cid);
        return books;
    }
}

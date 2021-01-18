package top.zbawq;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zbawq.mapper.BookMapper;
import top.zbawq.mapper.UserMapper;
import top.zbawq.pojo.Book;
import top.zbawq.pojo.User;
import top.zbawq.service.BookService;
import top.zbawq.service.UserService;

import java.util.List;

@SpringBootTest
class WjSpringbootApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
//        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username","admin");
//        List<User> users = userMapper.selectList(wrapper);
//        System.out.println(users);
//        List<Book> books = bookMapper.selectAllBooks();
//        System.out.println(books);

//        List<Book> byCategory = bookService.findByCategory(1);
//        System.out.println(byCategory);
//        Book book = new Book();
//        book.setTitle("张博的书");
//        bookService.addOrUpdate(book);
        bookService.deleteById(102);
    }


}

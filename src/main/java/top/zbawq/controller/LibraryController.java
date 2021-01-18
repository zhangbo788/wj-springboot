package top.zbawq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.zbawq.pojo.Book;
import top.zbawq.service.BookService;
import top.zbawq.utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.findAllBooks();
    }

    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }


    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.findByCategory(cid);
        } else {
            return list();
        }
    }

    @PostMapping("/api/covers")
    public String coverUpload(MultipartFile file) throws IOException {
        String folder="D:\\Desktop\\dbblog-master\\wj-springboot\\img";
        File fileFolder = new File(folder);
        File fileImg = new File(fileFolder, StringUtils.getRandString(6) + file.getOriginalFilename());
        if (!fileFolder.exists()){
            fileFolder.mkdirs();
        }else {
            file.transferTo(fileImg);
            String imgUrl="http://localhost:8443/api/file/"+ fileImg.getName();
            return imgUrl;
        }
        return "";
    }
}

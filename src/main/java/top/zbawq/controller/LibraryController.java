package top.zbawq.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "图书信息管理")
public class LibraryController {
    @Autowired
    BookService bookService;

    @ApiOperation(value = "查询所有的图书信息",notes = "是所有图书")
    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.findAllBooks();
    }

    @ApiOperation("添加或者更新图书信息")
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    @ApiOperation("删除图书信息")
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }


    //@ApiParam(value = "图书信息分类编号",required = true , name = "book")
    //value相当于参数说明 name给参数重新命名
    @ApiOperation("按照图书类别查询图书")
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (0 != cid) {
            return bookService.findByCategory(cid);
        } else {
            return list();
        }
    }

    @ApiOperation("上传图书封面")
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

package top.zbawq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import top.zbawq.pojo.Book;

import java.util.List;

@Mapper
public interface BookMapper extends BaseMapper<Book> {

    @Results(id="allBooksMap",value = {
            @Result(property = "id" , column = "id"),
            @Result(property = "cover" , column = "cover"),
            @Result(property = "title" , column = "title"),
            @Result(property = "author" , column = "author"),
            @Result(property = "date" , column = "date"),
            @Result(property = "press" , column = "press"),
            @Result(property = "abs" , column = "abs"),
            @Result(property = "category" , column = "cid",one = @One(select = "top.zbawq.mapper.CategoryMapper.selectById")),
    })
    @Select("select * from book")
    List<Book> selectAllBooks();

    @Results(id="allBooksByCategoryMap",value = {
            @Result(property = "id" , column = "id"),
            @Result(property = "cover" , column = "cover"),
            @Result(property = "title" , column = "title"),
            @Result(property = "author" , column = "author"),
            @Result(property = "date" , column = "date"),
            @Result(property = "press" , column = "press"),
            @Result(property = "abs" , column = "abs"),
            @Result(property = "category" , column = "cid",one = @One(select = "top.zbawq.mapper.CategoryMapper.selectById")),
    })
    @Select("select * from book where cid=#{cid}")
    List<Book> findByCategory(@Param("cid") int cid);

    @Update("update book set cover=#{cover},title=#{title},author=#{author}," +
            "date=#{date},press=#{press},abs=#{abs},cid=#{category.id} where id=#{id}")
    void updateBook(Book book);

    @Insert("insert into book values(#{id},#{cover},#{title},#{author}," +
            "#{date},#{press},#{abs},#{category.id})")
    void insertBook(Book book);
}

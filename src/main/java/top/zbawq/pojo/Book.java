package top.zbawq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.ResultMap;

import java.util.Date;

@TableName("book")
@ApiModel(value="book对象",description="对象book表示书籍")
public class Book {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value="书籍名称")
    private String cover;
    private String title;
    private String author;
    private String date;
    private String press;
    private String abs;

    @TableField(exist = false)
    private Category category;

    public Book() {
    }

    public Book(Integer id, String cover, String title, String author, String date, String press, String abs, Category category) {
        this.id = id;
        this.cover = cover;
        this.title = title;
        this.author = author;
        this.date = date;
        this.press = press;
        this.abs = abs;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", cover='" + cover + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                ", press='" + press + '\'' +
                ", abs='" + abs + '\'' +
                ", category=" + category +
                '}';
    }
}

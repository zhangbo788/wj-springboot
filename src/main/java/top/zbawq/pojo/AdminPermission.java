package top.zbawq.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("admin_permission")
public class AdminPermission {

    @TableId(type = IdType.AUTO)
    private int id;

    /**
     * Permission name;
     */
    private String name;

    /**
     * Permission's description(in Chinese)
     */
    private String descs;

    /**
     * The path which triggers permission check.
     * url 即权限对应的接口，是实现功能控制的关键
     */
    private String url;

    public AdminPermission() {
    }

    public AdminPermission(int id, String name, String desc_, String url) {
        this.id = id;
        this.name = name;
        this.descs = desc_;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc_() {
        return descs;
    }

    public void setDesc_(String desc_) {
        this.descs = descs;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "AdminPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", descs='" + descs + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

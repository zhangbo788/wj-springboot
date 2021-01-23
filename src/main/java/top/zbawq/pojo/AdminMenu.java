package top.zbawq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;


@TableName("admin_menu")
public class AdminMenu {

    @TableId(type = IdType.AUTO,value = "id") //配置文件中已经配置全局实体自增
    int id;
    String path;
    String name;
    String nameZh;
    String iconCls;
    String component;

    /**
     * 父菜单
     */
    @TableField("parent_id")
    int parentId;

    @TableField(exist = false)
    List<AdminMenu> children;

    public AdminMenu() {
    }

    public AdminMenu(int id, String path, String name, String nameZh, String iconCls, String component, int parentId, List<AdminMenu> children) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.nameZh = nameZh;
        this.iconCls = iconCls;
        this.component = component;
        this.parentId = parentId;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<AdminMenu> getChildren() {
        return children;
    }

    public void setChildren(List<AdminMenu> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "AdminMenu{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", component='" + component + '\'' +
                ", parentId=" + parentId +
                ", children=" + children +
                '}';
    }
}

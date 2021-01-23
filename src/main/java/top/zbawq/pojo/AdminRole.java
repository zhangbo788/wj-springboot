package top.zbawq.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

@TableName("admin_role")
public class AdminRole {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    @TableField(value = "name_zh")
    private String nameZh;
    /**
     * 角色状态
     */
    private boolean enabled;
    @TableField(exist = false)
    private List<AdminPermission> perms;

    @TableField(exist = false)
    private List<AdminMenu> menus;


    public AdminRole(Integer id, String name, String name_zh) {
        this.id = id;
        this.name = name;
        this.nameZh= name_zh;
    }

    public AdminRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AdminPermission> getPerms() {
        return perms;
    }

    public void setPerms(List<AdminPermission> perms) {
        this.perms = perms;
    }

    public List<AdminMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<AdminMenu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", enabled=" + enabled +
                ", perms=" + perms +
                ", menus=" + menus +
                '}';
    }
}

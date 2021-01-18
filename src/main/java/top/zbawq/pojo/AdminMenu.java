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
    int parentId;
    @TableField(exist = false)
    List<AdminMenu> children;
}

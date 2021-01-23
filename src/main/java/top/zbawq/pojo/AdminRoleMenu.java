package top.zbawq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("admin_role_menu")
public class AdminRoleMenu {

    @TableId(type = IdType.AUTO)
    private int id;

    /**
     * Role id.
     */
    private int rid;

    /**
     * Menu id.
     */
    private int mid;

    public AdminRoleMenu(int id, int rid, int mid) {
        this.id = id;
        this.rid = rid;
        this.mid = mid;
    }

    public AdminRoleMenu() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "AdminRoleMenu{" +
                "id=" + id +
                ", rid=" + rid +
                ", mid=" + mid +
                '}';
    }
}

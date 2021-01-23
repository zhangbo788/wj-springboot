package top.zbawq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("admin_role_permission")
public class AdminRolePermission {

    @TableId(type = IdType.AUTO)
    private int id;

    /**
     * Role id.
     */
    private int rid;

    /**
     * Permission id.
     */
    private int pid;

    public AdminRolePermission() {
    }

    public AdminRolePermission(int id, int rid, int pid) {
        this.id = id;
        this.rid = rid;
        this.pid = pid;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "AdminRolePermission{" +
                "id=" + id +
                ", rid=" + rid +
                ", pid=" + pid +
                '}';
    }
}

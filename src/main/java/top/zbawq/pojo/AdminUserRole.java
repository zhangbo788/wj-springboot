package top.zbawq.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("admin_user_role")
public class AdminUserRole {
    @TableId(type = IdType.AUTO)
    private int id;

    /**
     * User id.
     */
    private int uid;

    /**
     * Role id.
     */
    private int rid;

    public AdminUserRole() {
    }

    public AdminUserRole(int id, int uid, int rid) {
        this.id = id;
        this.uid = uid;
        this.rid = rid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "AdminUserRole{" +
                "id=" + id +
                ", uid=" + uid +
                ", rid=" + rid +
                '}';
    }
}

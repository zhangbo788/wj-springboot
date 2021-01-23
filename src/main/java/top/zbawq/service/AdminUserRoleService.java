package top.zbawq.service;

import top.zbawq.pojo.AdminRole;
import top.zbawq.pojo.AdminUserRole;

import java.util.List;

public interface AdminUserRoleService {
    List<AdminUserRole> listAllByUid(int uid);
    void saveRoleChanges(int uid, List<AdminRole> roles);
}

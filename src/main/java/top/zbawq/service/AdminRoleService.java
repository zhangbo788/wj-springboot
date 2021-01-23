package top.zbawq.service;

import top.zbawq.pojo.AdminRole;

import java.util.List;

public interface AdminRoleService {
    List<AdminRole> listWithPermsAndMenus();
    List<AdminRole> findAll();
    void addOrUpdate(AdminRole adminRole);
    List<AdminRole> listRolesByUser(String username);
    AdminRole updateRoleStatus(AdminRole role);
    void editRole(AdminRole role);
}

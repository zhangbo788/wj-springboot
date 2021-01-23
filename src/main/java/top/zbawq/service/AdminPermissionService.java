package top.zbawq.service;

import top.zbawq.pojo.AdminPermission;

import java.util.List;
import java.util.Set;

public interface AdminPermissionService {
    List<AdminPermission> list();
    List<AdminPermission> listPermsByRoleId(int rid);
    boolean needFilter(String requestAPI);
    Set<String> listPermissionURLsByUser(String username);
}

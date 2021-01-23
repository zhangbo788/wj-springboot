package top.zbawq.service;

import org.springframework.stereotype.Service;
import top.zbawq.pojo.AdminPermission;
import top.zbawq.pojo.AdminRolePermission;

import java.util.List;

@Service
public interface AdminRolePermissionService {
    List<AdminRolePermission> findAllByRid(int rid);
    void savePermChanges(int rid, List<AdminPermission> perms);
    List<AdminRolePermission> findAllByRids(List<Integer> rids);
}

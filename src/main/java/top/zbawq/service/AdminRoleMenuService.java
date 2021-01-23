package top.zbawq.service;

import top.zbawq.pojo.AdminRoleMenu;

import java.util.List;
import java.util.Map;

public interface AdminRoleMenuService {
    List<AdminRoleMenu> findAllByRid(int rid);
    List<AdminRoleMenu> findAllByRids(List<Integer> rids);
    void updateRoleMenu(int rid, Map<String, List<Integer>> menusIds);
}

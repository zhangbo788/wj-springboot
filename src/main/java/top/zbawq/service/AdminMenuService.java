package top.zbawq.service;

import top.zbawq.pojo.AdminMenu;

import java.util.List;

public interface AdminMenuService {
    List<AdminMenu> getMenusByCurrentUser();
    List<AdminMenu> getMenusByRoleId(int rid);
}

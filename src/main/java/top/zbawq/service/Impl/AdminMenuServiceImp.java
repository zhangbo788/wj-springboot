package top.zbawq.service.Impl;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zbawq.mapper.AdminMenuMapper;
import top.zbawq.pojo.AdminMenu;
import top.zbawq.pojo.AdminRoleMenu;
import top.zbawq.pojo.AdminUserRole;
import top.zbawq.pojo.User;
import top.zbawq.service.AdminMenuService;
import top.zbawq.service.AdminRoleMenuService;
import top.zbawq.service.AdminUserRoleService;
import top.zbawq.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AdminMenuServiceImp implements AdminMenuService {
    @Autowired
    private UserService userService;

    @Autowired
    private AdminUserRoleService adminUserRoleService;

    @Autowired
    private AdminRoleMenuService adminRoleMenuService;

    @Autowired
    private AdminMenuMapper adminMenuMapper;

    @Override
    public List<AdminMenu> getMenusByCurrentUser() {
        //获取授权用户信息
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.findByUsername(username);
        //获取当前用户对于的角色id
        List<Integer> list = adminUserRoleService.listAllByUid(user.getId())
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        //查询出这些角色对于的菜单项
        List<Integer> collect = adminRoleMenuService.findAllByRids(list).
                stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        List<AdminMenu> adminMenus = adminMenuMapper.selectBatchIds(collect);

        //查询其所有的子菜单 并加入其中
        handleMenus(adminMenus);
        return adminMenus;
    }

    public void handleMenus(List<AdminMenu> menus) {
        menus.forEach(m -> {
            List<AdminMenu> children = getAllByParentId(m.getId());
            m.setChildren(children);
        });

        menus.removeIf(m -> m.getParentId() != 0);
    }
    public List<AdminMenu> getAllByParentId(int parentId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("parent_id",parentId);
        List<AdminMenu> adminMenus = adminMenuMapper.selectByMap(map);
        return adminMenus;
    }
    public List<AdminMenu> getMenusByRoleId(int rid) {
        List<Integer> menuIds = adminRoleMenuService.findAllByRid(rid)
                .stream().map(AdminRoleMenu::getMid).collect(Collectors.toList());
        if (menuIds.isEmpty()){
            return null;
        }
        List<AdminMenu> menus = adminMenuMapper.selectBatchIds(menuIds);

        handleMenus(menus);
        return menus;
    }
}

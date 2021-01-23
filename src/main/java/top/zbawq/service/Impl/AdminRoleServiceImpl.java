package top.zbawq.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import top.zbawq.mapper.AdminRoleMapper;
import top.zbawq.pojo.AdminMenu;
import top.zbawq.pojo.AdminPermission;
import top.zbawq.pojo.AdminRole;
import top.zbawq.pojo.AdminUserRole;
import top.zbawq.service.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    AdminRoleMapper adminRoleMapper;
    @Autowired
    UserService userService;
    @Autowired
    AdminUserRoleService adminUserRoleService;
    @Autowired
    AdminPermissionService adminPermissionService;
    @Autowired
    AdminRolePermissionService adminRolePermissionService;
    @Autowired
    AdminMenuService adminMenuService;


    public List<AdminRole> listWithPermsAndMenus() {
        List<AdminRole> roles = adminRoleMapper.findAllRole();
        List<AdminPermission> perms;
        List<AdminMenu> menus;
        for (AdminRole role : roles) {
            perms = adminPermissionService.listPermsByRoleId(role.getId());
            menus = adminMenuService.getMenusByRoleId(role.getId());
            role.setPerms(perms);
            role.setMenus(menus);
        }
        return roles;
    }

    public List<AdminRole> findAll() {
        return adminRoleMapper.findAllRole();
    }


    public void addOrUpdate(AdminRole adminRole) {
        AdminRole adminRole1 = adminRoleMapper.selectById(adminRole.getId());
        if(adminRole1!=null){
            adminRoleMapper.updateById(adminRole);
        }else {
            adminRoleMapper.insert(adminRole);
        }
    }

    public List<AdminRole> listRolesByUser(String username) {
        int uid = userService.findByUsername(username).getId();
        List<Integer> rids = adminUserRoleService.listAllByUid(uid)
                .stream().map(AdminUserRole::getRid).collect(Collectors.toList());
        System.out.println(rids);
        if (rids.isEmpty()){
            return null;
        }
        return adminRoleMapper.selectBatchIds(rids);
    }

    public AdminRole updateRoleStatus(AdminRole role) {
        AdminRole roleInDB = adminRoleMapper.selectById(role.getId());
        roleInDB.setEnabled(role.isEnabled());
        adminRoleMapper.updateById(roleInDB);
        return roleInDB;
    }

    public void editRole(@RequestBody AdminRole role) {
        adminRoleMapper.updateById(role);
        adminRolePermissionService.savePermChanges(role.getId(), role.getPerms());
    }
}

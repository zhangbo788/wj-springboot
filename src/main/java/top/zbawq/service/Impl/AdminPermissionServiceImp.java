package top.zbawq.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zbawq.mapper.AdminPermissionMapper;
import top.zbawq.mapper.AdminRolePermissionMapper;
import top.zbawq.pojo.AdminPermission;
import top.zbawq.pojo.AdminRole;
import top.zbawq.pojo.AdminRolePermission;
import top.zbawq.service.AdminPermissionService;
import top.zbawq.service.AdminRolePermissionService;
import top.zbawq.service.AdminRoleService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminPermissionServiceImp implements AdminPermissionService {
    @Autowired
    private AdminPermissionMapper adminPermissionMapper;

    @Autowired
    private AdminRolePermissionMapper adminRolePermissionMapper;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private AdminRolePermissionService adminRolePermissionService;

    public List<AdminPermission> list() {
        return adminPermissionMapper.selectAllPermission();
    }

    public List<AdminPermission> listPermsByRoleId(int rid) {
        List<Integer> pids = adminRolePermissionService.findAllByRid(rid)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());
        if (pids.isEmpty()){
            return null;
        }
        List<AdminPermission> adminPermissions = adminPermissionMapper.selectBatchIds(pids);
        return adminPermissions;
    }
    public Set<String> listPermissionURLsByUser(String username) {
        List<Integer> rids = adminRoleService.listRolesByUser(username)
                .stream().map(AdminRole::getId).collect(Collectors.toList());


        List<Integer> pids = adminRolePermissionService.findAllByRids(rids)
                .stream().map(AdminRolePermission::getPid).collect(Collectors.toList());
        List<AdminPermission> perms = adminPermissionMapper.selectBatchIds(pids);
        Set<String> URLs = perms.stream().map(AdminPermission::getUrl).collect(Collectors.toSet());
        return URLs;
    }
    public boolean needFilter(String requestAPI) {
        List<AdminPermission> ps = adminPermissionMapper.selectAllPermission();
        for (AdminPermission p: ps) {
            // match prefix
            if (requestAPI.startsWith(p.getUrl())) {
                return true;
            }
        }
        return false;
    }

}

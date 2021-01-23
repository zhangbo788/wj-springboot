package top.zbawq.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zbawq.mapper.AdminRolePermissionMapper;
import top.zbawq.pojo.AdminPermission;
import top.zbawq.pojo.AdminRolePermission;
import top.zbawq.service.AdminRolePermissionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class AdminRolePermissionServiceImpl implements AdminRolePermissionService {
    @Autowired
    AdminRolePermissionMapper adminRolePermissionMapper;

    public List<AdminRolePermission> findAllByRid(int rid) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("rid",rid);
        return adminRolePermissionMapper.selectByMap(map);
    }
    public List<AdminRolePermission> findAllByRids(List<Integer> rids) {
        LinkedList<AdminRolePermission> adminRolePermissions = new LinkedList<>();
        for (Integer rid : rids) {
            List<AdminRolePermission> allByRid = findAllByRid(rid);
            adminRolePermissions.addAll(allByRid);
        }
        return adminRolePermissions;
    }

    //    @Modifying
    @Transactional
    public void savePermChanges(int rid, List<AdminPermission> perms) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("rid",rid);
        adminRolePermissionMapper.deleteByMap(map);
        List<AdminRolePermission> rps = new ArrayList<>();
        perms.forEach(p -> {
            AdminRolePermission rp = new AdminRolePermission();
            rp.setRid(rid);
            rp.setPid(p.getId());
            rps.add(rp);
        });
        for (AdminRolePermission rp : rps) {
            adminRolePermissionMapper.insert(rp);
        }
    }
}

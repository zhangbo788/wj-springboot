package top.zbawq.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zbawq.mapper.AdminUserRoleMapper;
import top.zbawq.pojo.AdminRole;
import top.zbawq.pojo.AdminUserRole;
import top.zbawq.service.AdminUserRoleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AdminUserRoleServiceImp implements AdminUserRoleService {
    @Autowired
    private AdminUserRoleMapper adminUserRoleMapper;
    @Override
    public List<AdminUserRole> listAllByUid(int uid) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid",uid);
        List<AdminUserRole> adminUserRoles = adminUserRoleMapper.selectByMap(map);
        return adminUserRoles;
    }
    //因为我们执行了删除操作，所以需要加上 @Transactional 注释开启事务，以保证数据的一致性。（不加是会跑出异常的哈）
    @Transactional
    public void saveRoleChanges(int uid, List<AdminRole> roles) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid",uid);
        adminUserRoleMapper.deleteByMap(map);
        List<AdminUserRole> urs = new ArrayList<>();
        roles.forEach(r -> {
            AdminUserRole ur = new AdminUserRole();
            ur.setUid(uid);
            ur.setRid(r.getId());
            urs.add(ur);
        });
        for (AdminUserRole ur : urs) {
            adminUserRoleMapper.insert(ur);
        }
    }
}

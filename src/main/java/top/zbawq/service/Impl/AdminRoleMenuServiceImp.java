package top.zbawq.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zbawq.mapper.AdminRoleMenuMapper;
import top.zbawq.pojo.AdminRoleMenu;
import top.zbawq.service.AdminRoleMenuService;

import java.util.*;

@Service
public class AdminRoleMenuServiceImp implements AdminRoleMenuService {

    @Autowired
    private AdminRoleMenuMapper adminRoleMenuMapper;

    @Override
    public List<AdminRoleMenu> findAllByRid(int rid) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("rid",rid);
        List<AdminRoleMenu> adminRoleMenus = adminRoleMenuMapper.selectByMap(map);
        return adminRoleMenus;
    }

    @Override
    public List<AdminRoleMenu> findAllByRids(List<Integer> rids) {
        LinkedList<AdminRoleMenu> adminRoleMenus = new LinkedList<>();
        for (Integer rid : rids) {
            List<AdminRoleMenu> allByRid = findAllByRid(rid);
            adminRoleMenus.addAll(allByRid);
        }
        return adminRoleMenus;
    }
    public void updateRoleMenu(int rid, Map<String, List<Integer>> menusIds) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("rid",rid);
        adminRoleMenuMapper.deleteByMap(map);
        List<AdminRoleMenu> rms = new ArrayList<>();
        for (Integer mid : menusIds.get("menusIds")) {
            AdminRoleMenu rm = new AdminRoleMenu();
            rm.setMid(mid);
            rm.setRid(rid);
            rms.add(rm);
        }
        for (AdminRoleMenu rm : rms) {
            adminRoleMenuMapper.insert(rm);
        }

    }
}

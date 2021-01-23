package top.zbawq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.zbawq.mapper.AdminMenuMapper;
import top.zbawq.mapper.AdminPermissionMapper;
import top.zbawq.pojo.AdminRole;
import top.zbawq.service.AdminMenuService;
import top.zbawq.service.AdminRoleService;
import top.zbawq.service.UserService;

import java.util.List;

@SpringBootTest
class WjSpringbootApplicationTests {

    @Autowired
    private AdminMenuMapper adminMenuMapper;

    @Autowired
    private AdminMenuService adminMenuService;
    @Autowired
    private UserService userService;
    @Autowired
    private AdminPermissionMapper adminPermissionMapper;
    @Autowired
    private AdminRoleService adminRoleService;
    @Test
    void test1(){
        System.out.println(userService.list());
    }

    @Test
    void test02(){
        System.out.println(adminRoleService.listWithPermsAndMenus());
    }

    @Test
    void test03(){
//        AdminRole adminRole = new AdminRole();
//        adminRole.setId(100);
//        adminRole.setName("仅仅是测试");
//        adminRole.setNameZh("111");
//        adminRole.setEnabled(true);
//        adminRoleService.addOrUpdate(adminRole);
        List<AdminRole> adminRoles = adminRoleService.listWithPermsAndMenus();
        System.out.println(adminRoles);
    }
}

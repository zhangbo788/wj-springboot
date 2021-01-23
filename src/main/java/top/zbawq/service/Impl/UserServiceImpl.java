package top.zbawq.service.Impl;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zbawq.dto.UserDTO;
import top.zbawq.mapper.UserMapper;
import top.zbawq.pojo.AdminRole;
import top.zbawq.pojo.User;
import top.zbawq.service.AdminRoleService;
import top.zbawq.service.AdminUserRoleService;
import top.zbawq.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AdminUserRoleService adminUserRoleService;
    @Autowired
    private AdminRoleService adminRoleService;

    public List<UserDTO> list() {
        List<User> users = userMapper.selectAllUser();
        List<UserDTO> userDTOS = users
                .stream().map(user -> (UserDTO) new UserDTO().convertFrom(user)).collect(Collectors.toList());

        userDTOS.forEach(u -> {
            List<AdminRole> roles = adminRoleService.listRolesByUser(u.getUsername());
            u.setRoles(roles);
        });
        return userDTOS;
    }

    @Override
    public List<User> findUsers() {
        return null;
    }

    @Override
    public boolean isExist(String username) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("username",username);
        List<User> users = userMapper.selectByMap(stringObjectHashMap);
        if (users.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public int addUser(User user) {
        userMapper.insert(user);
        return 1;
    }

    @Override
    public User findByUsername(String username) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("username",username);
        List<User> users = userMapper.selectByMap(stringObjectHashMap);
        return users.get(0);
    }

    @Override
    public List<User> getByUsernameAndPassword(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username",username);
        map.put("password",password);
        List<User> users = userMapper.selectByMap(map);
        return users;
    }
    public void updateUserStatus(User user) {
//        User userInDB = userDAO.findByUsername(user.getUsername());
//        userInDB.setEnabled(user.isEnabled());
//        userDAO.save(userInDB);
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        User user1 = userMapper.selectByMap(map).get(0);
        user1.setEnabled(user.getEnabled());
        userMapper.updateById(user1);
    }
    public User resetPassword(User user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        User userInDB = userMapper.selectByMap(map).get(0);
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        int times = 2;
        userInDB.setSalt(salt);
        String encodedPassword = new SimpleHash("md5", "123", salt, times).toString();
        userInDB.setPassword(encodedPassword);
        userMapper.updateById(userInDB);
        return userInDB;
    }
    public void editUser(User user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        User userInDB = userMapper.selectByMap(map).get(0);
        userInDB.setName(user.getName());
        userInDB.setPhone(user.getPhone());
        userInDB.setEmail(user.getEmail());
        userMapper.updateById(userInDB);
        adminUserRoleService.saveRoleChanges(userInDB.getId(), user.getRoles());
    }
}

package top.zbawq.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.zbawq.mapper.UserMapper;
import top.zbawq.pojo.User;
import top.zbawq.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Autowired
    private UserMapper userMapper;


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
}

package top.zbawq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.zbawq.pojo.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> findUsers();
    boolean isExist(String username);
    int addUser(User user);
    User findByUsername(String username);
    List<User> getByUsernameAndPassword(String username,String password);
}

package top.zbawq.service;

import top.zbawq.dto.UserDTO;
import top.zbawq.pojo.User;

import java.util.List;

public interface UserService {
    List<UserDTO> list();
    List<User> findUsers();
    boolean isExist(String username);
    int addUser(User user);
    User findByUsername(String username);
    List<User> getByUsernameAndPassword(String username,String password);
    void updateUserStatus(User user);
    User resetPassword(User user);
    public void editUser(User user);
}

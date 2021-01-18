package top.zbawq.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
import top.zbawq.pojo.Result;
import top.zbawq.pojo.User;
import top.zbawq.service.UserService;
import top.zbawq.utils.ResultFactory;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/login")
    public Result login(@RequestBody User user,HttpSession session){
        String username = user.getUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, user.getPassword());
        //设置记住我功能，具体功能再配置中定义
        usernamePasswordToken.setRememberMe(true);

        try {
            subject.login(usernamePasswordToken);
            return new ResultFactory().buildSuccessResult(username);
        }catch (Exception e){
            String message="用户名密码错误";
            return new ResultFactory().buildFailResult(message);
        }

    }

    @GetMapping(value = "/api/authentication")
    public String authentication(){
        return "身份认证成功";
    }

    @GetMapping("/api/logout")
    public Result loginOut(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message="退出成功";
        Result result = ResultFactory.buildSuccessResult(message);
        System.out.println("测试git");
        return result;
    }

    @GetMapping("ping")
    public String test(){
        return "pang";
    }
    @PostMapping("/api/register")
    public Result register(@RequestBody User user){
        String username = user.getUsername();
        String password = user.getPassword();
        username = HtmlUtils.htmlEscape(username);

        boolean exist = userService.isExist(username);
        if (exist){
            String message = "用户名已被使用";
            Result result = ResultFactory.buildFailResult("用户名已创建");
            return result;
        }
        // 生成随机盐
        String s = new SecureRandomNumberGenerator().nextBytes().toString();
        int times=2;
        // 对密码进行加密
        String enCodingPassword = new SimpleHash("md5", password, s, times).toString();
        user.setUsername(username);
        user.setPassword(enCodingPassword);
        user.setSalt(s);
        userService.addUser(user);
        return ResultFactory.buildSuccessResult(user);

    }
}

package main.controller;

import main.entity.UserEntity;
import main.service.UserService;
import main.service.UserServiceImp;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value="/create",method= RequestMethod.GET)
    public void create(@RequestHeader String user_account,@RequestHeader String user_name){
        System.out.println(1);
        UserEntity user=new UserEntity();
        user.setUser_account(user_account);
        user.setUser_name(user_name);
        UserService use=new UserServiceImp();
        use.create(user);
    }
    @RequestMapping(value="/delete",method=RequestMethod.GET)
    public void delete(String user_account){
        System.out.println(2);
        UserService use=new UserServiceImp();
        use.delete(user_account);
    }
    @RequestMapping(value="/retrieve",method=RequestMethod.GET)
    public UserEntity retrieve(String user_account){
        System.out.println(3);
        UserService use=new UserServiceImp();
        return use.retrieve(user_account);
    }
    @RequestMapping(value="/update",method=RequestMethod.GET)
    public void update(String user_account,String user_name){
        System.out.println(4);
        UserEntity user=new UserEntity();
        user.setUser_account(user_account);
        user.setUser_name(user_name);
        UserService use=new UserServiceImp();
        use.update(user);
    }
}

package net.sender.newsleetersever.Controller;

import net.sender.newsleetersever.Entity.User.UserCreateEntity;
import net.sender.newsleetersever.Entity.User.UserDeleteEntity;
import net.sender.newsleetersever.Entity.User.UserOutEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class UserController {

    ArrayList<UserOutEntity> userList = new ArrayList<UserOutEntity>();

    @GetMapping("/api/v1/users")
    public ArrayList<UserOutEntity> getUserList(){
        userList.add(new UserOutEntity(1L,"user1", "company1", "addr1" ));
        userList.add(new UserOutEntity(2L,"user4", "company4", "addr4" ));
        userList.add(new UserOutEntity(3L,"user4", "company4", "addr4" ));
        return userList;
    }


    @DeleteMapping("/api/v1/user/delete/{userId}")
    public UserDeleteEntity deleteEntity (@PathVariable long userId){
        if(userId == 1L) return new UserDeleteEntity("OK");
        else return new UserDeleteEntity( "UNKNOWN_USER");
    }


    @GetMapping("/api/v1/user/{userId}")
    public UserOutEntity getUserById(@PathVariable Long userId) {
        return new UserOutEntity(userId,"user" + userId.toString(), "company1", "addr1");
    }


    @PostMapping("/api/v1/user")
    public UserOutEntity createUser(@Valid @RequestBody UserCreateEntity userIn){
        return new UserOutEntity(4L,userIn.getUsername(),userIn.getCompanyName(),userIn.getAddress());
    }


    @PutMapping("/api/v1/user/{newCompanyName}")
    public UserOutEntity updateUserOutEntity (@PathVariable String newCompanyName, UserOutEntity userOutEntity ){
        userOutEntity.setCompanyName(newCompanyName);
        return userOutEntity ;
    }

}

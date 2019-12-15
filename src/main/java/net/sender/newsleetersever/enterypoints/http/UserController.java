package net.sender.newsleetersever.enterypoints.http;

import net.sender.newsleetersever.enterypoints.http.entities.user.UserCreateRequestHttpEntity;
import net.sender.newsleetersever.enterypoints.http.entities.user.UserCreateResponseHttpEntity;
import net.sender.newsleetersever.enterypoints.http.entities.user.UserDeleteEntity;
import net.sender.newsleetersever.enterypoints.http.entities.user.UserOutEntity;
import net.sender.newsleetersever.usecases.user.UserCreateUseCase;
import net.sender.newsleetersever.usecases.user.entities.UserCreateResultUseCaseEntity;
import net.sender.newsleetersever.usecases.user.entities.UserCreateUseCaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    UserCreateUseCase userCreateUseCase;

    ArrayList<UserOutEntity> userList = new ArrayList<UserOutEntity>();

    @GetMapping("/api/v1/users")
    public ArrayList<UserOutEntity> getUserList() {
        userList.add(new UserOutEntity(1L, "user1", "company1", "addr1"));
        userList.add(new UserOutEntity(2L, "user4", "company4", "addr4"));
        userList.add(new UserOutEntity(3L, "user4", "company4", "addr4"));
        return userList;
    }


    @DeleteMapping("/api/v1/user/delete/{userId}")
    public UserDeleteEntity deleteEntity(@PathVariable long userId) {
        if (userId == 1L) return new UserDeleteEntity("OK");
        else return new UserDeleteEntity("UNKNOWN_USER");
    }


    @GetMapping("/api/v1/user/{userId}")
    public UserOutEntity getUserById(@PathVariable Long userId) {
        return new UserOutEntity(userId, "user" + userId.toString(), "company1", "addr1");
    }


    @PostMapping("/api/v1/user")
    public UserCreateResponseHttpEntity createUser(@Valid @RequestBody UserCreateRequestHttpEntity userCreateEntity) {
        UserCreateResultUseCaseEntity result = userCreateUseCase.execute(new UserCreateUseCaseEntity(
                userCreateEntity.getUsername(),
                userCreateEntity.getCompanyName(),
                userCreateEntity.getAddress(),
                userCreateEntity.getPassword()
        ));

        return new UserCreateResponseHttpEntity(
                result.getUserId(),
                result.getUsername(),
                result.getCompanyName(),
                result.getAddress());
    }


    @PutMapping("/api/v1/user/{newCompanyName}")
    public UserOutEntity updateUserOutEntity(@PathVariable String newCompanyName, UserOutEntity userOutEntity) {
        userOutEntity.setCompanyName(newCompanyName);
        return userOutEntity;
    }

}

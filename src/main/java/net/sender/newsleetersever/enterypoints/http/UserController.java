package net.sender.newsleetersever.enterypoints.http;

import net.sender.newsleetersever.enterypoints.http.entities.user.*;
import net.sender.newsleetersever.enterypoints.http.exceptions.BadRequestHttpException;
import net.sender.newsleetersever.usecases.user.UserCreateUseCase;
import net.sender.newsleetersever.usecases.user.UserDeleteUseCase;
import net.sender.newsleetersever.usecases.user.UserUpdateUseCase;
import net.sender.newsleetersever.usecases.user.entities.*;
import net.sender.newsleetersever.usecases.user.exceptions.UseCaseLogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    UserCreateUseCase userCreateUseCase;
    @Autowired
    UserUpdateUseCase userUpdateUseCase;
    @Autowired
    UserDeleteUseCase userDeleteUseCase;

    ArrayList<UserOutEntity> userList = new ArrayList<UserOutEntity>();

    @GetMapping("/api/v1/users")
    public ArrayList<UserOutEntity> getUserList() {
        userList.add(new UserOutEntity(1L, "user1", "company1", "addr1"));
        userList.add(new UserOutEntity(2L, "user4", "company4", "addr4"));
        userList.add(new UserOutEntity(3L, "user4", "company4", "addr4"));
        return userList;
    }


    @DeleteMapping("/api/v1/user/{userId}")
    public UserDeleteResponseHttpEntity deleteEntity(@PathVariable Long userId) {
        UserDeleteInUseCaseEntity useCaseEntity = new UserDeleteInUseCaseEntity();
        useCaseEntity.setUserId(userId);
        UserDeleteOutUseCaseEntity outUseCaseEntity = userDeleteUseCase.execute(useCaseEntity);
        UserDeleteResponseHttpEntity responseHttpEntity = new UserDeleteResponseHttpEntity();
        responseHttpEntity.setAnswer(outUseCaseEntity.getProcessingResult());
        return responseHttpEntity;
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


    @PutMapping("/api/v1/user/{userId}")
    public UserUpdateResponseHttpEntity updateUser(@Valid @RequestBody UserUpdateRequestHttpEntity requestEntity,
                                                   @PathVariable Long userId) {
        UserUpdateInUseCaseEntity updateInUseCaseEntity = new UserUpdateInUseCaseEntity();
        updateInUseCaseEntity.setUserId(userId);
        updateInUseCaseEntity.setCompanyName(requestEntity.getCompanyName());
        updateInUseCaseEntity.setAddress(requestEntity.getAddress());
        updateInUseCaseEntity.setEmail(requestEntity.getEmail());
        try {


            UserUpdateOutUseCaseEntity resultUseCaseEntity = userUpdateUseCase.execute(updateInUseCaseEntity);


            UserUpdateResponseHttpEntity responseHttpEntity = new UserUpdateResponseHttpEntity();
            responseHttpEntity.setUserId(resultUseCaseEntity.getId());
            responseHttpEntity.setAddress(resultUseCaseEntity.getAddress());
            responseHttpEntity.setCompanyName(resultUseCaseEntity.getCompanyName());
            responseHttpEntity.setEmail(resultUseCaseEntity.getEmail());
            responseHttpEntity.setUsername(resultUseCaseEntity.getUsername());
            return responseHttpEntity;
        } catch (UseCaseLogicException e) {
            throw new BadRequestHttpException(e.getMessage(),e);
        }
    }
}

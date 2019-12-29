package ru.newsletersever.enterypoints.http;

import ru.newsletersever.enterypoints.http.entities.user.*;
import ru.newsletersever.enterypoints.http.exceptions.BadRequestHttpException;
import ru.newsletersever.usecases.user.*;
import ru.newsletersever.usecases.user.entities.*;
import ru.newsletersever.usecases.user.exceptions.UseCaseLogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserCreateUseCase userCreateUseCase;
    @Autowired
    UserUpdateUseCase userUpdateUseCase;
    @Autowired
    UserDeleteUseCase userDeleteUseCase;
    @Autowired
    UserSearchUseCase userSearchUseCase;

    @GetMapping("/api/v1/users")
    public UserSearchResponseHttpEntity getAllUsers(@RequestParam(value = "username", required = false) String username) {
        UserSearchOutUseCaseEntity userSearchOutUseCaseEntity = userSearchUseCase.execute(username);

        UserSearchResponseHttpEntity responseHttpEntity = new UserSearchResponseHttpEntity();
        responseHttpEntity.setFoundItems((long) userSearchOutUseCaseEntity.getUserList().size());

        for (UserShortUseCaseEntity userShortUseCaseEntity : userSearchOutUseCaseEntity.getUserList()) {
            UserShortResponseHttpEntity userShortResponseHttpEntity = new UserShortResponseHttpEntity();
            userShortResponseHttpEntity.setUserId(userShortUseCaseEntity.getUserId());
            userShortResponseHttpEntity.setUsername(userShortUseCaseEntity.getUsername());

            responseHttpEntity.getUserList().add(userShortResponseHttpEntity);
        }

        return responseHttpEntity;
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

    @PostMapping("/api/v1/user")
    public UserCreateResponseHttpEntity createUser(@Valid @RequestBody UserCreateRequestHttpEntity userCreateEntity) {
        UserCreateUseCaseEntity userCreateUseCaseEntity = new UserCreateUseCaseEntity();

        userCreateUseCaseEntity.setUsername(userCreateEntity.getUsername());
        userCreateUseCaseEntity.setAddress(userCreateEntity.getAddress());
        userCreateUseCaseEntity.setCleanPassword(userCreateEntity.getPassword());
        userCreateUseCaseEntity.setCompanyName(userCreateEntity.getCompanyName());
        userCreateUseCaseEntity.setEmail(userCreateEntity.getEmail());

        UserCreateResultUseCaseEntity userCreateResultUseCaseEntity = userCreateUseCase.execute(userCreateUseCaseEntity);

        UserCreateResponseHttpEntity responseHttpEntity = new UserCreateResponseHttpEntity();
        responseHttpEntity.setUserId(userCreateResultUseCaseEntity.getUserId());
        responseHttpEntity.setUsername(userCreateResultUseCaseEntity.getUsername());
        responseHttpEntity.setCompanyName(userCreateResultUseCaseEntity.getCompanyName());
        responseHttpEntity.setAddress(userCreateResultUseCaseEntity.getAddress());
        responseHttpEntity.setEmail(userCreateResultUseCaseEntity.getEmail());
        return responseHttpEntity;
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
            throw new BadRequestHttpException(e.getMessage(), e);
        }
    }
}

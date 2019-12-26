package net.sender.newsleetersever.enterypoints.http;

import net.sender.newsleetersever.enterypoints.http.entities.user.*;
import net.sender.newsleetersever.enterypoints.http.exceptions.BadRequestHttpException;
import net.sender.newsleetersever.usecases.user.UserCreateUseCase;
import net.sender.newsleetersever.usecases.user.UserDeleteUseCase;
import net.sender.newsleetersever.usecases.user.UserSearchUseCase;
import net.sender.newsleetersever.usecases.user.UserUpdateUseCase;
import net.sender.newsleetersever.usecases.user.entities.*;
import net.sender.newsleetersever.usecases.user.exceptions.UseCaseLogicException;
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
    public List<UserSearchResponseHttpEntity> getAllUsers() {
        List<UserSearchResponseHttpEntity> listOut = new ArrayList<UserSearchResponseHttpEntity>();
        List<UserSearchOutUseCaseEntity> userSearchOutUseCaseEntityList = userSearchUseCase.execute();

        for(int i = 0; i<userSearchOutUseCaseEntityList.size();i++){
            UserSearchOutUseCaseEntity tmpOut = userSearchOutUseCaseEntityList.get(i);
            UserSearchResponseHttpEntity tmpIn = new UserSearchResponseHttpEntity();
            tmpIn.setId(tmpOut.getUserId());
            tmpIn.setUsername(tmpOut.getUsername());
            listOut.add(tmpIn);
        }

        return listOut;
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

        UserCreateResponseHttpEntity result = new UserCreateResponseHttpEntity();
        result.setUserId(userCreateResultUseCaseEntity.getUserId());
        result.setUsername(userCreateResultUseCaseEntity.getUsername());
        result.setCompanyName(userCreateResultUseCaseEntity.getCompanyName());
        result.setAddress(userCreateResultUseCaseEntity.getAddress());
        result.setEmail(userCreateResultUseCaseEntity.getEmail());
        return result;
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

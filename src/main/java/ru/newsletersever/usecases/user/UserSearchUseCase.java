package ru.newsletersever.usecases.user;


import ru.newsletersever.dataproviders.postgres.user.UserRepository;
import ru.newsletersever.dataproviders.postgres.user.entities.UserDbEntity;
import ru.newsletersever.usecases.user.entities.UserSearchOutUseCaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.newsletersever.usecases.user.entities.UserShortUseCaseEntity;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSearchUseCase {

    //TODO Need implement user use case for search - get all users

    @Autowired
    UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserSearchUseCase.class);

    public UserSearchOutUseCaseEntity execute(String filterByUsername) {
        log.info("Return all users from database");
        UserSearchOutUseCaseEntity userSearchOutUseCaseEntity = new UserSearchOutUseCaseEntity();

        List<UserDbEntity> dbEntityList;
        if(filterByUsername!=null){
         dbEntityList = userRepository.findByUsername(filterByUsername);
        } else {
            dbEntityList = userRepository.findAll();
        }

        for (UserDbEntity dbUserEntity : dbEntityList) {
            UserShortUseCaseEntity userShortUseCaseEntity = new UserShortUseCaseEntity();
            userShortUseCaseEntity.setUserId(dbUserEntity.getUserId());
            userShortUseCaseEntity.setUsername(dbUserEntity.getUsername());
            userShortUseCaseEntity.setCompanyName(dbUserEntity.getCompanyName());

            userSearchOutUseCaseEntity.getUserList().add(userShortUseCaseEntity);
        }

        return userSearchOutUseCaseEntity;
    }
}

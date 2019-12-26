package net.sender.newsleetersever.usecases.user;


import net.sender.newsleetersever.dataproviders.postgres.user.UserRepository;
import net.sender.newsleetersever.dataproviders.postgres.user.entities.UserDbEntity;
import net.sender.newsleetersever.usecases.user.entities.UserSearchOutUseCaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSearchUseCase {

    //TODO Need implement user use case for search - get all users

    @Autowired
    UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserSearchUseCase.class);

    public List<UserSearchOutUseCaseEntity> execute() {
        log.info("Return all users from database");
        List<UserSearchOutUseCaseEntity> arrayOut = new ArrayList<UserSearchOutUseCaseEntity>();

        List<UserDbEntity> arrayDb;
        arrayDb = userRepository.findAll();

        for (int i =0; i < arrayDb.size(); i++){
            UserDbEntity tmpDb = arrayDb.get(i);
            UserSearchOutUseCaseEntity tmpUseCase  = new UserSearchOutUseCaseEntity();
            tmpUseCase.setUserId(tmpDb.getUserId());
            tmpUseCase.setUsername(tmpDb.getUsername());
            arrayOut.add(tmpUseCase);
        }

        return arrayOut;
    }
}

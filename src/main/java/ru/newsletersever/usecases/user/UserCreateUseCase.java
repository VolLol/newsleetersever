package ru.newsletersever.usecases.user;

import ru.newsletersever.dataproviders.postgres.user.UserRepository;
import ru.newsletersever.dataproviders.postgres.user.entities.UserDbEntity;
import ru.newsletersever.usecases.user.entities.UserCreateResultUseCaseEntity;
import ru.newsletersever.usecases.user.entities.UserCreateUseCaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserCreateUseCase {

    @Autowired
    private UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserCreateUseCase.class);

    public UserCreateResultUseCaseEntity execute(UserCreateUseCaseEntity entityIn) {
        log.info("User created: " + entityIn.getUsername() + ", " + entityIn.getAddress() + " " + entityIn.getCompanyName());
        UserDbEntity userDbEntity = new UserDbEntity();
        userDbEntity.setUsername(entityIn.getUsername());
        userDbEntity.setAddress(entityIn.getAddress());
        userDbEntity.setCompanyName(entityIn.getCompanyName());
        userDbEntity.setCryptPassword(new BCryptPasswordEncoder().encode(entityIn.getCleanPassword()));
        userDbEntity.setEmail(entityIn.getEmail());
        userRepository.save(userDbEntity);
        UserCreateResultUseCaseEntity result = new UserCreateResultUseCaseEntity();
        result.setUserId(userDbEntity.getUserId());
        result.setUsername(userDbEntity.getUsername());
        result.setEmail(userDbEntity.getEmail());
        result.setCompanyName(userDbEntity.getCompanyName());
        result.setAddress(userDbEntity.getAddress());

        return result;
    }


}

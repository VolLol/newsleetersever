package net.sender.newsleetersever.usecases.user;

import net.sender.newsleetersever.dataproviders.postgres.user.UserRepository;
import net.sender.newsleetersever.dataproviders.postgres.user.entities.UserDbEntity;
import net.sender.newsleetersever.usecases.user.entities.UserCreateResultUseCaseEntity;
import net.sender.newsleetersever.usecases.user.entities.UserCreateUseCaseEntity;
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
        userRepository.save(userDbEntity);

        return new UserCreateResultUseCaseEntity(userDbEntity.getUserId(),
                userDbEntity.getUsername(), userDbEntity.getCompanyName(), userDbEntity.getAddress());
    }


}

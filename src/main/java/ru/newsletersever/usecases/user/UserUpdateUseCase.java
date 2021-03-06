package ru.newsletersever.usecases.user;


import ru.newsletersever.dataproviders.postgres.user.UserRepository;
import ru.newsletersever.dataproviders.postgres.user.entities.UserDbEntity;
import ru.newsletersever.usecases.user.entities.UserUpdateOutUseCaseEntity;
import ru.newsletersever.usecases.user.entities.UserUpdateInUseCaseEntity;
import ru.newsletersever.usecases.user.exceptions.UseCaseLogicException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUpdateUseCase {

    @Autowired
    UserRepository userRepository;
    private static final Logger log = LoggerFactory.getLogger(UserUpdateUseCase.class);

    //TODO Implement user use case for update
    public UserUpdateOutUseCaseEntity execute(UserUpdateInUseCaseEntity entityIn) throws UseCaseLogicException {
        log.info("User update with id: " + entityIn.getUserId());
        UserDbEntity userDbEntity = userRepository.findByUserId(entityIn.getUserId());
        if(userDbEntity == null){
            throw new UseCaseLogicException("User not found");
        }
        userDbEntity.setAddress(entityIn.getAddress());
        userDbEntity.setCompanyName(entityIn.getCompanyName());
        userDbEntity.setEmail(entityIn.getEmail());
        userDbEntity = userRepository.save(userDbEntity);

        UserUpdateOutUseCaseEntity userOut = new UserUpdateOutUseCaseEntity();
        userOut.setUserId(userDbEntity.getUserId());
        userOut.setAddress(userDbEntity.getAddress());
        userOut.setCompanyName(userDbEntity.getCompanyName());
        userOut.setUsername(userDbEntity.getUsername());
        userOut.setEmail(userDbEntity.getEmail());

        return userOut;
    }
}

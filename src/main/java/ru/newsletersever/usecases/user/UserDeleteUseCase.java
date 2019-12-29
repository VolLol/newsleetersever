package ru.newsletersever.usecases.user;

import ru.newsletersever.dataproviders.postgres.user.UserRepository;
import ru.newsletersever.dataproviders.postgres.user.entities.UserDbEntity;
import ru.newsletersever.usecases.user.entities.UserDeleteInUseCaseEntity;
import ru.newsletersever.usecases.user.entities.UserDeleteOutUseCaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDeleteUseCase {
    @Autowired
    UserRepository userRepository;

    //TODO Need implement user use case for delete
    public UserDeleteOutUseCaseEntity execute(UserDeleteInUseCaseEntity entityIn) {
        UserDeleteOutUseCaseEntity outUseCaseEntity = new UserDeleteOutUseCaseEntity();
        UserDbEntity userDbEntity = userRepository.findByUserId(entityIn.getUserId());
        if (userDbEntity == null) {
            outUseCaseEntity.setProcessingResult("Not found");
            return outUseCaseEntity;
        }
        userRepository.delete(userDbEntity);
        outUseCaseEntity.setProcessingResult("OK");
        return outUseCaseEntity;
    }
}

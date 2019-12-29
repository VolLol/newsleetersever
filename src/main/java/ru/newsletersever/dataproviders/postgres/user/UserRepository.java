package ru.newsletersever.dataproviders.postgres.user;

import ru.newsletersever.dataproviders.postgres.user.entities.UserDbEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDbEntity, Long> {

    ArrayList<UserDbEntity> findAll();

    UserDbEntity findByUserId(Long id);

    List<UserDbEntity> findByUsername(String username);
}

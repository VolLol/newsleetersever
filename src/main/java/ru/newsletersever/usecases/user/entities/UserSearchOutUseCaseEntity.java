package ru.newsletersever.usecases.user.entities;

import java.util.ArrayList;
import java.util.List;

public class UserSearchOutUseCaseEntity {
    private List<UserShortUseCaseEntity> userList = new ArrayList<>();

    public List<UserShortUseCaseEntity> getUserList() {
        return userList;
    }
}

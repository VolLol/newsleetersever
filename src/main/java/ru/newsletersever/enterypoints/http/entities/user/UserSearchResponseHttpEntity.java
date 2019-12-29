package ru.newsletersever.enterypoints.http.entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class UserSearchResponseHttpEntity {
    @JsonProperty("items")
    private List<UserShortResponseHttpEntity> userList = new ArrayList<>();

    @JsonProperty("foundItems")
    private Long foundItems;

    public List<UserShortResponseHttpEntity> getUserList() {
        return userList;
    }

    public Long getFoundItems() {
        return foundItems;
    }

    public void setFoundItems(Long foundItems) {
        this.foundItems = foundItems;
    }
}

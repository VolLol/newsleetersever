package ru.newsletersever.enterypoints.http.entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserShortResponseHttpEntity {
    @JsonProperty("id")
    private Long userId;
    @JsonProperty("username")
    private String username;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

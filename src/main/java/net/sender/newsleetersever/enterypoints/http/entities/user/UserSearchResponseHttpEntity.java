package net.sender.newsleetersever.enterypoints.http.entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserSearchResponseHttpEntity {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("username")
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

package net.sender.newsleetersever.enterypoints.http.entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

public class UserCreateResponseHttpEntity {

    @JsonProperty("id")
    Long userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("address")
    private String address;

    public UserCreateResponseHttpEntity() {
    }

    public UserCreateResponseHttpEntity(Long userId, String username, String companyName, String address) {
        this.userId = userId;
        this.username = username;
        this.companyName = companyName;
        this.address = address;
    }

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}

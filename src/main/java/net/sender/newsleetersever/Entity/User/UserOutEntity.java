package net.sender.newsleetersever.Entity.User;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

@Entity
public class UserOutEntity {

    private Long userId;
    private String username;
    private String companyName;
    private String address;

    public UserOutEntity() {}
    public UserOutEntity(Long userId, String username, String companyName, String address) {
        this.username = username;
        this.companyName = companyName;
        this.address = address;
        this.userId = userId;
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

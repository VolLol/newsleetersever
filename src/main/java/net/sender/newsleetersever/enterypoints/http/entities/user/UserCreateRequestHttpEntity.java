package net.sender.newsleetersever.enterypoints.http.entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;


public class UserCreateRequestHttpEntity {

    @JsonProperty("username")
    private String username;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package net.sender.newsleetersever.enterypoints.http.entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserCreateRequestHttpEntity {

    @JsonProperty("username")
    private String username;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("password")
    @NotBlank(message = "TVAR POSTAV PAROL!!!!!")
    @Size(min = 3, max = 40, message = "Минимальная длинна пароля - 3 символа, максимальная длинна пароля - 40 символов")
    private String password;

    UserCreateRequestHttpEntity() { }

    UserCreateRequestHttpEntity(String username, String companyName, String address, String password) {
        this.username = username;
        this.companyName = companyName;
        this.address = address;
        this.password = password;
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

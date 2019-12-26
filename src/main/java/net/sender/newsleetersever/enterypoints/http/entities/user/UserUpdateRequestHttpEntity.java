package net.sender.newsleetersever.enterypoints.http.entities.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class UserUpdateRequestHttpEntity {

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("address")
    private String address;

    @JsonProperty("email")
    @NotBlank
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

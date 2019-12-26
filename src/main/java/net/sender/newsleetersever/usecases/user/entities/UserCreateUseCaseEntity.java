package net.sender.newsleetersever.usecases.user.entities;


public class UserCreateUseCaseEntity {

    private String username;
    private String companyName;
    private String address;
    private String cleanPassword; //незашифрованный пароль
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

    public String getCleanPassword() {
        return cleanPassword;
    }

    public void setCleanPassword(String cleanPassword) {
        this.cleanPassword = cleanPassword;
    }
}

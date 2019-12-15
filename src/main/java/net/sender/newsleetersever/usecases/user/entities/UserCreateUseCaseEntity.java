package net.sender.newsleetersever.usecases.user.entities;


public class UserCreateUseCaseEntity {

    private String username;
    private String companyName;
    private String address;
    private String cleanPassword; //незашифрованный пароль

    public UserCreateUseCaseEntity() {
    }

    public UserCreateUseCaseEntity(String username, String companyName, String address, String cleanPassword) {
        this.username = username;
        this.companyName = companyName;
        this.address = address;
        this.cleanPassword = cleanPassword;
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

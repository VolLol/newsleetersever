package net.sender.newsleetersever.usecases.user.entities;

public class UserCreateResultUseCaseEntity {

    private Long userId;
    private String username;
    private String companyName;
    private String address;

    public UserCreateResultUseCaseEntity() {
    }

    public UserCreateResultUseCaseEntity(Long userId, String username, String companyName, String address) {
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

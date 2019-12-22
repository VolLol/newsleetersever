package net.sender.newsleetersever.enterypoints.http.entities.user;


import javax.persistence.Entity;

public class UserDeleteResponseHttpEntity {

    private String answer;

    public UserDeleteResponseHttpEntity(){}

    public UserDeleteResponseHttpEntity(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

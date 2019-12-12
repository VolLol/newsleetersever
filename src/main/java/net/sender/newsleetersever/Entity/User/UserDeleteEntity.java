package net.sender.newsleetersever.Entity.User;


import javax.persistence.Entity;

@Entity
public class UserDeleteEntity {

    private String answer;

    public UserDeleteEntity(){}

    public UserDeleteEntity(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

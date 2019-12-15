package net.sender.newsleetersever.enterypoints.http.entities.newsletter;

import javax.persistence.Entity;


public class NewsLetterDeleteEntity {

    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public NewsLetterDeleteEntity (){}

    public NewsLetterDeleteEntity(String answer){
        this.answer = answer;
    }
}

package ru.newsletersever.enterypoints.http.entities.newsletter;


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

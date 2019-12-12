package net.sender.newsleetersever.Entity.Newsletter;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;

@Entity
public class NewsLetterCreateEntity {

    @JsonProperty("newsLetterName")
    private String newsLetterName;
    @JsonProperty("subject")
    private String subject;
    @JsonProperty("letterText")
    private String letterText;
    @JsonProperty("from")
    private String from;
    @JsonProperty("to")
    private String to;

    public NewsLetterCreateEntity(){}

    public NewsLetterCreateEntity(String newsLetterName, String subject, String letterText, String from, String to) {
        this.newsLetterName = newsLetterName;
        this.subject = subject;
        this.letterText = letterText;
        this.from = from;
        this.to = to;
    }

    public String getNewsLetterName() {
        return newsLetterName;
    }

    public void setNewsLetterName(String newsLetterName) {
        this.newsLetterName = newsLetterName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getLetterText() {
        return letterText;
    }

    public void setLetterText(String letterText) {
        this.letterText = letterText;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}

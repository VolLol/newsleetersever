package ru.newsletersever.enterypoints.http.entities.newsletter;


public class NewsLetterOutEntity {



    private Long id;
    private String newsLetterName;
    private String subject;
    private String letterText;
    private String to;

    public NewsLetterOutEntity(){}

    public NewsLetterOutEntity(Long id,String newsLetterName, String subject, String letterText, String to) {
        this.id = id;
        this.newsLetterName = newsLetterName;
        this.subject = subject;
        this.letterText = letterText;
        this.to = to;
    }

    public Long getId() {return id; }
    public void setId(Long id) { this.id = id; }

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

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}

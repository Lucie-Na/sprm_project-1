package models;

import java.sql.Date;

public class Question {
    private String noUser;
    private String noTravel;
    private String question;
    private String answer;
    private Date date;

    public Question(String noUser, String noTravel, String question, String answer, Date date) {
        this.setNoUser(noUser);
        this.setNoTravel(noTravel);
        this.setQuestion(question);
        this.setAnswer(answer);
        this.setDate(date);
    }

    public String getNoUser() {
        return noUser;
    }

    public void setNoUser(String noUser) {
        this.noUser = noUser;
    }

    public String getNoTravel() {
        return noTravel;
    }

    public void setNoTravel(String noTravel) {
        this.noTravel = noTravel;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        question = question.trim();
        if(question.equals("")){throw new IllegalArgumentException("Question is empty");}
        else {this.question = question;}
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        answer = answer.trim();
        if(answer.equals("")){throw new IllegalArgumentException("Answer is empty");}
        else {this.answer = answer;}
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

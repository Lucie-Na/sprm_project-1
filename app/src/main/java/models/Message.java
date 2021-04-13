package models;

import java.sql.Date;

public class Message {

    private String noUserSend;
    private String noUserReceive;
    private String message;
    private Date date;

    public Message(String noUserSend, String noUserReceive, String message, Date date) {
        this.setNoUserSend(noUserSend);
        this.setNoUserReceive(noUserReceive);
        this.setMessage(message);
        this.setDate(date);
    }

    public String getNoUserSend() {
        return noUserSend;
    }

    public void setNoUserSend(String noUserSend) {
        this.noUserSend = noUserSend;
    }

    public String getNoUserReceive() {
        return noUserReceive;
    }

    public void setNoUserReceive(String noUserReceive) {
        this.noUserReceive = noUserReceive;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        message = message.trim();
        if(message.equals("")){throw new IllegalArgumentException("Message is empty");}
        else {this.message = message;}
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

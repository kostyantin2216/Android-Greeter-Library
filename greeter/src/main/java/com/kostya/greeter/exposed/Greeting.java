package com.kostya.greeter.exposed;

public class Greeting {
    private String id;
    private String text;
    private String sender;
    private String receiver;
    private Language language;

    public Greeting() { }

    public Greeting(String id, String text, String sender, String receiver, Language language) {
        this.id = id;
        this.text = text;
        this.sender = sender;
        this.receiver = receiver;
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}

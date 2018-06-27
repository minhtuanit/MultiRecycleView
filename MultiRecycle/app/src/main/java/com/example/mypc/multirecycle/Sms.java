package com.example.mypc.multirecycle;

public class Sms {
    private String name;
    private String text;

    public Sms(String name,String text){
        this.name = name;
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    public void setText(String text) {
        this.text = text;
    }

}

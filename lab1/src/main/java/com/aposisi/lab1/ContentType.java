package com.aposisi.lab1;

public enum ContentType {
    HTML("text/html"),
    PLAIN("text/plain");

    private String text;

    ContentType(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}

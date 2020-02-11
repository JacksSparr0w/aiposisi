package com.aposisi.lab1;

import java.util.Arrays;

public enum ContentType {
    PLAIN("text/plain", "txt"),
    HTML("text/html", "html"),
    CSS("text/css", "css"),
    JS("text/javascript", "js"),
    PNG("image/png", "png"),
    SVG("image/svg+xml", "svg");

    private String text;
    private String extension;

    ContentType(String text, String extension){
        this.text = text;
        this.extension = extension;
    }

    public String getText(){
        return text;
    }

    public String getExtension(){
        return extension;
    }

    public static ContentType findByExtension(String extension){
        return Arrays.stream(ContentType.values())
                .filter(x -> x.getExtension().equalsIgnoreCase(extension))
                .findFirst()
                .orElse(PLAIN);
    }
}

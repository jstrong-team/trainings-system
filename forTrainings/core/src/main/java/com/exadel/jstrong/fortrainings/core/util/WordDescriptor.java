package com.exadel.jstrong.fortrainings.core.util;

/**
 * Created by Sergey Nalivko.
 */
public class WordDescriptor {

    private String word;
    private int position;

    public WordDescriptor(String word, int position) {
        this.word = word;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}

package com.example.autocomplete.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "words")
public class Word {
    @Id
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public Word() {
    }

    public String getWord() {
        return word;
    }

}

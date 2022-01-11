package com.example.autocomplete.dto;

import com.example.autocomplete.model.Word;
import org.springframework.stereotype.Component;

public class Mapper {

    public Word toWord(WordDto wordDto){
        return new Word(wordDto.getWord());
    }

}

package com.example.autocomplete.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class WordDto {

    @NotBlank
    @Pattern(regexp = "[a-zA-Z]*")
    private String word;

    public WordDto() {
    }

    public String getWord() {
        return word;
    }
}

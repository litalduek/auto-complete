package com.example.autocomplete.service;

import com.example.autocomplete.dto.WordDto;

import java.util.List;

public interface AutoCompleteService {
     List<String> suggest(WordDto prefixDto);

    }

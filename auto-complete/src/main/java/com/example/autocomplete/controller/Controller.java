package com.example.autocomplete.controller;

import com.example.autocomplete.dto.WordDto;
import com.example.autocomplete.service.AutoCompleteService;
import com.example.autocomplete.service.AutoCompleteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.awt.print.Book;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/autocomplete")
public class Controller {
    @Resource(name = "autocomplete")
    private AutoCompleteService autoCompleteService;

    @PostMapping("/suggest")
    public ResponseEntity<?> suggest(@Valid @RequestBody WordDto wordDto) {
        return ResponseEntity.ok(autoCompleteService.suggest(wordDto));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}

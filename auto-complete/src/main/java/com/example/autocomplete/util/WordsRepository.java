package com.example.autocomplete.util;

import com.example.autocomplete.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends JpaRepository<Word, String> {

}

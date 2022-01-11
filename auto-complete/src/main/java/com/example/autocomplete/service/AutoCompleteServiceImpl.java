package com.example.autocomplete.service;

import com.example.autocomplete.dto.Mapper;
import com.example.autocomplete.dto.WordDto;
import com.example.autocomplete.model.TrieNode;
import com.example.autocomplete.model.Word;
import com.example.autocomplete.util.WordsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("autocomplete")
public class AutoCompleteServiceImpl implements ApplicationRunner, AutoCompleteService {

    private Mapper mapper = new Mapper();
    private TrieNode root;

    @Autowired
    private WordsRepository wordsRepository;

    public void run(ApplicationArguments args) {
        List<Word> words = wordsRepository.findAll();
        root = new TrieNode();
        for (Word word : words)
            root.insert(word.getWord());
    }

    @Override
    public List<String> suggest(WordDto prefixDto) {
        Word prefix = mapper.toWord(prefixDto);
        List<String> list = new ArrayList<>();
        TrieNode lastNode = root;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.getWord().toCharArray()) {
            lastNode = lastNode.children.get(c);
            if (lastNode == null)
                return list;
            curr.append(c);
        }
        suggestHelper(lastNode, list, curr);
        return list;
    }

    private void suggestHelper(TrieNode root, List<String> list, StringBuffer curr) {
        if (root.isWord) {
            list.add(curr.toString());
        }

        if (root.children == null || root.children.isEmpty())
            return;

        for (TrieNode child : root.children.values()) {
            suggestHelper(child, list, curr.append(child.c));
            curr.setLength(curr.length() - 1);
        }
    }

}

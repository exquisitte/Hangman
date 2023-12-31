package org.example;

import java.util.*;


public class WordList {
    List<String> wordList = new ArrayList<>(Arrays.asList(
            "телефон", "звонок", "разговор", "фильм", "кино" ,"сериал","окно",
            "полотенце", "крыльцо", "кот", "собака", "стол","стул",  "шкаф",
            "вещь", "работа", "мама", "голова", "школа", "сон"
    ));

    public String getRandomWord() {
        int randomIndex = new Random().nextInt(wordList.size());
        return wordList.get(randomIndex);
    }

}

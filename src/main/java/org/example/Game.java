package org.example;

import java.util.HashSet;
import java.util.Set;

public class Game {
    String wordToGuess;
    private Set<Character> guessedLetters;
    int incorectGuess;

    public Game(String wordToGuess) {
        this.wordToGuess = wordToGuess.toLowerCase();
        this.guessedLetters = new HashSet<>();
        this.incorectGuess = 0;
    }

    public String getCurrentState() {
        StringBuilder currentState = new StringBuilder();
        for (char letter : wordToGuess.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                currentState.append(letter);
            } else {
                currentState.append("_");
            }
            currentState.append(" ");
        }
        return currentState.toString().trim();
    }

    public boolean makeGuess(char letter) {
        letter = Character.toLowerCase(letter);

        if (guessedLetters.contains(letter)) {
            return false;
        }

        guessedLetters.add(letter);

        if (!wordToGuess.contains(String.valueOf(letter))) {
            incorectGuess++;

            return false;
        }

        return true;
    }

    public boolean isGameOver() {
        return incorectGuess >= 6 || getCurrentState().equals(wordToGuess.replaceAll(" ", ""));
    }
}

//incorectGuess

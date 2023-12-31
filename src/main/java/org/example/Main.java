package org.example;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Начать новую игру(Н) или выйти(В) из приложения ?");
            char choice = readInput();
            if(choice == 'H'){
                startNewGame();
            }
            else if (choice == 'B'){
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Incorrect choice");
            }
        }
    }

    private static char readInput() {
        return scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
    }

    private static void startNewGame() {
        WordList wordList = new WordList();
        Game game = new Game(wordList.getRandomWord());

        while(!game.isGameOver()){
            System.out.println("Current word: " + game.getCurrentState());
            System.out.println("Write a letter");
            char guess = Character.toLowerCase(readInput());


            if(game.makeGuess(guess)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect. You have:" + (6-game.incorectGuess));
            }
        }
        if (game.getCurrentState().equals(game.wordToGuess)) {
            System.out.println("Congratulations, you guessed the word: " + game.wordToGuess);
        } else {
            System.out.println("Sorry you lost, correct answer was: " + game.wordToGuess);
        }
    }
}

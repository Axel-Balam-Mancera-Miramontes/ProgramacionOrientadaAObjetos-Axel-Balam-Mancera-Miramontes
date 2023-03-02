/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.reto6.ui;

import edu.axel.balam.mancera.miramontes.reto6.process.Game;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * CLI contains all the data tha is going to be processed by the Game class.
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {

    /*
    * Data used by process
     */
    /**
     * Array containing all the possible words to guess depending on the selected difficulty.
     */

    private final static String[][] words = {{"papa", "abcdefgh", "abcdefghijkl"},
                                             {"XXXX", "XXXXXXXX", "XXXXXXXXXXXX"}};
    private static Map<Character, Boolean> guessedLetters = new HashMap<>();
    private static Scanner input = new Scanner(System.in);
    private static char keepPlaying;
    private static char letterToGuess;

    /**
     * Creating the user menu.
     */
    /*
     * Defining an instance of the user menu.
     */
    private static Menu menu = new Menu();

    /*
     *  Menu options.
     */
    private static String EASY_LEVEL_OPTION = "Jugar en nivel fácil.";
    private static String MEDIUM_LEVEL_OPTION = "Jugar en nivel medio.";
    private static String HARD_LEVEL_OPTION = "Jugar en nivel difícil.";

    /*
     * Other texts that are going to be shown within the execution of a selected option.
     */
    private static String REQUEST_LETTER = "Ingrese una letra para determinar si existe dentro de la palabra: ";
    private static String REQUEST_LETTER_NOT_NUMBER = "Ingrese una letra, no un número: ";
    private static String GUESSED_LETTERS = "Con base a la letra escogida, la palabra adivinada es la siguiente manera: %s\n";
    private static String KEEP_PLAYING_OPTION = "¿Desea seguir jugando?\nCualquier letra) Sí.\n0) No\n ";
    private static String END_OF_PROGRAM = "Programa finalizado.";

    public static char readLetter(char letterToGuess){
        letterToGuess = input.nextLine().charAt(0);
        while(letterToGuess >= '1' && letterToGuess <= '9'){
            System.out.print(REQUEST_LETTER_NOT_NUMBER);
            letterToGuess = input.nextLine().charAt(0);
        }
        if(letterToGuess == '0'){
            menu.killMenu();
            return ' ';
        }
        return letterToGuess;
    }
    /*
     * Defining menu actions.
     */
    /**
     * Defines the action that plays the game in easy level.
     */
    private static void playGameAny(String wordToGuess, String guessedWord){
        for(short i = 0; i < wordToGuess.length(); ++i){
            guessedLetters.put(wordToGuess.charAt(i), false);
        }
        do{
            System.out.print(REQUEST_LETTER);
            letterToGuess = readLetter(letterToGuess);

            guessedWord = Game.playGame(wordToGuess, letterToGuess, guessedLetters, guessedWord);
            System.out.printf(GUESSED_LETTERS, guessedWord);
            System.out.printf(KEEP_PLAYING_OPTION);
            keepPlaying = input.nextLine().charAt(0);
        }while(keepPlaying != '0');
        System.out.printf(END_OF_PROGRAM);
        menu.killMenu();
    }

    private static MenuActionPrototype playGameEasy = () -> {
        playGameAny(words[0][0], words[1][0]);
    };

    /**
     * Defines the action that plays the game in medium level.
     */
    private static MenuActionPrototype playGameMedium = () -> {
        playGameAny(words[0][1], words[1][1]);
    };

    /**
     * Defines the action that plays the game in hard level.
     */
    private static MenuActionPrototype playGameHard = () -> {
        playGameAny(words[0][2], words[1][2]);
    };
    /*
     * Adding the menu options and actions.
     */
    static {
        menu
                .addOption(EASY_LEVEL_OPTION, playGameEasy)
                .addOption(MEDIUM_LEVEL_OPTION, playGameMedium)
                .addOption(HARD_LEVEL_OPTION, playGameHard)
                .addExitOption();
    }

    /**
     * Showing the menu and executing the actions associated to each option.
     */
    public static void startGame() {
        menu.showMenu();
        do {
            menu.requestOption();
            int option = menu.readOption();
            menu.executeOption(option);
        } while (menu.isAlive());
    }
}
/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.reto5.ui;

import edu.axel.balam.mancera.miramontes.reto5.process.Game;

import java.util.HashMap;
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
    private static String REQUEST_LETTER = "Ingrese un caracter para determinar si existe dentro de la palabra: ";
    private static String GUESSED_LETTERS = "Con base a la letra escogida, la palabra adivinada es la siguiente manera: %s\n";
    private static String KEEP_PLAYING_OPTION = "¿Desea seguir jugando? Cualquier caracter) Sí. 0) No. ";
    private static String END_OF_PROGRAM = "Programa finalizado.";

    /*
     * Defining menu actions.
     */
    /**
     * Defines the action that plays the game in easy level.
     */
    private static MenuActionPrototype playGameEasy = () -> {
        String wordToGuess = words[0][0];
        String guessedWord = words[1][0];
        for(short i = 0; i < wordToGuess.length(); ++i){
            guessedLetters.put(wordToGuess.charAt(i), false);
        }
        do{
            System.out.print(REQUEST_LETTER);
            letterToGuess = input.nextLine().charAt(0);
            guessedWord = Game.playGame(words[0][0], letterToGuess, guessedLetters, guessedWord);
            System.out.printf(GUESSED_LETTERS, guessedWord);
            System.out.printf(KEEP_PLAYING_OPTION);
            keepPlaying = input.nextLine().charAt(0);
        }while(keepPlaying != '0');
        System.out.printf(END_OF_PROGRAM);
        menu.killMenu();
    };

    /**
     * Defines the action that plays the game in medium level.
     */
    private static MenuActionPrototype playGameMedium = () -> {
        String wordToGuess = words[0][1];
        String guessedWord = words[1][1];
        for(short i = 0; i < wordToGuess.length(); ++i){
            guessedLetters.put(wordToGuess.charAt(i), false);
        }
        do{
            System.out.print(REQUEST_LETTER);
            letterToGuess = input.nextLine().charAt(0);
            guessedWord = Game.playGame(words[0][1], letterToGuess, guessedLetters, guessedWord);
            System.out.printf(GUESSED_LETTERS, guessedWord);
            System.out.printf(KEEP_PLAYING_OPTION);
            keepPlaying = input.nextLine().charAt(0);
            input.nextLine();
        }while(keepPlaying != '0');
        System.out.printf(END_OF_PROGRAM);
        menu.killMenu();
    };

    /**
     * Defines the action that plays the game in hard level.
     */
    private static MenuActionPrototype playGameHard = () -> {
        String wordToGuess = words[0][2];
        String guessedWord = words[1][2];
        for(short i = 0; i < wordToGuess.length(); ++i){
            guessedLetters.put(wordToGuess.charAt(i), false);
        }
        do{
            System.out.print(REQUEST_LETTER);
            letterToGuess = input.nextLine().charAt(0);
            guessedWord = Game.playGame(words[0][2], letterToGuess, guessedLetters, guessedWord);
            System.out.printf(GUESSED_LETTERS, guessedWord);
            System.out.printf(KEEP_PLAYING_OPTION);
            keepPlaying = input.nextLine().charAt(0);
            input.nextLine();
        }while(keepPlaying != '0');
        System.out.printf(END_OF_PROGRAM);
        menu.killMenu();
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
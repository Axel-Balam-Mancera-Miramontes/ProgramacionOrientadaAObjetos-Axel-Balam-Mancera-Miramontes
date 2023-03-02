/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.reto6.process;

import java.util.Map;

/**
 * This class contains the methods to determine whether the selected letter is in the word,
 */
public class Game {

    /**
     * playGame checks whether the selected letter is in the word,
     * @param toGuessWord: word to guess.
     * @param letterToGuess: letter to check if exists within the word to guess.
     * @param guessedLetters: map containing the information about the guessing status of each of the word to guess' letters.
     * @param guessedWord: encoded word to shouw the user.
     * @return: decoded word to shouw the user.
     */
    public static String playGame(String toGuessWord, char letterToGuess, Map<Character, Boolean> guessedLetters, String guessedWord){
        char[] aux;
        if(guessedLetters.get(letterToGuess) != null){
            if(!guessedLetters.get(letterToGuess)){
                guessedLetters.put(letterToGuess, true);
                for(int i = 0; i < toGuessWord.length(); ++i){
                    if(toGuessWord.charAt(i) == letterToGuess){
                        aux = guessedWord.toCharArray();
                        aux[i] = letterToGuess;
                        guessedWord = new String(aux);
                    }
                }
            }
        }
        return guessedWord;
    }
}
/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.reto5.process;

import java.util.HashMap;
import java.util.Map;

/**
 * This class contains the methods to determine whether the selected letter is in the word,
 */
public class Game {
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
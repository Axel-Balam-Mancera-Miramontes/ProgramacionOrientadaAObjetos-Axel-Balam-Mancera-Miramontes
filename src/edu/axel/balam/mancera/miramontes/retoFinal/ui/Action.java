/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.retoFinal.ui;

import edu.axel.balam.mancera.miramontes.retoFinal.process.Magician;
import edu.axel.balam.mancera.miramontes.retoFinal.process.Player;

/**
 * An instance of the functional interface Action can be assigned the definition of a lambda function.
 */
@FunctionalInterface
public interface Action {
    /**
     * definedAction is the prototype of the method that will help initialize an instance of the Action class as a defined lambda function.
     */
    void definedAction(Player player, Magician magician);

}
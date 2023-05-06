/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.reto9.ejercicio2.ui;

/**
 * An instance of the functional interface Action can be assigned the definition of a lambda function.
 */
@FunctionalInterface
public interface MenuActionPrototype {
    /**
     * definedAction is the prototype of the method that will help initialize an instance of the Action class as a defined lambda function.
     */
    void definedAction();
}
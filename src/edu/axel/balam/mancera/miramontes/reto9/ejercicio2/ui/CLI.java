/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.reto9.ejercicio2.ui;

import edu.axel.balam.mancera.miramontes.reto6.process.Game;
import edu.axel.balam.mancera.miramontes.reto9.ejercicio2.process.Helper;

import java.util.*;

/**
 * CLI contains all the data tha is going to be processed by the Game class.
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {

    /*
     * Data used by process
     */

    /**
     * Creating the user menu.
     */
    /*
     * Defining an instance of the user menu.
     */
    private static Menu menu = new Menu();

    /*
     * Other texts that are going to be shown within the execution of a selected option.
     */
    private static String USER_ONLY_NOTIFICATION_OPTION = "Generar ayudantes.";
    private static String USER_ONLY_OUTPUT = "Los ayudantes generados son:\n";

    /*
     * Defining menu actions.
     */
    /**
     * Defines the action that generates the helpers.
     */

    private static void showHelperData(Helper helper){
        Object[] helperData = helper.getHelperData();
        System.out.println("Los datos del ayudante son:\n"
            + "Número de ojos: " + helperData[0] + "\n"
            + "Color de piel: " + helperData[1] + "\n"
            + "Altura: " + helperData[2] + "\n"
            + "Nivel de creación de objetos: " + helperData[3] + "\n"
            + "Nivel para arreglar cosas: " + helperData[4] + "\n"
            + "Nivel destructivo: " + helperData[5] + "\n");
    }
    private static MenuActionPrototype generateHelpers = () -> {
        Helper helpers[] = new Helper[5];
        Random random = new Random();
        byte i;

        for(i = 0; i < 5; ++i){
            helpers[i] = new Helper(
                (byte)(random.nextInt(2 - 1 + 1) + 1),
                (byte)(random.nextInt(2 - 1 + 1) + 1) == 0 ? "Amarilla" : "Morada",
                (byte)(random.nextInt(2 - 1 + 1) + 1) == 0 ? "Mediano" : "Alto",
                (byte)(random.nextInt(5 - 1 + 1) + 1),
                (byte)(random.nextInt(5 - 1 + 1) + 1),
                (byte)(random.nextInt(5 - 1 + 1) + 1)
            );
        }

        System.out.printf("%s", USER_ONLY_OUTPUT);
        for(i = 0; i < helpers.length; ++i){
            showHelperData(helpers[i]);
        }
    };

    /*
     * Adding the menu options and actions.
     */
    static {
        menu
          .addOption(USER_ONLY_NOTIFICATION_OPTION, generateHelpers)
          .addExitOption();
    }

    /**
     * Showing the menu and executing the actions associated to each option.
     */
    public static void showGeneratedHelpers() {
        menu.showMenu();
        do {
            menu.requestOption();
            int option = menu.readOption();
            menu.executeOption(option);
        } while (menu.isAlive());
    }
}
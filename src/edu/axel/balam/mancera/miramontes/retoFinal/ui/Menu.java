/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.retoFinal.ui;

import edu.axel.balam.mancera.miramontes.retoFinal.process.Magician;
import edu.axel.balam.mancera.miramontes.retoFinal.process.Player;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Menu provides a set of variables and members that outline a template of a user menu.
 */
public class Menu {
    Player player;
    Magician magician;

    /**
     * Texts that may be shown when interacting with the menu.
     */
    private String START_MENU;
    private String REQUEST_OPTION;
    private String NUMERIC_TYPE_ERROR;
    private String OUT_OF_RANGE_ERROR;
    private String ABANDON_GAME;

    /**
     * optionList stores the strings that correspond to the options shown to the user + an exit option.
     * actionList stores the functions associated to every option shown to the user but the exit option.
     */
    private ArrayList<String> optionList;
    private ArrayList<Action> actionList;

    /**
     * alive sets the state of availability of the menu to the user and helps determine whether the menu should keep shown or not.
     */
    private boolean alive;

    /**
     * Menu: sets the menu's attributes to their initial values.
     */
    public Menu(Player player, Magician magician){
        this.player = player;
        this.magician = magician;

        START_MENU = "Menú del jugador";
        REQUEST_OPTION = "¿Qué desea hacer el jugador? Digite el número correspondiente a la opción a elegir: ";
        NUMERIC_TYPE_ERROR = "El valor ingresado no posee un formato numérico. Intente de nuevo: ";
        OUT_OF_RANGE_ERROR = "Opción no disponible. Intente de nuevo: ";
        ABANDON_GAME = "Has abandonado el juego";

        optionList = new ArrayList<>();
        actionList = new ArrayList<>();

        alive = true;
    }

    /**
     * isAlive determines the state of availability of the menu to the user.
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * addOption a user menu given the options it should provide them and the actions associated to each of them.
     * @param option: a text containing one of the menu options.
     * @param action: the method that should be executed when selecting the option associated to it.
     * @return this: the current menu with its corresponding modifications.
     */
    public Menu addOption(String option, Action action) {
        optionList.add(option);
        actionList.add(action);
        return this;
    }

    /**
     * createMenu adds an exit method at the end of the menu.
     */
    public void addExitOption() {
        optionList.add("Abandonar juego.");
    }

    /**
     * cleanMenu removes all the options and actions associated to them from the menu.
     */
    public void clearMenu() {
        optionList.clear();
        actionList.clear();
    }

    /**
     * killMenu sets that the user menu should stop being shown to the user.
     */
    public void killMenu() {
        alive = false;
    }

    /**
     * showMenu displays the options within the menu
     */
    public void showMenu() {
        System.out.println(START_MENU);
        for (int i = 0; i < optionList.size(); i++) {
            System.out.println(i + 1 + ") " + optionList.get(i));
        }
    }

    public void requestOption(){
        System.out.print(REQUEST_OPTION);
    }

    /**
     * readOption reads the user's input and validates it was given in an appropriate format.
     * @return option: a number that represents the index of a specific option.
     */
    public int readOption() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                int option = input.nextInt();
                input.nextLine();
                if (option <= 0 || option > optionList.size()) {
                    System.out.print(OUT_OF_RANGE_ERROR);
                    continue;
                }
                return option;
            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.print(NUMERIC_TYPE_ERROR);
            }
        }
    }

    /**
     * selectAndRunOption executes the function associated to the option selected by the user
     * @param option: the number that represents the index of the option selected by the user.
     */
    public void executeOption(int option) {
        if (option == optionList.size()) {
            killMenu();
            System.out.println(ABANDON_GAME);
            return;
        }
        actionList.get(option - 1).definedAction(player, magician);
    }
}



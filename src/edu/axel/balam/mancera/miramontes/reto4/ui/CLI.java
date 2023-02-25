/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.reto4.ui;

import edu.axel.balam.mancera.miramontes.reto4.process.Game;

/**
 * CLI contains all the data tha is going to be processed by the Game class.
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {

    private final static String coffeeTypes[] = {"Chocolate", "Vainilla", "Fresa", "Oreo"};
    private final static String trimesters[] = {"Ene-Feb-Mar", "Abr-May-Jun", "Jul-Ago-Sep", "Oct-Nov-Dic"};
    /**
     * Table containing all the recorded sales.
     */
    private final static int salesTable[][] = {
            {111, 483, 471, 427},
            {192, 500, 355, 158},
            {289, 470, 474, 160},
            {425, 114, 161, 308}
    };

    /**
     * Creating the user menu.
     */
    /*
     * Defining an instance of the user menu.
     */
    private static Menu menu = new Menu();

    /*
     *  Menu options.
     * */
    private static String MOST_SALES_PER_FLAVOR_OPTION = "Obtener trimestre que más se vende por cada sabor de café frío que tiene en existencia";
    private static String MOST_SALES_OPTION = "Obtener trimestre que más producto vende en general, es decir, que, sin importar el sabor del chocolate, desea saber cuál trimestre del año vende más";

    /*
     * Other texts that are going to be shown within the execution of a selected option.
     */
    private static String MOST_SALES_PER_FLAVOR_OUTPUT = "El trimestre que vendió más cafés fríos de sabor %s fue %s.\n";
    private static String MOST_SALES_OUTPUT = "El trimestre que vendió más cafés fríos fue %s.\n";

    /*
     * Defining menu actions.
     * */
    /**
     * Defines the action that gets the trimester in which the given coffee flavor had the most sales.
     */
    private static MenuActionPrototype getMostSalesPerFlavor = () -> {
        for(int i = 0; i < salesTable.length; ++i){
            System.out.printf(MOST_SALES_PER_FLAVOR_OUTPUT, coffeeTypes[i], Game.getMostSalesPerFlavor(salesTable[i], trimesters));
        }
    };

    /**
     * Defines the action that gets the trimester which had the most total sales.
     */
    private static MenuActionPrototype getMostSales = () -> {
        System.out.printf(MOST_SALES_OUTPUT, Game.getMostSales(salesTable, trimesters));
    };

    /*
     * Adding the menu options and actions.
     */
    static {
        menu
                .addOption(MOST_SALES_PER_FLAVOR_OPTION, getMostSalesPerFlavor)
                .addOption(MOST_SALES_OPTION, getMostSales)
                .addExitOption();
    }

    /**
     * Showing the menu and executing the actions associated to each option.
     */
    public static void getStatistics() {
        menu.showMenu();
        do {
            menu.requestOption();
            int option = menu.readOption();
            menu.executeOption(option);
        } while (menu.isAlive());
    }
}
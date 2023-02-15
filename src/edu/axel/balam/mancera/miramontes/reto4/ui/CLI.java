package edu.axel.balam.mancera.miramontes.reto4.ui;

import edu.axel.balam.mancera.miramontes.reto4.process.Statistics;

import java.util.Scanner;

/**
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {
    /*
     * Creating the user menu
     */
    private static Menu menu = new Menu();

    /*
     *  Menu options
     * */
    private static String MOST_SALES_FOR_EACH_FLAVOR_OPTION = "Obtener trimestre que más se vende por cada sabor de café frío que tiene en existencia";
    private static String MOST_SALES = "Obtener trimestre que más producto vende en general, es decir, que, sin importar el sabor del chocolate, desea saber cuál trimestre del año vende más";

    /*
     * Menu actions
     * */
    private static MenuActionPrototype getMostSalesForFlavor = () -> {
        Statistics.getMostSalesForFlavor();
    };

    private static MenuActionPrototype getMostSales = () -> {
        Statistics.getMostSales();
    };

    /*
     * Adding the menu options and actions
     */
    static {
        menu
                .addOption(MOST_SALES_FOR_EACH_FLAVOR_OPTION, getMostSalesForFlavor)
                .addOption(MOST_SALES, getMostSales)
                .addExitOption();
    }

    /*
     * Execute menu
     */
    public static void startConversor() {
        menu.showMenu();
        do {
            menu.requestOption();
            int option = menu.readOption();
            menu.executeOption(option);
        } while (menu.isAlive());
    }
}
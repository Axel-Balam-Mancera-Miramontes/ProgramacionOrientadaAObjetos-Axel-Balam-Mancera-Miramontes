package edu.axel.balam.mancera.miramontes.CLITemplate.reto4.ui;

import edu.axel.balam.mancera.miramontes.CLITemplate.reto4.process.ConversorNumerico;

import java.util.Scanner;

/**
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {
    /*
     * Texts that may appear when interacting with the UI.
     * */
    private static String DECIMAL_REQUEST = "Introduce un número en base decimal: ";
    private static String BINARY_REQUEST = "Introduce un número en base Binaria: ";
    private static String OCTAL_REQUEST = "Introduce un número en base Octal: ";
    private static String HEX_REQUEST = "Introduce un número en base Hexadecimal: ";
    private static String CONVERSION_RESULT = "\n El resultado de la conversión es: %s >> %s \n\n ";

    /*
     * Creating the user menu
     */
    private static Menu menu = new Menu();

    /*
     *  Menu options
     * */
    private static String DECIMAL_BINARY_OPTION = "Convertir Decimal a Binario";
    private static String DECIMAL_OCTAL_OPTION = "Convertir Decimal a Octal";
    private static String DECIMAL_HEX_OPTION = "Convertir Decimal a Hexadecimal";
    private static String BINARY_DECIMAL_OPTION = "Convertir Binario a Decimal";
    private static String OCTAL_DECIMAL_OPTION = "Convertir Octal a Decimal";
    private static String HEX_DECIMAL_OPTION = "Convertir Hexadecimal a Decimal";

    /*
     * Menu actions
     * */
    private static MenuActionPrototype decimalABinarioMenuActionPrototype = () -> {
        Scanner input = new Scanner(System.in);
        String valorAConvertir = "";
        String valorResultado = "";
        System.out.print(DECIMAL_REQUEST);
        valorAConvertir = input.nextLine();
        valorResultado = ConversorNumerico.convertirDecimalaBinario(valorAConvertir);
        System.out.printf(CONVERSION_RESULT, valorAConvertir, valorResultado);
    };

    private static MenuActionPrototype decimalAOctalMenuActionPrototype = () -> {
        Scanner input = new Scanner(System.in);
        String valorAConvertir = "";
        String valorResultado = "";
        System.out.print(DECIMAL_REQUEST);
        valorAConvertir = input.nextLine();
        valorResultado = ConversorNumerico.convertirDecimalaOctal(valorAConvertir);
        System.out.printf(CONVERSION_RESULT, valorAConvertir, valorResultado);
    };

    private static MenuActionPrototype decimalAHexadecimalMenuActionPrototype = () -> {
        Scanner input = new Scanner(System.in);
        String valorAConvertir = "";
        String valorResultado = "";
        System.out.print(DECIMAL_REQUEST);
        valorAConvertir = input.nextLine();
        valorResultado = ConversorNumerico.convertirDecimalaHexadecimal(valorAConvertir);
        System.out.printf(CONVERSION_RESULT, valorAConvertir, valorResultado);
    };

    private static MenuActionPrototype binarioADecimalMenuActionPrototype = () -> {
        Scanner input = new Scanner(System.in);
        String valorAConvertir = "";
        String valorResultado = "";
        System.out.print(BINARY_REQUEST);
        valorAConvertir = input.nextLine();
        valorResultado = ConversorNumerico.convertirBinarioADecimal(valorAConvertir);
        System.out.printf(CONVERSION_RESULT, valorAConvertir, valorResultado);
    };

    private static MenuActionPrototype octalADecimalMenuActionPrototype = () -> {
        Scanner input = new Scanner(System.in);
        String valorAConvertir = "";
        String valorResultado = "";
        System.out.print(OCTAL_REQUEST);
        valorAConvertir = input.nextLine();
        valorResultado = ConversorNumerico.convertirOctalADecimal(valorAConvertir);
        System.out.printf(CONVERSION_RESULT, valorAConvertir, valorResultado);
    };

    private static MenuActionPrototype hexadecimalADecimalMenuActionPrototype = () -> {
        Scanner input = new Scanner(System.in);
        String valorAConvertir = "";
        String valorResultado = "";
        System.out.print(HEX_REQUEST);
        valorAConvertir = input.nextLine();
        valorResultado = ConversorNumerico.convertirHexadecimalDecimal(valorAConvertir);
        System.out.printf(CONVERSION_RESULT, valorAConvertir, valorResultado);
    };

    /*
     * Adding the menu options and actions
     */
    static {
        menu
                .addOption(DECIMAL_BINARY_OPTION, decimalABinarioMenuActionPrototype)
                .addOption(DECIMAL_OCTAL_OPTION, decimalAOctalMenuActionPrototype)
                .addOption(DECIMAL_HEX_OPTION, decimalAHexadecimalMenuActionPrototype)
                .addOption(BINARY_DECIMAL_OPTION, binarioADecimalMenuActionPrototype)
                .addOption(OCTAL_DECIMAL_OPTION, octalADecimalMenuActionPrototype)
                .addOption(HEX_DECIMAL_OPTION, hexadecimalADecimalMenuActionPrototype)
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
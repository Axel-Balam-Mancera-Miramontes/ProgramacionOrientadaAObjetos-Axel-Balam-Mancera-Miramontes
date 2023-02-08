package edu.axel.balam.mancera.miramontes.reto3.ui;

/**
 * @author Axel Balam Mancera Miramontes
 */

import edu.axel.balam.mancera.miramontes.reto3.process.Converter;
import java.util.Scanner;

/**
 * The Converter class contains the user command line interface
 */
public class CLI {

    /**
     * showCLI shows the user command line interface
     */
    public static void showUserInterface(){
        Scanner input = new Scanner(System.in);
        char option;
        String numToCnvrt;

        System.out.println("** Programa de conversiones **");
        System.out.println("¿Qué desea hacer?" +
                "\na) Convertir un número en base decimal a su representación en base binaria." +
                "\nb) Convertir un número en base decimal a su representación en base octal." +
                "\nc) Convertir un número en base decimal a su representación en base hexadecimal." +
                "\nd) Convertir un número en base binario a su representación en base decimal." +
                "\ne) Convertir un número en base octal a su representación en base decimal." +
                "\nf) Convertir un número en base hexadecimal a su representación en base ocatl.");

        do{
            System.out.println("Ingrese el tipo de conversión a realizar: ");
            option = input.nextLine().charAt(0);
            System.out.println("Ingrese el número a convertir");
            numToCnvrt = input.nextLine();

            switch(option){
                case 'a':
                    System.out.println(Converter.cnvrtDecToBinOctHex(numToCnvrt, (byte)2));
                    break;
                case 'b':
                    System.out.println(Converter.cnvrtDecToBinOctHex(numToCnvrt, (byte)8));
                    break;
                case 'c':
                    System.out.println(Converter.cnvrtDecToBinOctHex(numToCnvrt, (byte)16));
                    break;
                case 'd':
                    System.out.println(Converter.cnvrtBinOctHexToDec(numToCnvrt, (byte)2));
                    break;
                case 'e':
                    System.out.println(Converter.cnvrtBinOctHexToDec(numToCnvrt, (byte)8));
                    break;
                case 'f':
                    System.out.println(Converter.cnvrtBinOctHexToDec(numToCnvrt, (byte)16));
                    break;
            }
            System.out.println("¿Desea realizar otra conversión? " +
                    "\ns) Sí." +
                    "\nn) No.");
            option = input.nextLine().charAt(0);

        }while(option == 's');
    }
}

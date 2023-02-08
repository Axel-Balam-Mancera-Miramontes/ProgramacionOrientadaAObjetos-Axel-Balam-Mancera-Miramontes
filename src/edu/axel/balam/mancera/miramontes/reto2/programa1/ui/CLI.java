package edu.axel.balam.mancera.miramontes.reto2.programa1.ui;

import edu.axel.balam.mancera.miramontes.reto2.programa1.process.Triangle;

import java.util.Scanner;

public class CLI {
    /**
     * Method to read triangle's size
     */
    public static void showUserInterface(){
        Scanner input = new Scanner(System.in);
        short size;

        System.out.print("Ingrese el tamaño de la pirámide: ");
        size = input.nextShort();

        Triangle.printTriangle(size);
    }
}

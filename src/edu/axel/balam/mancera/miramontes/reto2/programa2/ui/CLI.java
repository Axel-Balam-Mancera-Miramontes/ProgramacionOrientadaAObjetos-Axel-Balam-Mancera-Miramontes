package edu.axel.balam.mancera.miramontes.reto2.programa2.ui;

import edu.axel.balam.mancera.miramontes.reto2.programa2.process.TicketMachine;

import java.util.Scanner;

public class CLI {
    /**
     * Method to read ticket type
     */
    public static void showUserInterface(){
        Scanner input = new Scanner(System.in);
        char ticketType, option;

        System.out.println("¿Qué tipo de boleto desea comprar?" +
                "\nN) Boleto para niño." +
                "\nA) Boleto para adulto." +
                "\nB) Boleto para adulto mayor" +
                "\nI) Boleto para adulto mayor con credencial INAPAM.");
        do{
            System.out.print("Ingrese el tipo de boleto: ");
            ticketType = input.nextLine().charAt(0);
            TicketMachine.showTicketPrice(ticketType);

            System.out.print("¿Desea comprar otro boleto? ");
            option = input.nextLine().charAt(0);
        }while(option == 's');

        System.out.println("¡Fin del programa!");
    }
}

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
        short nKids = 0, nAdults = 0, nElders = 0, getnEldersWCard = 0;

        System.out.println("¿Qué tipo de boleto desea comprar?" +
                "\nN) Boleto para niño: $70." +
                "\nA) Boleto para adulto: $100." +
                "\nB) Boleto para adulto mayor: $70" +
                "\nI) Boleto para adulto mayor con credencial INAPAM: %50.");
        do{
            System.out.print("Ingrese el tipo de boleto: ");
            ticketType = input.nextLine().charAt(0);
            switch(ticketType){
                case 'N':
                    ++nKids;
                    break;
                case 'A':
                    ++nAdults;
                    break;
                case 'B':
                    ++nElders;
                    break;
                case 'I':
                    ++getnEldersWCard;
                    break;
                default:
                    System.out.println("Tipo de boleto inválido.");
            }

            System.out.print("¿Desea comprar otro boleto? ");
            option = input.nextLine().charAt(0);
        }while(option == 's');

        System.out.println("Compraste:" +
                "\n" + nKids + "boletos para niño: " + nKids + "," +
                "\n" + nAdults + "boletos para adulto: " + nAdults + "," +
                "\n" + nElders + "boletos para adulto mayor: " + nElders + "," +
                "\n" + getnEldersWCard + "boletos para adulto mayor con credencial INAPAM: " + getnEldersWCard + "." +
                "\nEl costo toal por los boletos comprados es de : $" + TicketMachine.getTotal(nKids, nAdults, nElders, getnEldersWCard));
        System.out.println("¡Fin del programa!");
    }
}

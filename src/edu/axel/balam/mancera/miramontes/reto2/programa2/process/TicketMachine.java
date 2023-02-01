package edu.axel.balam.mancera.miramontes.reto2.programa2.process;

public class TicketMachine {
    /**
     * Method to print ticket price
     * @param ticketType: ticket type
     */
    public static void showTicketPrice(char ticketType){
        switch(ticketType){
            case 'N':
            case 'B':
                System.out.println("El costo por el boleto es $70");
                break;
            case 'A':
                System.out.println("El costo por el boleto es $100");
                break;
            case 'I':
                System.out.println("El costo por el boleto es $50");
                break;
            default:
                System.out.println("Tipo de boleto inválido.");
        }
    }
}




package edu.axel.balam.mancera.miramontes.reto2.programa2.process;

public class TicketMachine {
    /**
     * Constant variables for ticket prices
     */
    static final float KID_TICKET_PRICE = 70.0f, ADULT_TICKET_PRICE = 100.0f, ELDER_TICKET_PRICE = 70.0f, ELDER_TICKET_PRICE_WCARD = 50.0f;

    /**
     * Method to print ticket price
     * @param nKids: number of kid tickets
     * @param nAdults: number of adult tickets
     * @param nElders: number of elder tickets
     * @param nEldersWCard: number of elder woth INAPAM tickets
     */
    public static float getTotal(short nKids, short nAdults, short nElders, short nEldersWCard){
        return nKids * KID_TICKET_PRICE + nAdults * ADULT_TICKET_PRICE + nElders * ELDER_TICKET_PRICE + nEldersWCard * ELDER_TICKET_PRICE_WCARD;
    }

}




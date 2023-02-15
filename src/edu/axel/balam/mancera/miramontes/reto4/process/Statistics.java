package edu.axel.balam.mancera.miramontes.reto4.process;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class contains the methods to get the statistics of the recorded data.
 */
public class Statistics {
    /**
     * Table containing all the recorded sales
     */

    private final static String coffeeTypes[] = {"Chocolate", "Vainilla", "Fresa", "Oreo"};
    private final static String trimesters[] = {"Ene-Feb-Mar", "Abr-May-Jun", "Jul-Ago-Sep", "Oct-Nov-Dic"};
    private final static int salesTable[][] = {
        {111, 483, 471, 427},
        {192, 500, 355, 158},
        {289, 470, 474, 160},
        {425, 114, 161, 308}
    };

    public static void getMostSalesForFlavor(){
        int maxSale, i, j;
        String trimester;
        for(i = 0; i < salesTable.length; ++i){
            maxSale = 0;
            trimester = "";
            for(j = 0; j < salesTable[i].length; ++j){
                if(salesTable[i][j] > maxSale){
                    maxSale = salesTable[i][j];
                    trimester = trimesters[j];
                }
            }
            System.out.println("La mayor venta para " + coffeeTypes[i] + " fue en el trimestre " + trimester + "(" + maxSale + " ventas).");
        }
    }

    public static void getMostSales() {
        int maxSale = 0, aux;
        String trimester = "";
        for(int i = 0; i < salesTable[0].length; ++i){
            aux = 0;
            for(int j = 0; j < salesTable.length; ++j){
                aux += salesTable[j][i];
            }
            if(aux > maxSale){
                maxSale = aux;
                trimester = trimesters[i];
            }
        }
        System.out.println("La mayor venta fue en el trimestre " + trimester + " (" + maxSale + " ventas).");
    }
}
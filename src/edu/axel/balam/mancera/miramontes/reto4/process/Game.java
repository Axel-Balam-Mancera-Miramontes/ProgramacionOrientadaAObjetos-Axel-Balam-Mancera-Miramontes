/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.reto4.process;

/**
 * This class contains the methods to get the statistics of the recorded data.
 */
public class Game {
    /**
     * getMostSalesPerFlavor gets the trimester in which the given coffee flavor had the most sales.
     * @param salesTable: array containing the value of the sales for each trimester of the given coffee flavor.
     * @param trimesters: array containing the name of each trimester.
     * @return: the name of the trimester in which the given coffee flavor had the most sales.
     */
    public static String getMostSalesPerFlavor(int[] salesTable, String[] trimesters){
        int maxSaleFlavor = salesTable[0], maxSaleIndex = 0;

        for(int i = 1; i < salesTable.length; ++i) {
            if(salesTable[i] > maxSaleFlavor){
                maxSaleFlavor = salesTable[i];
                maxSaleIndex = i;
            }
        }

        return trimesters[maxSaleIndex];
    }

    /**
     * getMostSales gets the trimester which had the most total sales.
     * @param salesTable: table containing the value of the sales for each trimester of each coffee flavor.
     * @param trimesters: array containing the name of each trimester.
     * @return: the name of the trimester which had the most sales.
     */
    public static String getMostSales(int[][] salesTable, String[] trimesters) {
        int maxSale = salesTable[0][0];
        int auxSum;
        int maxSaleIndex = 0;

        for(int i = 0; i < salesTable[0].length; ++i){
            auxSum = 0;
            for(int j = 0; j < salesTable.length; ++j){
                auxSum += salesTable[j][i];
            }
            if(auxSum > maxSale){
                maxSale = auxSum;
                maxSaleIndex = i;
            }
        }

        return trimesters[maxSaleIndex];
    }
}
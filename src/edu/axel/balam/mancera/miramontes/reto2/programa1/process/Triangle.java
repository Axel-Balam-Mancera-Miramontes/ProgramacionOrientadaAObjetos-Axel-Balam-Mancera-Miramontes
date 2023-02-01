package edu.axel.balam.mancera.miramontes.reto2.programa1.process;

public class Triangle {
    /**
     * Method to print a triangle with a given size
     * @param nRows: size of triangle
     */
    public static void printTriangle(short nRows){
        for(short i = 1; i <= nRows; ++i){
            for(short j = 0; j < i; ++j)
                System.out.print("*");
            System.out.println();
        }
    }
}




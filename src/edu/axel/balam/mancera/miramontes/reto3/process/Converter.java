package edu.axel.balam.mancera.miramontes.reto3.process;

/**
 * @author Axel Balam Mancera Miramontes
 */

/**
 * The Converter class contains all solicited convertion methods
 */
public class Converter {

    /**
     * cnvrtDecToBinOctHex parses a decimal number to its representation in the binary/octal/hexadecimal system
     * @param decBaseNum: decimal number to parse
     * @param systemBase: numerical system base to convert the given decimal
     * @return the decimal's representation in the binary/octal/hexadecimal system
     */
    public static String cnvrtDecToBinOctHex(String decBaseNum, byte systemBase){
        String strOut = "";
        int num = Integer.parseInt(decBaseNum);
        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        while(num > 0){
            strOut = digits[num % systemBase] + strOut;
            num /= systemBase;
        }
        return strOut;
    }

    /**
     * cnvrtBinOctHexToDec parses a binary/octal/hexadecimal number to its representation in the decimal system
     * @param binOctHexBaseNum: bynary/octal/hexadecimal number to parse
     * @return the bynary/octal/hexadecimal's representation in the decimal system
     */
    public static String cnvrtBinOctHexToDec(String binOctHexBaseNum, byte systemBase){
        String strOut = "";
        int num = 0;

        for(short i = 0; i < binOctHexBaseNum.length(); ++i){
            System.out.println("binOctHexBaseNum.charAt(i) = " + binOctHexBaseNum.charAt(i));
            num += (int)Math.pow(systemBase, i) * Character.getNumericValue(binOctHexBaseNum.charAt(binOctHexBaseNum.length() - i - 1));
        }

        return Integer.toString(num);
    }

}
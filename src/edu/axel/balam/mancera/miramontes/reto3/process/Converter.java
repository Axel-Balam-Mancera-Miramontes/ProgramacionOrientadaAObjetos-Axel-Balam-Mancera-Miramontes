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
        return Integer.toString(Integer.parseInt(decBaseNum), systemBase);
    }

    /**
     * cnvrtBinOctHexToDec parses a binary/octal/hexadecimal number to its representation in the decimal system
     * @param binOctHexBaseNum: bynary/octal/hexadecimal number to parse
     * @return the bynary/octal/hexadecimal's representation in the decimal system
     */
    public static String cnvrtBinOctHexToDec(String binOctHexBaseNum, byte systemBase){
        return Integer.toString(Integer.parseInt(binOctHexBaseNum, systemBase));
    }

}
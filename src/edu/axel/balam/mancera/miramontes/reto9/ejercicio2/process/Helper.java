package edu.axel.balam.mancera.miramontes.reto9.ejercicio2.process;

import java.util.ArrayList;

/**
 * Helper defines the property of a ball.
 */
public class Helper {
    byte numOfEyes;
    String skinColor;
    String height;
    byte lvlObjCreation;
    byte lvlFixStuff;
    byte lvlDestructive;

    /**
     * The following Helper constructor sets the values
     */
    public Helper(byte numOfEyes) {
        setNumOfEyes(numOfEyes);
    }

    public Helper(byte numOfEyes, String skinColor) {
        setNumOfEyes(numOfEyes);
        setSkinColor(skinColor);
    }

    public Helper(byte numOfEyes, String skinColor, String height) {
        setNumOfEyes(numOfEyes);
        setSkinColor(skinColor);
        setHeight(height);
    }

    public Helper(byte numOfEyes, String skinColor, String height, byte lvlObj) {
        setNumOfEyes(numOfEyes);
        setSkinColor(skinColor);
        setHeight(height);
        setLvlObjCreation(lvlObj);
    }

    public Helper(byte numOfEyes, String skinColor, String height, byte lvlObj, byte lvlFixStuff) {
        setNumOfEyes(numOfEyes);
        setSkinColor(skinColor);
        setHeight(height);
        setLvlObjCreation(lvlObj);
        setLvlFixStuff(lvlFixStuff);
    }

    public Helper(byte numOfEyes, String skinColor, String height, byte lvlObj, byte lvlFixStuff, byte lvlDestructive) {
        setNumOfEyes(numOfEyes);
        setSkinColor(skinColor);
        setHeight(height);
        setLvlObjCreation(lvlObj);
        setLvlFixStuff(lvlFixStuff);
        setLvlDestructive(lvlDestructive);
    }

    public void setNumOfEyes(byte numOfEyes) {
        this.numOfEyes = numOfEyes;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setLvlObjCreation(byte lvlObj) {
        this.lvlObjCreation = lvlObj;
    }

    public void setLvlFixStuff(byte lvlFixStuff) {
        this.lvlFixStuff = lvlFixStuff;
    }

    public void setLvlDestructive(byte lvlDestructive) {
        this.lvlDestructive = lvlDestructive;
    }

    public Object[] getHelperData(){
        ArrayList<Object> helperData = new ArrayList<>();
        helperData.add(numOfEyes);
        helperData.add(skinColor);
        helperData.add(height);
        helperData.add(lvlObjCreation);
        helperData.add(lvlFixStuff);
        helperData.add(lvlDestructive);

        return helperData.toArray();
    }
}

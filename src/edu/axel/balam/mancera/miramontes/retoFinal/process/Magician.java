package edu.axel.balam.mancera.miramontes.retoFinal.process;

/**
 * Magician class contains all the actions that the Magician can perform within the game.
 */
public class Magician {
    private int PP;
    private int nCapturedFairies;

    /**
     * Texts that may be shown when executing the Magician's methods.
     */
    private String CAPTURE_FAIRY_TEXT;
    private String INCREASE_MAGICIANS_PP;
    private String DECREASE_PLAYERS_HP;
    private String INVOKE_OGRE_TEXT;

    /**
     * Magician: sets the Magician's attributes to their initial values.
     */
    public Magician() {
        setPP(5);
        setNCapturedFairies(0);
        CAPTURE_FAIRY_TEXT = "¡El mago capturado un hada!\n";
        INCREASE_MAGICIANS_PP = "El nivel de PP del mago ha incrementado en 1 unidad.\n";
        DECREASE_PLAYERS_HP = "El nivel de HP del jugador ha dismunuído en 1 unidad\n";
        INVOKE_OGRE_TEXT = "¡El ogro que protege al mago ha golpeado al jugador!\n";
    }

    /**
     * increasePP: increases the value of the Magician's HP.
     * @param extraPP: represents the value of PP points the Magician's PP will be increased by.
     */
    public void increasePPBy(int extraPP){
        setPP(getPP() + extraPP);
    }

    /**
     * decreasePP: decreases the value of the Magician's HP.
     * @param withdrawPP: represents the value of PP points the Magician's PP will be decreased by.
     */
    public void decreasePPBy(int withdrawPP){
        setPP(getPP() - withdrawPP);
    }

    /**
     * increaseNCapturedFairies: increases the number of fairies the Magician has captured.
     * @param extraFairies): represents the number of fairies the Magician's number of captured fairies will be increased by.
     */
    public void increaseNCapturedFairiesBy(int extraFairies){
        setNCapturedFairies(getNCapturedFairies() + extraFairies);
    }

    /**
     * captureFairy: the Magician executes this method in order to capture a fairy and therefore, increase the Magician's power.
     *  By every 10 fairies the Magician captures, its power will increase by 1 unit.
     */
    public void captureFairy(){
        System.out.print(CAPTURE_FAIRY_TEXT);

        increaseNCapturedFairiesBy(1);
        if(getNCapturedFairies() % 10 == 0){
            System.out.print(INCREASE_MAGICIANS_PP);
            this.increasePPBy(1);
        }
    }

    public void invokeOgre(Player player){
        System.out.print(INVOKE_OGRE_TEXT);
        System.out.print(DECREASE_PLAYERS_HP);
        player.decreaseHPBy(1);
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PPValue){
        PP = PPValue;
    }

    public int getNCapturedFairies(){
        return nCapturedFairies;
    }

    public void setNCapturedFairies(int nCapturedFairiesValue){
        nCapturedFairies = nCapturedFairiesValue;
    }
}

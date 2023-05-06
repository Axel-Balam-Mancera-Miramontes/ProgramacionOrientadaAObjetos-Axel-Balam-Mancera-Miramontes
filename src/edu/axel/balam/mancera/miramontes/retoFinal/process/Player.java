package edu.axel.balam.mancera.miramontes.retoFinal.process;

/**
 * Player class contains all the actions that the Player can perform within the game.
 */
public class Player {
    private int HP;
    private int nRescuedFairies;

    /**
     * Texts that may be shown when executing the Player's methods.
     */
    private String BUILD_HOUSE_FOR_FAIRY_TEXT;
    private String DECREASE_MAGICIANS_PP;
    private String INCREASE_PLAYERS_HP;

    /**
     * Player: sets the Player's attributes to their initial values.
     */
    public Player() {
        setHP(5);
        setNRescuedFairies(0);
        BUILD_HOUSE_FOR_FAIRY_TEXT = "¡El jugador ha rescatado un hada!\n";
        DECREASE_MAGICIANS_PP = "El nivel de PP del mago ha dismunuído en 1 unidad\n";
        INCREASE_PLAYERS_HP = "El nivel de HP del jugador ha incrementado en 1 unidad.\n";
    }

    /**
     * increaseHP: increases the value of the Player's HP.
     * @param extraHP: represents the value of HP points the Player's HP will be increased by.
     */
    public void increaseHPBy(int extraHP){
        setHP(getHP() + extraHP);
    }

    /**
     * decreaseHP: decreases the value of the Player's HP.
     * @param withdrawHP: represents the value of HP points the Player's HP will be decreased by.
     */
    public void decreaseHPBy(int withdrawHP){
        setHP(getHP() - withdrawHP);
    }

    /**
     * increaseNRescuedFairies: increases the number of fairies the Player has rescued.
     * @param extraFairies): represents the number of fairies the Player's number of rescued fairies will be increased by.
     */
    public void increaseNRescuedFairiesBy(int extraFairies){
        setNRescuedFairies(getNRescuedFairies() + extraFairies);
    }

    /**
     * buildHouseForFairy: the Player executes this method in order to rescue a fairy, make it live in it
     * and therefore, decrease the Magician's power.
     *  By every 10 fairies the Player rescues, the magician's power will decrease by 1 unit.
     */
    public void buildHouseForFairy(Magician magician){
        System.out.print(BUILD_HOUSE_FOR_FAIRY_TEXT);

        increaseNRescuedFairiesBy( 1);
        if(nRescuedFairies % 10 == 0){
            magician.decreasePPBy(1);
            System.out.print(DECREASE_MAGICIANS_PP);
            this.increaseHPBy(1);
            System.out.print(INCREASE_PLAYERS_HP);
        }
    }

    public int getHP(){
        return HP;
    }

    public void setHP(int HPValue){
        HP = HPValue;
    }

    public int getNRescuedFairies(){
        return nRescuedFairies;
    }

    public void setNRescuedFairies(int nRescuedFairiesValue){
        nRescuedFairies = nRescuedFairiesValue;
    }
}

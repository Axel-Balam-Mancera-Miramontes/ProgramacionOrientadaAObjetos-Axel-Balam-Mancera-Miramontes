/**
 * @author Axel Balam Mancera Miramontes
 */

package edu.axel.balam.mancera.miramontes.retoFinal.ui;

import edu.axel.balam.mancera.miramontes.retoFinal.process.Magician;
import edu.axel.balam.mancera.miramontes.retoFinal.process.Player;
import java.util.Random;

/**
 * CLI contains all the data tha is going to be processed by the Game class.
 * CLI defines the details of the user menu and executes it.
 */
public class CLI {
    /**
     * Texts that will bw shown in the execution of the game
     */
    private static String GAME_OVER = "¡Juego terminado!\n";
    private static String STATS = "Estatus de %s:" +
            "\n* %s: %d." +
            "\n* %s: %d." +
            "\n";
    private static String WINNER_STATS = "¡%s ha vencido!\n";

    /**
     * Creating the user menu.
     */
    private static Player player = new Player();
    private static Magician magician = new Magician();
    private static Menu menu = new Menu(player, magician);

    /**
     * Texts that will be shown in the execution of the selected option.
     */
    private static String BUILD_HOUSE_FOR_FAIRY = "Construir una casa para rescatar un hada.";

    /**
     * Actions tha will be shown in the menu in order for them to be performed.
     */

    private static Action buildHouseForFairy = (player, magician) -> {
        player.buildHouseForFairy(magician);
    };

    /**
     * Adding the menu options and actions.
     */
    static {
        menu
          .addOption(BUILD_HOUSE_FOR_FAIRY, buildHouseForFairy)
          .addExitOption();
    }

    /**
     * Showing the menu and executing the actions associated to each option.
     */
    public static void play() {
        do {
            menu.showMenu();

            /**
             * Execute the Player's action.
             */
            menu.requestOption();
            int option = menu.readOption();
            menu.executeOption(option);

            if(menu.isAlive()){
                /**
                 * Execute the Magician's action.
                 */
                switch(new Random().nextInt(2)){
                    case 0:
                        magician.captureFairy();
                        break;
                    case 1:
                        magician.invokeOgre(player);
                        break;
                }

                /**
                 * Show the Player's and Magician's status.
                 */
                System.out.printf(STATS, player.getClass().getSimpleName(),
                        player.getClass().getDeclaredFields()[0].getName(),
                        player.getHP(),
                        player.getClass().getDeclaredFields()[1].getName(),
                        player.getNRescuedFairies());
                System.out.printf(STATS, magician.getClass().getSimpleName(),
                        magician.getClass().getDeclaredFields()[0].getName(),
                        magician.getPP(),
                        magician.getClass().getDeclaredFields()[1].getName(),
                        magician.getNCapturedFairies());
                System.out.println();
            }
        } while (menu.isAlive() && player.getHP() > 0 && magician.getPP() > 0);

        System.out.printf(GAME_OVER);

        if(menu.isAlive()){
            System.out.printf(WINNER_STATS, (player.getHP() > 0 ? player.getClass().getSimpleName() : magician.getClass().getSimpleName()));
        }
    }
}
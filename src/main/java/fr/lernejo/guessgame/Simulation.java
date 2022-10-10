package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private Player player = new HumanPlayer();  //TODO add variable type
    private long numberToGuess; //TODO add variable type
    private long iteration = 0;

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me

        iteration++;
        long playerNumber = player.askNextGuess();

        if(playerNumber == numberToGuess){
            return true;
        }
        else{
            player.respond(playerNumber>numberToGuess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long maxIteration) {
        //TODO implement me
        long time1 = System.currentTimeMillis();

        while (!this.nextRound() && iteration < maxIteration) {
            this.nextRound();
        }

        long time2 = System.currentTimeMillis();
        long totalTime = time2 - time1;
        DateFormat format = new SimpleDateFormat("mm:ss.SSS");
        Date result = new Date(totalTime);

        if ( iteration < maxIteration ) {
            logger.log("-- Bravo --");
            logger.log("-- Nombre d'essaie effectué : " + iteration + " --");
            logger.log("-- Le nombre à trouver était : " +  numberToGuess + " --");
            logger.log("Temps : " + format.format(result));
        }
        else {
            logger.log("-- Game Over --");
            logger.log("-- Nombre d'essaie effectué : " + iteration + ", sur " + maxIteration + " autorisé --");
            logger.log("-- Le nombre à trouver était : " +  numberToGuess + " --");
        }
    }
}

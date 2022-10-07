package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private Player player = new HumanPlayer();  //TODO add variable type
    private long numberToGuess; //TODO add variable type

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

        System.out.println("Entré un nombre");
        long playerNumber = player.askNextGuess();

        if(playerNumber == numberToGuess){
            return true;
        }
        else{
            player.respond(playerNumber>numberToGuess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        while (this.nextRound() == false) {
            this.nextRound();
        }
        logger.log("-- Bravo --");
    }
}

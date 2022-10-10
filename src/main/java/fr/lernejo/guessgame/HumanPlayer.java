package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        System.out.println("Entré un nombre");
        Scanner scan = new Scanner(System.in);
        return scan.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("Essayer plus petit \n");
        }
        else {
            logger.log("Essayer plus grand \n");
        }
    }
}

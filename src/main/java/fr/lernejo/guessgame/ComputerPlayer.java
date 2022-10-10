package fr.lernejo.guessgame;

import fr.lernejo.logger.ConsoleLogger;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class ComputerPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("computer");

    private long computerNumber;
    private long bornMin = Long.MIN_VALUE;
    private long bornMax = Long.MAX_VALUE;

    @Override
    public long askNextGuess() {
        return computerNumber;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            //Essayer plus petit
            bornMax = computerNumber;
            computerNumber = (bornMin + bornMax)/2;
        }
        else {
            //Essayer plus grand
            bornMin = computerNumber;
            computerNumber = (bornMin + bornMax)/2;
        }
    }
}

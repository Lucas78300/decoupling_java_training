package fr.lernejo;

import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Player;
import fr.lernejo.guessgame.Simulation;
import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {

        //Instanciation des classe HumanPlayer et Simulation
        Player player = new HumanPlayer();
        Simulation simulation = new Simulation(player);

        //Génération d'un nombre aléatoire 'randomNumber'
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);

        //Lancement de la simulation
        simulation.initialize(randomNumber); //Envoi du nombre aléatoire
        simulation.loopUntilPlayerSucceed(); //Boucle de jeu
    }
}

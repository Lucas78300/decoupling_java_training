package fr.lernejo;

import fr.lernejo.guessgame.ComputerPlayer;
import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Player;
import fr.lernejo.guessgame.Simulation;
import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("# Bienvenue au jeux du -- Trouver l'âge du capitaine -- ");
            System.out.println("Lancer avec l'argument '-intercative' afin de jouer vous-même");
            System.out.println("Lancer avec l'argument '-auto' suivi d'un nombre afin de le faire trouver par l'ordinateur");
        }
        else if (args[0].equals("-auto")) {

            if (args[1].matches("[+-]?\\d*(\\.\\d+)?")){

                //Instanciation des classe ComputerPlayer et Simulation
                Player computer = new ComputerPlayer();
                Simulation simulation = new Simulation(computer);

                //Lancement de la simulation
                simulation.initialize(Long.parseLong(args[1]));
                simulation.loopUntilPlayerSucceed(1000); //Boucle de jeu
            }
            else {
                System.out.println("Veuillez entrée une valeur numérique après '-auto'");
            }
        }
        else if (args[0].equals("-interactive")) {
            //Instanciation des classe HumanPlayer et Simulation
            Player player = new HumanPlayer();
            Simulation simulation = new Simulation(player);

            //Génération d'un nombre aléatoire 'randomNumber'
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);

            //Lancement de la simulation
            simulation.initialize(randomNumber); //Envoi du nombre aléatoire
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE); //Boucle de jeu
        }
    }
}

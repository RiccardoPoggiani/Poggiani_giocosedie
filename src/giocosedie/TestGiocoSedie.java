package giocosedie;

import java.util.logging.Logger;
import java.util.Scanner;

/**
 * TestGiocoSedie è la classe principale che avvia il gioco delle sedie.
 * Crea un array di posti e di partecipanti, poi avvia i thread per
 * gestire il gioco.
 * 
 * Il gioco simula il classico "gioco delle sedie", dove ci sono più
 * partecipanti che posti e i partecipanti cercano di sedersi in modo
 * concorrente.
 * 
 * @autor Riccardo Poggiani
 */

public class TestGiocoSedie {
    // Logger per registrare le informazioni di esecuzione
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");

    // Metodo principale per avviare l'applicazione
    public static void main(String[] args) {

        // Input del numero di partecipanti con Scanner
        Scanner input = new Scanner(System.in);
        System.out.println("Indica il numero di partecipanti al gioco delle sedie: ");
        int numsedie = input.nextInt();

        // Crea un array di oggetti Posto, ciascuno rappresentante una sedia
        Posto sedie[] = new Posto[numsedie];

        // Creazione delle sedie che verrano occupate concorrentemente
        for (int k = 0; k < sedie.length; k++) {
            sedie[k] = new Posto();
        }

        // Crea e avvia il thread Display per mostrare lo stato delle sedie
        Display display = new Display(sedie);
        logger.info("Sto facendo partire il Display.\n");
        display.start();

        // Crea e avvia un array di thread Partecipante
        Partecipante array[] = new Partecipante[numsedie + 1];
        for (int i = 0; i < numsedie + 1; i++) {
            array[i] = new Partecipante(sedie);
            logger.info(
                    "Sto facendo partire il thread id: " + array[i].getId() + " name: " + array[i].getName() + "\n");
            array[i].start();
        }
    }
}
package giocosedie;

import java.util.logging.Logger;

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
    // Numero di sedie disponibili nel gioco
    private final static int NUMSEDIE = 15;
    // Logger per registrare le informazioni di esecuzione
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");

    /**
     * Metodo principale per avviare l'applicazione.
     * 
     * @param args Argomenti della riga di comando
     */
    public static void main(String[] args) {

        // Crea un array di oggetti Posto, ciascuno rappresentante una sedia
        Posto sedie[] = new Posto[NUMSEDIE];

        for (int k = 0; k < sedie.length; k++) {
            sedie[k] = new Posto();
        }

        // Crea e avvia il thread Display per mostrare lo stato delle sedie
        Display display = new Display(sedie);
        logger.info("Sto facendo partire il Display.\n");
        display.start();

        // Crea e avvia un array di thread Partecipante
        Partecipante array[] = new Partecipante[NUMSEDIE + 1];
        for (int i = 0; i < NUMSEDIE + 1; i++) {
            array[i] = new Partecipante(sedie);
            logger.info(
                    "Sto facendo partire il thread id: " + array[i].getId() + " name: " + array[i].getName() + "\n");
            array[i].start();
        }
    }
}
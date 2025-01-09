package giocosedie;

/**
 * La classe Posto rappresenta una sedia nel gioco.
 * 
 * Ogni sedia può essere occupata o libera. I metodi sono sincronizzati per
 * garantire l'accesso corretto in un ambiente multithreading.
 */

class Posto {
    // Stato della sedia, inizialmente libera
    private boolean occupato;

    /**
     * Costruttore della classe Posto. Imposta la sedia come libera.
     */
    public Posto() {
        occupato = false;
    }

    /**
     * Verifica se la sedia è libera.
     * 
     * @return true se la sedia è libera, false altrimenti.
     */
    public synchronized boolean libero() {
        return (!occupato);
    }

    /**
     * Occupa la sedia se è libera.
     * 
     * @return true se l'occupazione ha successo, false altrimenti.
     */
    public synchronized boolean occupa() {
        if (occupato)
            return false;
        else
            return occupato = true;
    }
}
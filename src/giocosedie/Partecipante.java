package giocosedie;

/**
 * La classe Partecipante rappresenta un partecipante al gioco delle sedie.
 * 
 * Ogni partecipante è un thread che cerca di occupare una sedia.
 */

class Partecipante extends Thread {
    // Array di sedie disponibili nel gioco
    Posto sedie[];

    /**
     * Costruttore della classe Partecipante. 
     * 
     * @param sedie Array di sedie che il partecipante tenterà di occupare.
     */
    public Partecipante(Posto sedie[]) {
        this.sedie = sedie;
    }

    /**
     * Metodo run eseguito quando il thread viene avviato.
     * 
     * Il partecipante attende un tempo casuale, quindi tenta di occupare una
     * sedia. Se riesce, si siede; altrimenti, segnala di aver perso.
     */
    public void run() {
        try {
            // Attesa di un tempo casuale prima di cercare una sedia
            sleep((int) (Math.random() * 1000));

            for (int i = 0; i < sedie.length; i++) {
                if (sedie[i].occupa()) {
                    System.out.println("Sono il Thread " + this.getName() + ". Sono riuscito a sedermi sul posto " + i);
                    return;
                }
            }
            // Se nessuna sedia è disponibile
            System.out.println("Sono il Thread " + this.getName() + ". Ho perso :((((");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

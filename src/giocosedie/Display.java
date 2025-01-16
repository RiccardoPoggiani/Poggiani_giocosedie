package giocosedie;

/**
 * La classe Display mostra lo stato delle sedie in tempo reale.
 * 
 * Ogni sedia è rappresentata da '0' se è libera e da '*' se è occupata.
 */

class Display extends Thread {
    // Array di sedie che vengono monitorate
    private Posto sedie[];
    // Flag per determinare quando terminare il gioco
    private boolean endgame;

    /**
     * Costruttore della classe Display.
     * 
     * @param sedie Array di sedie da monitorare.
     */
    public Display(Posto sedie[]) {
        this.sedie = new Posto[sedie.length];
        for (int s = 0; s < sedie.length; s++) {
            this.sedie[s] = sedie[s];
        }
    }

    /**
     * Metodo run eseguito quando il thread viene avviato.
     * 
     * Aggiorna continuamente lo stato delle sedie finché tutte le sedie non
     * sono occupate.
     */
    public void run() {
        try {
            while (!endgame) {
                int count = 0;
                // Attesa di un tempo casuale prima di aggiornare lo stato
                sleep((int) (Math.random() * 250));

                for (int i = 0; i < sedie.length; i++) {
                    if (sedie[i].libero())
                        System.out.print("0");
                    else {
                        count++;
                        System.out.print("*");
                    }
                }
                System.out.println();
                // Termina il ciclo se tutte le sedie sono occupate
                endgame = (count == sedie.length);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

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

            // Creazione oggetto Scrittore con cui si scrive il file Risultati.txt
            Scrittore scrittore = new Scrittore("Risultato.txt");

            // Se vi sono sedie disponibili, il partecipante (concorrentemente agli altri)
            // si siede
            for (int i = 0; i < sedie.length; i++) {
                if (sedie[i].occupa()) {
                    String vinto = "Sono il Partecipante " + this.getName() + ". Sono riuscito a sedermi sul posto " + i
                            + "\n";
                    System.out.println(vinto);
                    scrittore.scrivi(vinto);
                    return;
                }
            }
            // Se nessuna sedia è disponibile il partcipante perde
            String perso = "Sono il Partecipante " + this.getName() + ". Ho perso :((((";
            System.out.println(perso);
            scrittore.scrivi(perso);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

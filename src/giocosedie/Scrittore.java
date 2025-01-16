package giocosedie;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MC
 * @version 12/01/23
 */

public class Scrittore {

    String nomeFile;

    public Scrittore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi(String str) {
        BufferedWriter br = null;

        try {
            // 1) apro il file
            br = new BufferedWriter(new FileWriter(nomeFile, true));
            // 2) scrivo nel buffer
            br.write(str);
            // 3) svuoto il buffer e salvo nel file i dati
            br.flush();
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (br != null)
                try {
                    // 4)chiudo lo stream in uscita
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
                }

        }
    }
}

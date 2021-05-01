/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettotecno;

import java.util.Vector;

/**
 *
 * @author user
 */
public class ThreadDownload extends Thread {

    private String NomeFIle, percorso;
    private boolean regione;

    public ThreadDownload(String NomeFIle, String percorso, boolean regione) {
        this.NomeFIle = NomeFIle;
        this.percorso = percorso;
        this.regione = regione;
    }

    @Override
    public void run() {
        if (regione) {
            Gestore.Istance().AggiungiFile(NomeFIle,gestioneFile.DownloadCSV(percorso) );
        } else {
            GestoreNazione.Instance().AggiungiFile(NomeFIle, gestioneFile.DownloadCSV(percorso));
        }
    }
}

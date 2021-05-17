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
    private int regione;

    public ThreadDownload(String NomeFIle, String percorso, int regione) {
        this.NomeFIle = NomeFIle;
        this.percorso = percorso;
        this.regione = regione;
    }

    @Override
    public void run() {
        if (regione == 0) {
            Gestore.Istance().AggiungiFile(NomeFIle,gestioneFile.DownloadCSV(percorso) );
        } else if(regione == 1){
            GestoreNazione.Instance().AggiungiFile(NomeFIle, gestioneFile.DownloadCSV(percorso));
        }
        else
        {
            GestoreProvincia.Instance().AggiungiFile(NomeFIle, gestioneFile.DownloadCSV(percorso));
        }
    }
}

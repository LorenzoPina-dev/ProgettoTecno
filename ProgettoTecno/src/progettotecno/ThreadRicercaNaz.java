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
public class ThreadRicercaNaz extends Thread{ //struttura simile a ThreadRicerca ma fatto per una gestione più efficiente e meglio organizzata 
     private String FileRicerca, AttributoRicerca;
    private int indice;

    public ThreadRicercaNaz(String FileRicerca, String AttributoRicerca,int indice) {
        this.FileRicerca = FileRicerca;
        this.AttributoRicerca = AttributoRicerca;
        this.indice=indice;
    }

    public void run() {
        Vector<String> righe = GestoreNazione.Instance().getFile(FileRicerca);
        String[] campi = righe.get(0).split(";");
        int Att = -1;
        for (int i = 0; i < campi.length; i++) {
            if (campi[i].equals(AttributoRicerca)) {
                Att = i;
                break;
            }
        }
        if (Att == -1) {
            System.out.println("Attributo: " + AttributoRicerca + " non è stato trovato nel file: " + FileRicerca);
            return;
        }
        for (int i=1;i<righe.size();i++) {
            String[] attributi = righe.get(i).split(";");
           if( attributi[Att]==null)
                System.out.println("il campo " + AttributoRicerca + " alla riga " + i + " è null");
            GestoreNazione.Instance().setDato(indice, attributi[Att]);
        }
    }
}

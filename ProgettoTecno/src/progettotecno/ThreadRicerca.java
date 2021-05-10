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
public class ThreadRicerca extends Thread {

    private String FileRicerca, AttributoRicerca;
    private int indice;

    public ThreadRicerca(String FileRicerca, String AttributoRicerca, int indice) {
        this.FileRicerca = FileRicerca;
        this.AttributoRicerca = AttributoRicerca;
        this.indice = indice;
    }

    public void run() {
        Vector<String> righe = Gestore.Istance().getFile(FileRicerca);
        String[] campi = righe.get(0).split(";");
        int Att = -1, Regione = -1;
        boolean trovato1=false,trovato2=false;
        int i = 0;
        while (campi.length >= i && (!trovato1||!trovato2)) {
            if (campi[i].equals(AttributoRicerca)) {
                Att = i;
                trovato1=true;
            }
            if (campi[i].equals("denominazione_regione") || campi[i].equals("nome_area")) {
                Regione = i;
                trovato2=true;
            }
            i++;
        }
        if (!trovato1) {
            System.out.println("Attributo: " + AttributoRicerca + " non è stato trovato nel file: " + FileRicerca);
            return;
        }
        if (!trovato2) {
            System.out.println("La regione non è stata trovata nel file: " + FileRicerca + " si consiglia di aggiungere il nome del campo nell'if");
            return;
        }
        for (i = 1; i < righe.size(); i++) {
            String[] attributi = righe.get(i).split(";");
            if (attributi[Att] == null) {
                System.out.println("il campo " + AttributoRicerca + " alla riga " + i + " è null");
            } else {
                Gestore.Istance().settaValore(attributi[Regione], indice, attributi[Att]);
            }
        }
    }
}

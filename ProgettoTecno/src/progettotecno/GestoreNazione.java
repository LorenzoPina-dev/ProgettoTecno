/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettotecno;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author user
 */
public class GestoreNazione {// struttura simile a Gestore ma diviso per gestire meglio la creazione e la gestione dei file nazionali

    private static GestoreNazione instance = null;
    private Map<String, Vector<String>> files;
    private Object[] dati;
    private Vector<String> AttRicerca;

    private GestoreNazione() {
        files = new HashMap<String, Vector<String>>();
    }

    public static GestoreNazione Instance() {
        if (instance == null) {
            instance = new GestoreNazione();
        }
        return instance;
    }

    public Vector<String> getAttRicerca() {
        return AttRicerca;
    }

    public void setAttRicerca(Vector<String> AttRicerca) {
        this.AttRicerca = AttRicerca;
        dati = new Object[AttRicerca.size()];
    }

    public void setDato(int index, Object val) {
        dati[index] = val;
    }
    public  Vector<String> getAllAtt(){
        Vector<String> ris= new Vector<String>();
        for(Vector<String> file:files.values())
        { 
            String[] temp=file.get(0).split(";");
            for(String Att:temp)
                ris.add(Att);
        }
        
        return  ris;
    }
    public Vector<String> getAllFileAtt(){
        Vector<String> ris= new Vector<String>();
        for(String file:files.keySet())
        { 
            String[] temp=files.get(file).get(0).split(";");
            for(String Att:temp)
                ris.add(file);
        }
        return  ris;
    }

    public Vector<String> getFile(String nomeFile) {
        if (!files.containsKey(nomeFile)) {
            System.out.println("File " + nomeFile + " non trovato tra i file della nazione");
            return null;
        }
        return files.get(nomeFile);
    }

    public Object[] getDati() {
        return dati;
    }
    public synchronized void AggiungiFile(String nome, Vector<String> righe) {
        this.files.put(nome, righe);
    }
}

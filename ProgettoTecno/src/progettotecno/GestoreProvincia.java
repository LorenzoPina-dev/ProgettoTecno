/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettotecno;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author user
 */
public class GestoreProvincia {

    private static GestoreProvincia instance = null;
    private Map<String, Vector<String>> files;    //uso le mappe in modo da avere maggiore accessibilità e maggiore chiarezza nell'accesso
    private Map<String, Provincia> province;
    private Vector<String> AttRicerca;

    private GestoreProvincia() {
        province = new LinkedHashMap<String, Provincia>();
        files = new HashMap<String, Vector<String>>();
    }
    
    public Vector<String> getAllAtt(){
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
        Vector<String> ris= new Vector<String>();   //restituisco il nome del file che appartiene a ogni attributo che l'utente può scegliere
        for(String file:files.keySet())
        { 
            String[] temp=files.get(file).get(0).split(";");    //esptraggo gli attributi che ci sono nel file
            for(String Att:temp)
                ris.add(file);
        }
        return  ris;
    }

    public Vector<String> getAttRicerca() {
        return AttRicerca;
    }

    public void setAttRicerca(Vector<String> AttRicerca) {
        this.AttRicerca = AttRicerca;
        int size=AttRicerca.size();
    }

    public static synchronized GestoreProvincia Instance() {
        if (instance == null) {
            instance = new GestoreProvincia();
        }
        return instance;
    }

    public Provincia findProvincia(String provincia) {
        if (!province.containsKey(provincia)) {
            String key = ControllaSimili(provincia);
            if (key == null) {
                province.put(provincia, new Provincia(AttRicerca.size(), provincia));
            } else {
                provincia = key;
            }
        }
        return province.get(provincia);
    }

    public String ControllaSimili(String provincia) {
        String[] caratteriSeparazione = {"/", " ", "-"};        //splitto i moni delle regioni per controllare ogni pezzo e evitare problemi in qui i nomi siano leggermente diversi
        Vector<String> temp = new Vector<String>();
        Vector<String> pos = new Vector<String>();
        temp.add(provincia);
        for (String caratteri : caratteriSeparazione) {
            for (String el : temp) {
                String[] sup = el.split(caratteri);
                for (String e : sup) {
                    pos.add(e);
                }
            }
            temp = (Vector<String>) pos.clone();
            pos.clear();
        }
        for (String key : province.keySet()) {
            for (String pezzo : temp) {
                if ((key.contains(pezzo) || pezzo.contains(key)) && !pezzo.equals("") && !pezzo.contains("Provincia") && !pezzo.contains("Autonoma") && !pezzo.contains("Valle") && !pezzo.contains("P.A.")) {
                    return key;
                }
            }
        }
        return null;
    }

    public synchronized void settaValore(String provincia, int pos, Object valore) {
        Provincia r = findProvincia(provincia);
        r.setAttributo(pos, valore);
    }

    public synchronized Map<String, Provincia> getProvince() {
        return province;
    }

    public synchronized Map<String, Vector<String>> getFiles() {
        return files;
    }

    public synchronized Vector<String> getFile(String Regione) {
        return files.get(Regione);
    }

    public synchronized void AggiungiFile(String nome, Vector<String> righe) {
        this.files.put(nome, righe);
    }
}

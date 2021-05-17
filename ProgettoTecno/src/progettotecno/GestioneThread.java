/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettotecno;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class GestioneThread {

    public static void GestioneDownload() throws InterruptedException {
        String[] files = {"https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-regioni/dpc-covid19-ita-regioni-latest.csv", "https://raw.githubusercontent.com/italia/covid19-opendata-vaccini/master/dati/vaccini-summary-latest.csv"};
        String[] nomiFile = {"Generale", "Vaccini"};
        String[] filesNaz = {"https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-andamento-nazionale/dpc-covid19-ita-andamento-nazionale-latest.csv"};
        String[] nomeFileNaz = {"Generale"};

        String[] nomiFileProv = {"Generale"};
        String[] province = {"https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-province/dpc-covid19-ita-province-latest.csv"};

        ThreadDownload[] thd = new ThreadDownload[files.length];
        for (int i = 0; i < files.length; i++) {
            thd[i] = new ThreadDownload(nomiFile[i], files[i], 0);
        }
        for (ThreadDownload th : thd) {
            th.start();
        }
        ThreadDownload[] thdNaz = new ThreadDownload[filesNaz.length];
        for (int i = 0; i < filesNaz.length; i++) {
            thdNaz[i] = new ThreadDownload(nomeFileNaz[i], filesNaz[i], 1);
        }

        ThreadDownload[] thdProv = new ThreadDownload[province.length];
        for (int i = 0; i < province.length; i++) {
            thdProv[i] = new ThreadDownload(nomiFileProv[i], province[i], 2);
        }

        for (ThreadDownload th : thdProv) {
            th.start();
        }

        for (ThreadDownload th : thdNaz) {
            th.start();
        }
        for (ThreadDownload th : thd) {
            th.join();
        }
        for (ThreadDownload th : thdNaz) {
            th.join();
        }
        for (ThreadDownload th : thdProv) {
            th.join();
        }
    }

    public static void GestioneRicerca(String percorso, String nomeFile, String nomeFileNaz, String nomeFileProv, String nome, String Password, Vector<String> ParametriRicerca, Vector<String> fileRicerca, Vector<String> ParametriRicercaNaz, Vector<String> fileRicercaNaz, Vector<String> ParametriRicercaProv, Vector<String> fileRicercaProv) throws IOException, InterruptedException {
        Gestore.Istance().setAttRicerca(ParametriRicerca);
        GestoreProvincia.Instance().setAttRicerca(ParametriRicercaProv);
        GestoreNazione.Instance().setAttRicerca(fileRicercaNaz);
        int sizePar = ParametriRicerca.size();
        int sizeParProv = ParametriRicercaProv.size();
        ThreadRicerca[] ricerche = new ThreadRicerca[sizePar];
        for (int i = 0; i < sizePar; i++) {
            ricerche[i] = new ThreadRicerca(fileRicerca.get(i), ParametriRicerca.get(i), i + 1);    //i è la colonna in cui ci sarà il dato scelto
        }

        ThreadRicercaProv[] ricercheProv = new ThreadRicercaProv[sizeParProv];
        for (int i = 0; i < sizeParProv; i++) {
            ricercheProv[i] = new ThreadRicercaProv(fileRicercaProv.get(i), ParametriRicercaProv.get(i), i + 1);    //i è la colonna in cui ci sarà il dato scelto
        }

        for (int i = 0; i < sizePar; i++) {
            ricerche[i].start();
        }

        for (int i = 0; i < sizeParProv; i++) {
            ricercheProv[i].start();
        }

        int sizeParNaz = ParametriRicercaNaz.size();
        ThreadRicercaNaz[] ricercheNaz = new ThreadRicercaNaz[sizeParNaz];
        for (int i = 0; i < sizeParNaz; i++) {
            ricercheNaz[i] = new ThreadRicercaNaz(fileRicercaNaz.get(i), ParametriRicercaNaz.get(i), i);//i è la colonna in cui ci sarà il dato scelto
        }

        for (int i = 0; i < sizeParNaz; i++) {
            ricercheNaz[i].start();
        }
        for (int i = 0; i < sizePar; i++) {
            ricerche[i].join();
        }
        for (int i = 0; i < sizeParNaz; i++) {
            ricercheNaz[i].join();
        }

        for (int i = 0; i < sizeParProv; i++) {
            ricercheProv[i].join();
        }
        boolean regione = true, naz = true, prov = true;
        if (ParametriRicerca.size() > 0) {
            gestioneFile.creaFile(percorso + "\\" + nomeFile, ParametriRicerca);
            regione=gestioneFile.Upload(percorso, nome, Password, nomeFile);
        }
        if (ParametriRicercaNaz.size() > 0 &&regione) {
            gestioneFile.creaFileNaz(percorso + "\\" + nomeFileNaz, ParametriRicercaNaz);
            naz=gestioneFile.Upload(percorso, nome, Password, nomeFileNaz);
        }
        if (ParametriRicercaProv.size() > 0&&regione && naz) {
            gestioneFile.creaFileProv(percorso + "\\" + nomeFileProv, ParametriRicercaProv);
            prov=gestioneFile.Upload(percorso, nome, Password, nomeFileProv);
        }
        
        if ( regione&& naz && prov) {
            JOptionPane.showMessageDialog(null, "aggiornamento avvenuto con successo");
        }
    }
}

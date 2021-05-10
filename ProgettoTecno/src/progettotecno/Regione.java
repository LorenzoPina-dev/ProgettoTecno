/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettotecno;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author user
 */

public class Regione {
    private Object[] regione;
    public Regione(int lenght,String Nomeregione){
        regione=new Object[lenght+1];
        regione[0]=Nomeregione;
    }
    
    public void setAttributo(int pos,Object valore){
        regione[pos]= valore;
    }

    public String toCSV() {
        String ris="";
        for(int i=0;i<regione.length-1;i++)
            ris+= regione[i].toString()+";";
        ris+=regione[regione.length-1].toString();
        return ris;
    }
    
}

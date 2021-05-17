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

public class Provincia {
    private Object[] provincia;
    public Provincia(int lenght,String Nomeprovincia){
        provincia=new Object[lenght+1];
        provincia[0]=Nomeprovincia;
    }
    
    public void setAttributo(int pos,Object valore){
        provincia[pos]= valore;
    }

    public String toCSV() {
        String ris="";
        for(int i=0;i<provincia.length-1;i++)
        {
            if(provincia[i]!=null)
                ris+= provincia[i].toString()+";";
            else
                ris+=";";
        }
        ris+=provincia[provincia.length-1].toString();
        return ris;
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettotecno;

import java.awt.Button;
import java.awt.Component;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import static progettotecno.GestioneThread.GestioneDownload;
import static progettotecno.GestioneThread.GestioneRicerca;

/**
 *
 * @author user
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    Vector<String> AllAtt, FileAtt, AllAttNaz, FileAttNaz;        //i dati relativi agli attributi che l'utente può selezionare
    Vector<String> RimanentiReg, RimanentiNaz;  //per gestire la ricerca degli attributi e rappresentano i dati che l'utente può ancora scegliere
    DefaultListModel<String> model, model2, modelNaz, model2Naz; //le 4 liste 2 per gli attributi scelti e non e le altre 2 per la nazione
    String percorso = ".\\";
    String nomeSettaggi = "settaggi.txt";
    String nomeDati = "dati.csv";
    String nomeDatiNaz = "datiNaz.csv";

    public Interface() {
        initComponents();
        try {
            GestioneDownload();
        } catch (InterruptedException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        AllAtt = Gestore.Istance().getAllAtt();
        FileAtt = Gestore.Istance().getAllFileAtt();
        AllAttNaz = GestoreNazione.Instance().getAllAtt();
        FileAttNaz = GestoreNazione.Instance().getAllFileAtt();
        RimanentiReg = new Vector<String>();
        RimanentiNaz = new Vector<String>();
        model = new DefaultListModel<String>();
        model2 = new DefaultListModel<String>();
        modelNaz = new DefaultListModel<String>();
        model2Naz = new DefaultListModel<String>();
        for (String Att : AllAtt) {
            RimanentiReg.addElement(Att);
        }
        for (String Att : AllAttNaz) {
            RimanentiNaz.addElement(Att);
        }
        ListAtt.setModel(model);
        ListAttScelti.setModel(model2);
        ListAttNaz.setModel(modelNaz);
        ListAttSceltiNaz.setModel(model2Naz);
        AggiornaGrafica();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TxtSito = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        TxtUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtPassword = new javax.swing.JTextField();
        Cancella = new javax.swing.JButton();
        AggiornaDati = new javax.swing.JButton();
        CaricaVecchiaConf = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListAtt = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListAttScelti = new javax.swing.JList<>();
        ButAdd = new javax.swing.JButton();
        ButRemuve = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListAttNaz = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListAttSceltiNaz = new javax.swing.JList<>();
        ButRemuve1 = new javax.swing.JButton();
        ButAdd1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtFiltroRegione = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtFiltroNaz = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("sito dove caricare il file:");
        jLabel1.setToolTipText("");
        jLabel1.setName(""); // NOI18N

        TxtSito.setName("TxtSito"); // NOI18N

        jLabel2.setText("username:");
        jLabel2.setToolTipText("");
        jLabel2.setName(""); // NOI18N

        TxtUsername.setName("TxtUsername"); // NOI18N

        jLabel3.setText("Password");
        jLabel3.setToolTipText("");
        jLabel3.setName(""); // NOI18N

        TxtPassword.setName("TxtPassword"); // NOI18N

        Cancella.setText("Annulla");
        Cancella.setName("butAnnulla"); // NOI18N
        Cancella.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancellaActionPerformed(evt);
            }
        });

        AggiornaDati.setText("AggiornaDati");
        AggiornaDati.setName("ButAggiorna"); // NOI18N
        AggiornaDati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AggiornaDatiActionPerformed(evt);
            }
        });

        CaricaVecchiaConf.setText("caricaVecchiaConfigrazione");
        CaricaVecchiaConf.setName("butCaricaConf"); // NOI18N
        CaricaVecchiaConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaricaVecchiaConfActionPerformed(evt);
            }
        });

        ListAtt.setName("ListAtt"); // NOI18N
        jScrollPane1.setViewportView(ListAtt);

        ListAttScelti.setName("ListAttScelti"); // NOI18N
        jScrollPane2.setViewportView(ListAttScelti);

        ButAdd.setText("Add");
        ButAdd.setName("ButAdd"); // NOI18N
        ButAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAddActionPerformed(evt);
            }
        });

        ButRemuve.setText("remuve");
        ButRemuve.setName("ButRemuve"); // NOI18N
        ButRemuve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButRemuveActionPerformed(evt);
            }
        });

        ListAttNaz.setName("ListAtt"); // NOI18N
        jScrollPane3.setViewportView(ListAttNaz);

        ListAttSceltiNaz.setName("ListAttScelti"); // NOI18N
        jScrollPane4.setViewportView(ListAttSceltiNaz);

        ButRemuve1.setText("remuve");
        ButRemuve1.setName("ButRemuve"); // NOI18N
        ButRemuve1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButRemuve1ActionPerformed(evt);
            }
        });

        ButAdd1.setText("Add");
        ButAdd1.setName("ButAdd"); // NOI18N
        ButAdd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButAdd1ActionPerformed(evt);
            }
        });

        jLabel4.setText("seleziona campi riguardo la nazione");

        jLabel5.setText("seleziona campi riguardo le regioni");

        TxtFiltroRegione.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtFiltroRegioneKeyPressed(evt);
            }
        });

        jLabel6.setText("ricerca Attributi Regione");

        TxtFiltroNaz.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtFiltroNazKeyPressed(evt);
            }
        });

        jLabel7.setText("ricerca Attributi Nazione");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(Cancella))
                            .addComponent(TxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtSito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(CaricaVecchiaConf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AggiornaDati)
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addComponent(jLabel6))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(TxtFiltroRegione, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(jLabel5)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(144, 144, 144))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(TxtFiltroNaz, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(ButAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(ButRemuve)
                                            .addComponent(ButAdd1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(340, 340, 340)
                                    .addComponent(ButRemuve1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(373, 373, 373)
                                    .addComponent(jLabel4))))
                        .addContainerGap(18, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtSito, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtFiltroRegione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TxtFiltroNaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(ButAdd)
                                        .addGap(18, 18, 18)
                                        .addComponent(ButRemuve))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(TxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(TxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(ButAdd1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ButRemuve1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Cancella)
                        .addComponent(AggiornaDati))
                    .addComponent(CaricaVecchiaConf))
                .addContainerGap())
        );

        TxtSito.getAccessibleContext().setAccessibleName("TxtSito");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AggiornaDatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AggiornaDatiActionPerformed
        int sizeModel12 = model2.size();
        Vector<String> AttScelti = new Vector<String>(sizeModel12), File = new Vector<String>(sizeModel12);
        for (int i = 0; i < sizeModel12; i++) {
            AttScelti.addElement(model2.get(i));
        }
        for (int i = 0; i < model2.size(); i++) {
            int j = 0;
            boolean trovato = false;
            while (j < FileAtt.size() && !trovato) {
                if (AllAtt.get(j).equals(AttScelti.get(i))) {//cerco in che file si trova il dato scelto
                    File.addElement(FileAtt.get(j));
                    trovato = true;
                }
                j++;
            }
        }
        int sizeModel12Naz = model2Naz.size();
        Vector<String> AttSceltiNaz = new Vector<String>(sizeModel12Naz), FileNaz = new Vector<String>(sizeModel12Naz);
        for (int i = 0; i < model2Naz.size(); i++) {
            AttSceltiNaz.addElement(model2Naz.get(i));
        }
        for (int i = 0; i < model2Naz.size(); i++) {
            int j = 0;
            boolean trovato = false;
            while (j < AllAttNaz.size() && !trovato) {
                if (AllAttNaz.get(j).equals(AttSceltiNaz.get(i))) {
                    FileNaz.addElement(FileAttNaz.get(j));
                    trovato = true;
                }
                j++;
            }
        }
        try {
            GestioneRicerca(percorso, nomeDati, nomeDatiNaz, TxtSito.getText(), TxtUsername.getText(), TxtPassword.getText(), AttScelti, File, AttSceltiNaz, FileNaz);
            gestioneFile.CreaFileSettaggi(percorso + "\\" + nomeSettaggi, TxtSito.getText(), TxtUsername.getText(), TxtPassword.getText(), AttScelti, AttSceltiNaz);    //file che serve per dare una esperienza migliore all'utente in modo tale che non deve inserire sempre tutti i dati ma ha un salvataggio del ultimo settaggio
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_AggiornaDatiActionPerformed

    private void ButAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButAddActionPerformed
        Add(model, model2, ListAtt, true, RimanentiReg, true);
    }//GEN-LAST:event_ButAddActionPerformed

    private void ButRemuveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButRemuveActionPerformed
        Add(model2, model, ListAttScelti, false, RimanentiReg, true);//inverto mode1 con mode2 per fare in modo che lo tolga al posto di metterlo
    }//GEN-LAST:event_ButRemuveActionPerformed

    private void CancellaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancellaActionPerformed
        model2.clear();
        RimanentiReg = (Vector<String>) AllAtt.clone();
        model2Naz.clear();
        RimanentiNaz = (Vector<String>) AllAttNaz.clone();
        AggiornaGrafica();
        TxtPassword.setText("");
        TxtSito.setText("");
        TxtUsername.setText("");
        TxtFiltroNaz.setText("");
        TxtFiltroRegione.setText("");
    }//GEN-LAST:event_CancellaActionPerformed

    private void CaricaVecchiaConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaricaVecchiaConfActionPerformed
        try {
            String[] Att = gestioneFile.LeggiFileSettaggi(percorso + "\\" + nomeSettaggi);
            model2.clear();
            model2Naz.clear();
            TxtSito.setText(Att[0]);
            TxtUsername.setText(Att[1]);
            TxtPassword.setText(Att[2]);
            int divisione = -1;
            for (int i = 0; i < Att.length; i++) {
                if (Att[i].equals("Naz")) {     //splitto gli attributi della regione da quelli della nazione
                    divisione = i;
                    break;
                }
            }
            RimanentiReg = (Vector<String>) AllAtt.clone();
            RimanentiNaz = (Vector<String>) AllAttNaz.clone();
            for (int i = 3; i < divisione; i++) {
                model2.addElement(Att[i]);
                RimanentiReg.remove(Att[i]);
            }
            for (int i = divisione + 1; i < Att.length; i++) {
                model2Naz.addElement(Att[i]);
                RimanentiNaz.remove(Att[i]);
            }
            AggiornaGrafica();
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CaricaVecchiaConfActionPerformed

    private void AggiornaRegione() {
        TxtFiltroRegione.setText("");
        model.clear();
        for (String el : RimanentiReg) {
            model.addElement(el);
        }
    }

    private void AggiornaNazione() {
        TxtFiltroNaz.setText("");
        modelNaz.clear();
        for (String el : RimanentiNaz) {
            modelNaz.addElement(el);
        }
    }

    private void AggiornaGrafica() {
        AggiornaNazione();
        AggiornaRegione();
    }

    private void ButRemuve1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButRemuve1ActionPerformed
        Add(model2Naz, modelNaz, ListAttSceltiNaz, false, RimanentiNaz, false);
    }//GEN-LAST:event_ButRemuve1ActionPerformed

    private void ButAdd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButAdd1ActionPerformed
        Add(modelNaz, model2Naz, ListAttNaz, true, RimanentiNaz, false);
    }//GEN-LAST:event_ButAdd1ActionPerformed

    private void TxtFiltroRegioneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFiltroRegioneKeyPressed
        filtra(model, TxtFiltroRegione.getText(), RimanentiReg);
    }//GEN-LAST:event_TxtFiltroRegioneKeyPressed

    private void TxtFiltroNazKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtFiltroNazKeyPressed
        filtra(modelNaz, TxtFiltroNaz.getText(), RimanentiNaz);
    }//GEN-LAST:event_TxtFiltroNazKeyPressed
    private void filtra(DefaultListModel<String> model, String testo, Vector<String> all) {
        if (model == null || testo == null || all == null) {
            return;
        }
        model.clear();
        for (String a : all) {
            if (a.contains(testo) || testo.equals("")) {
                model.addElement(a);
            }
        }
    }

    private void Add(DefaultListModel<String> model1, DefaultListModel<String> model2, JList<String> lista, boolean Aggiunta, Vector<String> rimanenti, boolean regione) {
        int indice = lista.getSelectedIndex();
        if (indice == -1) {
            JOptionPane.showMessageDialog(null, "Devi selezionare un elemento");
            return;
        }
        String El = model1.elementAt(indice);
        model2.addElement(El);
        model1.removeElement(El);
        if (!Aggiunta) {
            rimanenti.addElement(El);
        } else {
            rimanenti.remove(El);
        }
        if (regione) {
            AggiornaRegione();
        } else {
            AggiornaNazione();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AggiornaDati;
    private javax.swing.JButton ButAdd;
    private javax.swing.JButton ButAdd1;
    private javax.swing.JButton ButRemuve;
    private javax.swing.JButton ButRemuve1;
    private javax.swing.JButton Cancella;
    private javax.swing.JButton CaricaVecchiaConf;
    private javax.swing.JList<String> ListAtt;
    private javax.swing.JList<String> ListAttNaz;
    private javax.swing.JList<String> ListAttScelti;
    private javax.swing.JList<String> ListAttSceltiNaz;
    private javax.swing.JTextField TxtFiltroNaz;
    private javax.swing.JTextField TxtFiltroRegione;
    private javax.swing.JTextField TxtPassword;
    private javax.swing.JTextField TxtSito;
    private javax.swing.JTextField TxtUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables

    private void addElement(String get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

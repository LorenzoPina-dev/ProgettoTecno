package progettotecno;

/**
 *
 * @author user
 */
import java.io.BufferedInputStream;
import java.io.File;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class gestioneFile {

    public static Vector<String> DownloadCSV(String link) {
        if (link.indexOf(".csv") != -1) {
            String file = "";
            try {
                URL url = new URL(link);
                HttpURLConnection http = (HttpURLConnection) url.openConnection();
                double fileSize = (double) http.getContentLengthLong();
                BufferedInputStream in = new BufferedInputStream(http.getInputStream());
                byte[] buffer = new byte[1024];
                int read = 0;
                while ((read = in.read(buffer, 0, 1024)) >= 0) {
                    for (int i = 0; i < buffer.length; i++) {
                        if (buffer[i] == ',') {         //metto il ; in quanto nel file di partenza si usava la , per la separazione dei campi
                            buffer[i] = ';';
                        }
                    }
                    file += new String(buffer, 0, read);
                }
                in.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Vector<String> ris = new Vector<String>();
            String[] vet = file.split("\n");
            for (String el : vet) {
                ris.addElement(el);
            }
            if (ris.get(ris.size() - 1) == "") {        //tolgo l'ultima riga perchè in alcuni file era prresente un \n alla file del file 
                ris.remove(ris.size() - 1);
            }
            return ris;
        }
        return null;
    }

    public static void CreaFileSettaggi(String percorso, String username, String Password, Object[] Att,boolean naz,boolean regione,boolean province) throws FileNotFoundException, IOException {
        File out = new File(percorso);
        FileOutputStream bout = new FileOutputStream(out);
        String Stringout = username + "\n" + Password + "\n"+naz+ "\n"+regione+ "\n"+province+"\n";
        for (int i=0;i<Att.length-1;i++) {
            Stringout += Att[i].toString() + "\n";
        }
            Stringout += Att[Att.length-1].toString();
        bout.write(Stringout.getBytes());
    }

    public static String[] LeggiFileSettaggi(String percorso) throws FileNotFoundException, IOException {
        File in = new File(percorso);
        FileInputStream bIn = new FileInputStream(in);
        String file = "";
        byte[] buffer = new byte[1024];
        int read = 0;
        while ((read = bIn.read(buffer, 0, 1024)) >= 0) {
            file += new String(buffer, 0, read);
        }
        return file.split("\n");
    }

    public static void creaFileNaz(String percorso, Vector<String> Attributi) throws FileNotFoundException, IOException {
        Object[] dati = GestoreNazione.Instance().getDati();
        File out = new File(percorso);
        FileOutputStream bout = new FileOutputStream(out);
        String DatiOut = "";
        for (int i = 0; i < Attributi.size() - 1; i++) {
            DatiOut += Attributi.get(i) + ";";
        }
        DatiOut += Attributi.get(Attributi.size() - 1) + "\n";
        for (int i = 0; i < dati.length - 1; i++) {
            if(dati[i]!=null)
                DatiOut += dati[i].toString() + ";";
            else
                DatiOut += ";";
        }
        DatiOut += dati[dati.length - 1].toString();
        DatiOut += "\n";
        bout.write(DatiOut.getBytes());
    }

    public static void creaFile(String percorso, Vector<String> Attributi) throws FileNotFoundException, IOException {
        Map<String, Regione> dati = Gestore.Istance().getRegioni();
        File out = new File(percorso);
        FileOutputStream bout = new FileOutputStream(out);
        String DatiOut = "Nome;";
        for (int i = 0; i < Attributi.size() - 1; i++) {        //creao l'intestazione
            DatiOut += Attributi.get(i) + ";";
        }
        DatiOut += Attributi.get(Attributi.size() - 1);
        DatiOut += "\n";
        for (Regione r : dati.values()) {
            DatiOut += r.toCSV() + "\n";
        }
        bout.write(DatiOut.getBytes());
    }
    
    public static void creaFileProv(String percorso, Vector<String> Attributi) throws FileNotFoundException, IOException {
        Map<String, Provincia> dati = GestoreProvincia.Instance().getProvince();
        File out = new File(percorso);
        FileOutputStream bout = new FileOutputStream(out);
        String DatiOut = "Nome;";
        for (int i = 0; i < Attributi.size() - 1; i++) {        //creao l'intestazione
            DatiOut += Attributi.get(i) + ";";
        }
        DatiOut += Attributi.get(Attributi.size() - 1);
        DatiOut += "\n";
        for (Provincia r : dati.values()) {
            DatiOut += r.toCSV() + "\n";
        }
        bout.write(DatiOut.getBytes());
    }

    public static boolean Upload(String percorsoFile,  String user, String pass, String nomeFile) {
        int port = 21;

        FTPClient ftpClient = new FTPClient();
        try {

            ftpClient.connect("ftp.applorenzo2.altervista.org", port);
            if (ftpClient.login(user, pass)) {
                ftpClient.enterLocalPassiveMode();

                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                // APPROACH #1: uploads first file using an InputStream
                File firstLocalFile = new File(percorsoFile + "\\" + nomeFile);

                String firstRemoteFile = "/ProgettoTecno/dati/" + nomeFile;
                InputStream inputStream = new FileInputStream(firstLocalFile);

                System.out.println("Start uploading first file");
                boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
                inputStream.close();
                if (done) {
                    System.out.println("The first file is uploaded successfully.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "username o password errati");
                return false;
            }
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.logout();
                    ftpClient.disconnect();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                return false;
            }
        }
        return true;
    }
}

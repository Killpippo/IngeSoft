
// import per l'interfaccia grafica
import IngeSoft.PI2.PI2Manager;
import IngeSoft.PI2.RandomDataGenerator;
import IngeSoft.PI2.Visitatore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class MainForm {
    
    static private MainForm mainForm; // tengo il puntatore per far abilitare i controlli anche agli altri form
    private Frame mainFrame;
    private Button btnSave; // conservo questa variabile per abilitarla se ci son modifiche sui dati
   
    public MainForm(){
        inizializzaInterfaccia();
    }
    
    public static void main__( String[] argomenti){        
        mainForm = new MainForm();
    }
    
    private void inizializzaInterfaccia(){
      mainFrame = new Frame("Prova in Itinere 1");
      
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(8, 1));
      
      // uscita
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });
      
      // carica dati esistenti
      Button btn = new Button("Carica dati esistenti");
      btn.setActionCommand("LOAD");
      btn.addActionListener( new ButtonClickListener() );
      mainFrame.add( btn );
      
      btn = new Button("Aggiungi espositore");
      btn.setActionCommand("ADDESP");
      btn.addActionListener( new ButtonClickListener() );
      mainFrame.add( btn );
      
      btn = new Button("Aggiungi visitatore");
      btn.setActionCommand("ADDVIS");
      btn.addActionListener( new ButtonClickListener() );
      mainFrame.add( btn );
      
      btn = new Button("Modifica visitatore");
      btn.setActionCommand("SETVIS");
      btn.addActionListener( new ButtonClickListener() );
      mainFrame.add( btn );
      
      btn = new Button("Mostra liste");
      btn.setActionCommand("SHOWDATA");
      btn.addActionListener( new ButtonClickListener() );
      mainFrame.add( btn );
      
      btn = new Button("Esegui immissione dati di test");
      btn.setActionCommand("TEST");
      btn.addActionListener( new ButtonClickListener() );
      mainFrame.add( btn );
      
      btnSave = new Button("Salva i dati");
      btnSave.setActionCommand("SAVE");
      btnSave.addActionListener( new ButtonClickListener() );
      btnSave.setEnabled(false);
      mainFrame.add( btnSave );
      
      btn = new Button("ESCI");
      btn.setActionCommand("EXIT");
      btn.addActionListener( new ButtonClickListener() );
      mainFrame.add( btn );
      
      mainFrame.setVisible(true);  
   }
   
   public void DatiModificati()
   {
       btnSave.setEnabled(true);
   }
   
   private String PathFile( FileDialog fd )
   {
        if (fd.getFile() == null) return "";
        
        // correggo la path del file
        if (!fd.getDirectory().endsWith(File.separator)) return fd.getDirectory() + File.separator + fd.getFile();
        else return fd.getDirectory() + fd.getFile();
   }

   private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();
         
         switch (command)
         {
             case "LOAD":
             {
                 FileDialog loadDialog = new FileDialog( mainFrame, "Carica dati", FileDialog.LOAD );
                 loadDialog.setVisible(true);
                 String file = loadDialog.getFile();                 
                 if (file != null) {
                     if (!PI2Manager.LoadFromFile( PathFile(loadDialog) ))
                         JOptionPane.showMessageDialog(mainFrame, "Errore caricamento file: " + file );
                 }
             } break;
                 
             case "ADDESP":
             {
                 AddEspForm addEsp = new AddEspForm( mainForm );
                 addEsp.Show();
             } break;
                 
             case "ADDVIS":
                 AddVisForm addVis = new AddVisForm( mainForm );
                 addVis.Show();
                 break;
                 
             case "SETVIS":
                 String codiceFiscale = JOptionPane.showInputDialog("Inserisci Codice Fiscale");
                 if (codiceFiscale != null) {
                     Visitatore visitatore = PI2Manager.getVisitatore(codiceFiscale);
                     
                     if (visitatore == null) {
                         JOptionPane.showMessageDialog(mainFrame, "Visitatore inesistente");
                         return;                         
                     }
                     
                     SetVisForm setVisForm = new SetVisForm(mainForm, visitatore);
                     setVisForm.Show();
                 }
                 break;
                 
             case "SHOWDATA":
                 ShowDataForm showDataForm = new ShowDataForm(mainForm);
                 showDataForm.Show();
                 break;
                 
             case "SAVE":
                 FileDialog saveDialog = new FileDialog( mainFrame, "Carica dati", FileDialog.SAVE );
                 saveDialog.setVisible(true);
                 String file = saveDialog.getFile();                 
                 if (file != null) {
                     if (!PI2Manager.SaveOnFile( PathFile(saveDialog) ))
                         JOptionPane.showMessageDialog(mainFrame, "Errore salvataggio file: " + file);
                     else
                         btnSave.setEnabled(false);
                 }
                 break;
                 
             case "TEST":
                 RandomDataGenerator.EseguiTest();
                 JOptionPane.showMessageDialog(mainFrame, "Generazione dati di test completata");
                 btnSave.setEnabled(true);
                 break;
                 
             case "EXIT":
                 System.exit(0);
                 break;
         }	
      }		
   } 
}

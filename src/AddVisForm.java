import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import IngeSoft.PI1.*;

public class AddVisForm extends BaseForm {
    
    private TextField txtNome;
    private TextField txtCognome;
    private TextField txtCodiceFiscale;
    
    public AddVisForm( MainForm _parent ) {
        super( _parent, "Nuovo visitatore" );
        
        mainFrame.setSize(500,180);
        mainFrame.setLayout(new GridLayout(4, 2));
        
        // campo nome
        Label label = new Label();
        label.setText("Nome");
        mainFrame.add( label );
        
        txtNome = new TextField();
        mainFrame.add( txtNome );
        
        // campo cognome
        label = new Label();
        label.setText("Cognome");
        mainFrame.add( label );
        
        txtCognome = new TextField();
        mainFrame.add( txtCognome );
        
        // campo CF
        label = new Label();
        label.setText("Codice Fiscale");
        mainFrame.add( label );
        
        txtCodiceFiscale = new TextField();
        mainFrame.add( txtCodiceFiscale );
        
        // ok
        Button btn = new Button("OK");
        btn.setActionCommand("OK");
        btn.addActionListener( new ButtonClickListener() );
        mainFrame.add( btn );
        
        // cancel
        btn = new Button("Annulla");
        btn.setActionCommand("CANCEL");
        btn.addActionListener( new ButtonClickListener() );
        mainFrame.add( btn );
    }
    
    private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();
         
         switch (command)
         {
             case "OK":
             {
                 String nome = txtNome.getText();
                 String cognome = txtCognome.getText();
                 String cf = txtCodiceFiscale.getText();
                 
                 // controllo integrita' parametri
                 boolean parametriValidi = (nome.length() > 0 &&
                                            cognome.length() > 0 &&
                                            cf.length() > 0);
                 
                 if (!parametriValidi) {
                     JOptionPane.showMessageDialog(mainFrame, "Parametri mancanti o non validi" );
                     return;
                 }
                 
                 // inserimento nel gestore
                 if (!PI1Manager.addVisitatore(new Visitatore( nome, cognome, cf))) {
                     JOptionPane.showMessageDialog(mainFrame, "Visitatore con stesso Codice Fiscale gia' presente" );
                     return;
                 }
                 
                 parent.DatiModificati();
                 
                 mainFrame.dispose();
             } break;
                 
             case "CANCEL":
             {
                 mainFrame.dispose();
             } break;
         }
      }
    }
}

import IngeSoft.PI2.PI2Manager;
import IngeSoft.PI2.Espositore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class AddEspForm extends BaseForm {
    
    private TextField txtIVA;
    private TextField txtNome;
    private TextField txtPaese;
    private TextField txtArea;
    
    public AddEspForm( MainForm _parent ) {
        super( _parent, "Nuovo espositore");
      
        mainFrame.setSize(500,200);
        mainFrame.setLayout(new GridLayout(5, 2));
        
        // campo nome
        Label label = new Label();
        label.setText("Nome");
        mainFrame.add( label );
        
        txtNome = new TextField();
        mainFrame.add( txtNome );
        
        // campo iva
        label = new Label();
        label.setText("IVA");
        mainFrame.add( label );
        
        txtIVA = new TextField();
        mainFrame.add( txtIVA );
        
        // campo paese
        label = new Label();
        label.setText("Paese");
        mainFrame.add( label );
        
        txtPaese = new TextField();
        mainFrame.add( txtPaese );
        
        // campo area
        label = new Label();
        label.setText("Area (m2)");
        mainFrame.add( label );
        
        txtArea = new TextField();
        mainFrame.add( txtArea );
        
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
                 String iva = txtIVA.getText();
                 String paese = txtPaese.getText();
                 
                 int area = -1;
                 
                 try
                 {
                     area = Integer.parseInt(txtArea.getText());
                 } catch (Exception exc)
                 {}
                 
                 // controllo integrita' parametri
                 boolean parametriValidi = (nome.length() > 0 &&
                                            iva.length() > 0 &&
                                            paese.length() > 0 &&
                                            area > 0);
                 
                 if (!parametriValidi) {
                     JOptionPane.showMessageDialog(mainFrame, "Parametri mancanti o non validi" );
                     return;
                 }
                 
                 // inserimento nel gestore
                 if (!PI2Manager.addEspositore( new Espositore( nome, iva, paese, area))) {
                     JOptionPane.showMessageDialog(mainFrame, "Espositore con stessa IVA gia' presente" );
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

import IngeSoft.PI2.PI2Manager;
import IngeSoft.PI2.Visitatore;
import IngeSoft.PI2.Espositore;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class SetVisForm extends BaseForm {
    
    private Visitatore visitatore;
    java.awt.List visite;
    java.awt.List valutazioni;
    
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
    
    public SetVisForm( MainForm _parent, Visitatore _visitatore ) {
        super(_parent,"Modifica di " + _visitatore.getNome() + " " + _visitatore.getCognome() );
     
        visitatore = _visitatore;
        
        mainFrame.setSize(500,400);
        mainFrame.setLayout(new GridLayout(3, 2));
        
        // aggiungi visita
        Button btn = new Button("Aggiungi giorno visita");
        btn.setActionCommand("ADDVIS");
        btn.addActionListener( new ButtonClickListener() );
        mainFrame.add( btn );
        
        // giorni di visita
        visite = new java.awt.List();
        mainFrame.add(visite);
        
        Calendar [] aVisite = visitatore.getVisite();
        
        if (aVisite != null)
            for ( int i=0; i<aVisite.length; i++ )
                visite.add( formatDate.format(aVisite[i].getTime()) );
        
        // aggiungi valutazione
        btn = new Button("Aggiungi valutazione");
        btn.setActionCommand("ADDVAL");
        btn.addActionListener( new ButtonClickListener() );
        mainFrame.add( btn );
        
        // valutazioni
        valutazioni = new java.awt.List();
        mainFrame.add(valutazioni);
        
        String [] aValutazioni = null;//visitatore.Valutazioni();
        
        if (aValutazioni != null)
            for ( int i=0; i<aValutazioni.length; i++ )
                valutazioni.add( aValutazioni[i] );        
        // ok
        btn = new Button("Chiudi");
        btn.setActionCommand("CLOSE");
        btn.addActionListener( new ButtonClickListener() );
        mainFrame.add( btn );
    }
    
    private class ButtonClickListener implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         String command = e.getActionCommand();
         
         switch (command)
         {
             case "ADDVIS":
             {
                 String data = JOptionPane.showInputDialog("Inserisci giorno (DD/MM/YYYY)");
                 
                 if (data != null)
                 {
                     Calendar date = Calendar.getInstance();
                     
                     try {
                         date.setTime( formatDate.parse(data) );
                     
                        //visitatore.addVisita(date);
                     
                        visite.add( data );
                     }
                     catch (Exception exc) {
                         JOptionPane.showMessageDialog(mainFrame, "Formato errato" );
                     }
                 }
             } break;
                 
             case "ADDVAL":
             {
                String iva = JOptionPane.showInputDialog("Inserisci IVA espositore");
                
                if (iva == null) return;
                
                Espositore espositore = PI2Manager.getEspositore(iva);
                
                if (espositore == null) {
                    JOptionPane.showMessageDialog(mainFrame, "Espositore inesistente" );
                    return;
                }
                
                Calendar date = Calendar.getInstance();
                String data = JOptionPane.showInputDialog("Inserisci giorno (DD/MM/YYYY)");
                 
                if (data == null) return;
                 
                try {
                    date.setTime( formatDate.parse(data) );

                   //visitatore.addVisita(date);

                   visite.add( data );
                }
                catch (Exception exc) {
                    JOptionPane.showMessageDialog(mainFrame, "Formato errato" );
                    return;
                }
                
                String value = JOptionPane.showInputDialog("Inserisci Valutazione");
                
                if (value == null) return;
                
                int valutazione = Integer.parseInt(value);
                
                visitatore.addValutazione(espositore, date, valutazione);
                
                valutazioni.add( iva + "; " + data + "; " + value );
             } break;
                 
             case "CLOSE":
             {
                 mainFrame.dispose();
             } break;
         }
      }
    }
}

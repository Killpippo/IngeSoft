import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class ShowDataForm extends BaseForm {
    
    public ShowDataForm( MainForm _parent ) {
        super(_parent,"Lista dati" );
     
        mainFrame.setSize(500,200);
        mainFrame.setLayout(new GridLayout(1, 2));
        
        // aggiungo la lista degli espositori con i dati piu' impostanti
        java.awt.List espositori = new java.awt.List();
        mainFrame.add(espositori);
        
        espositori.add("-- espositori --");
        
        String [] aszList = null; //PI2Manager.getListEspositori();
        
        if (aszList != null)
            for ( int i=0; i<aszList.length; i++)
                espositori.add( aszList[i] );
        
        // aggiungo la lista dei visitatori
        java.awt.List visitatori = new java.awt.List();
        mainFrame.add(visitatori);
        
        visitatori.add("-- visitatori --");
        
        aszList = null; //PI2Manager.getListVisitatore();
        
        if (aszList != null)
            for ( int i=0; i<aszList.length; i++)
                visitatori.add( aszList[i] );
    }
    
}

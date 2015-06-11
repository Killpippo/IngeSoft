package IngeSoft.PI1;

import java.util.*;
import java.io.*;
import java.nio.ByteBuffer;

public class PI1Manager {

    static private List<Visitatore> visitatori;
    static private List<Espositore> espositori;
    
    static public Visitatore getVisitatore( String _codiceFiscale ) {
        if (visitatori == null) return null;
        
        for (Visitatore visitatore : visitatori) {
            if (visitatore.getCodiceFiscale().equalsIgnoreCase(_codiceFiscale)) {
                return visitatore;
            }
        }
        
        return null;
    }
    
    static public boolean addVisitatore( Visitatore _visitatore ) {
        if (visitatori == null) visitatori = new ArrayList<>();
        
        // gia' dichiarato
        if (visitatori.contains(_visitatore)) return false;
        
        visitatori.add( _visitatore );
        
        return true;
    }
    
    static public String [] getListVisitatore() {
        if (visitatori == null || visitatori.isEmpty()) return null;
        
        String [] aszLista = new String[visitatori.size()];
        
        for ( int i=0; i<visitatori.size(); i++) {
            aszLista[i] = visitatori.get(i).getNome() + " " + visitatori.get(i).getCognome() +
                            " (" + visitatori.get(i).getCodiceFiscale() + ")";
        }
        
        return aszLista;
    }
    
    static public Espositore getEspositore( String _IVA ) {
        if (espositori == null) return null;
        
        for (Espositore visitatore : espositori) {
            if (visitatore.getIVA().equalsIgnoreCase(_IVA)) {
                return visitatore;
            }
        }
        
        return null;
    }
    
    static public String [] getListEspositori() {
        if (espositori == null || espositori.isEmpty()) return null;
        
        String [] aszLista = new String[espositori.size()];
        
        for ( int i=0; i<espositori.size(); i++) {
            aszLista[i] = espositori.get(i).getNome() +
                            " (" + espositori.get(i).getIVA() + ";" +
                                espositori.get(i).getPaese() + ";" +
                                espositori.get(i).getArea() + ")";
        }
        
        return aszLista;
    }
    
    static public boolean addEspositore( Espositore _espositore ) {
        if (espositori == null) espositori = new ArrayList<Espositore>();
        
        // gia' dichiarato
        if (espositori.contains(_espositore)) return false;
        
        espositori.add( _espositore );
        
        return true;
    }
    
    static public void SvuotaDati()
    {
        if (espositori != null) espositori.clear();
        if (visitatori != null) visitatori.clear();
    }
        
    static public boolean SaveOnFile( String _filename ) {
        
        try {
            ByteBuffer buffer = ByteBuffer.allocate(4);
            
            try (FileOutputStream fstream = new FileOutputStream(_filename);
                 ObjectOutputStream objstream = new ObjectOutputStream(fstream)) {
                
                // salva gli espositori
                int iSize = (espositori != null) ? (espositori.size()) : (0);
                
                buffer.putInt(iSize);
                
                fstream.write( buffer.array(), 0, 4 );
                
                for ( int i=0; i<iSize; i++ ) {
                    objstream.writeObject(espositori.get(i));
                }
                
                // salva i visitatori
                iSize = (visitatori != null) ? (visitatori.size()) : (0);
                
                buffer.clear();
                buffer.putInt(iSize);
                
                fstream.write( buffer.array(), 0, 4 );
                
                for ( int i=0; i<iSize; i++ ) {
                    objstream.writeObject(visitatori.get(i));
                }
            }
        }
        catch (IOException ioExc) {
            return false;
        }
        
        return true;
    }
    
    static public boolean LoadFromFile( String _filename ) {
        
        // preparo le liste
        if (espositori != null) espositori.clear();
        else espositori = new ArrayList<>();
        
        if (visitatori != null) visitatori.clear();
        else visitatori = new ArrayList<>();
        
        try {
            ByteBuffer buffer = ByteBuffer.allocate(4);
            byte [] bytebuffer = new byte[4];
            
            try (FileInputStream fstream = new FileInputStream(_filename);
                 ObjectInputStream objstream = new ObjectInputStream(fstream)) {
                
                // numero espositori
                if (fstream.read(bytebuffer, 0, 4) != 4) {
                    objstream.close();
                    fstream.close();
                    
                    return false;
                }
                
                buffer.put(bytebuffer);
                
                int iSize = buffer.getInt(0);
                
                // espositori
                for ( int i=0; i<iSize; i++ ) {
                    espositori.add((Espositore) objstream.readObject() );
                }
                
                // numero visitatori
                if (fstream.read(bytebuffer, 0, 4) != 4) {
                    objstream.close();
                    fstream.close();
                    
                    return false;
                }
                
                buffer.clear();
                buffer.put(bytebuffer);
                
                iSize = buffer.getInt(0);
                
                for ( int i=0; i<iSize; i++ ) {
                    visitatori.add((Visitatore) objstream.readObject() );
                }
                
            }
        }
        catch (IOException | ClassNotFoundException ioExc) {
            return false;
        }
        
        return true;
    }
}

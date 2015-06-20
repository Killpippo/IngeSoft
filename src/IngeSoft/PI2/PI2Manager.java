package IngeSoft.PI2;

import java.util.*;
import java.io.*;
import java.nio.ByteBuffer;

public class PI2Manager {

    static private List<Visitatore> visitatori;
    static private List<Espositore> espositori;
    
    static public Visitatore getVisitatore( String _codiceFiscale ) {
        for (Visitatore visitatore : getListVisitatore()) {
            if (visitatore.getCodiceFiscale().equalsIgnoreCase(_codiceFiscale)) {
                return visitatore;
            }
        }
        
        return null;
    }
    
    static public boolean addVisitatore( Visitatore _visitatore ) {
        if (_visitatore == null) return false;
        
        // gia' dichiarato
        if (getListVisitatore().contains(_visitatore)) return false;
        
        getListVisitatore().add( _visitatore );
        
        return true;
    }
    
    static public boolean deleteVisitatore( String _CF ) {
        Visitatore vis = getVisitatore( _CF );
        
        if (vis != null) {
            getListVisitatore().remove( vis );
            
            return true;
        }
        
        return false;
    }
    
    static public List<Visitatore> getListVisitatore() {
       if (visitatori == null) visitatori = new ArrayList<>();
       
       return visitatori;
    }
    
    static public Espositore getEspositore( String _IVA ) {
        for (Espositore espositore : getListEspositori()) {
            if (espositore.getIVA().equalsIgnoreCase(_IVA)) {
                return espositore;
            }
        }
        
        return null;
    }
    
    static public List<Espositore> getListEspositori() {
          if (espositori == null) espositori = new ArrayList<Espositore>();
          
          return espositori;
    }
    
    static public boolean addEspositore( Espositore _espositore ) {
        if (_espositore == null) return false;
        // gia' dichiarato
        if (getListEspositori().contains(_espositore)) return false;
        
        getListEspositori().add( _espositore );
        
        return true;
    }
    
    static public boolean deleteEspositore( String _IVA ) {
        Espositore esp = getEspositore( _IVA );
        
        if (esp != null)
        {
            getListEspositori().remove(esp);
            
            // elimina tutte le votazioni sui visitatore
            for (Visitatore visitatore : getListVisitatore()) {
                visitatore.deleteValutazione(esp);
            }
            
            return true;
        }
        
        return false;
    }
    
    static public void SvuotaDati()
    {
        getListVisitatore().clear();
        getListEspositori().clear();
    }
        
    static public boolean SaveOnFile( String _filename ) {
        
        try {
            ByteBuffer buffer = ByteBuffer.allocate(4);
            
            try (FileOutputStream fstream = new FileOutputStream(_filename);
                 ObjectOutputStream objstream = new ObjectOutputStream(fstream)) {
                
                // salva gli espositori
                int iSize = getListEspositori().size();
                
                buffer.putInt(iSize);
                
                fstream.write( buffer.array(), 0, 4 );
                
                for ( int i=0; i<iSize; i++ ) {
                    objstream.writeObject(getListEspositori().get(i));
                }
                
                // salva i visitatori
                iSize = getListVisitatore().size();
                
                buffer.clear();
                buffer.putInt(iSize);
                
                fstream.write( buffer.array(), 0, 4 );
                
                for ( int i=0; i<iSize; i++ ) {
                    objstream.writeObject(getListVisitatore().get(i));
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
        SvuotaDati();
        
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
                    getListEspositori().add((Espositore) objstream.readObject() );
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
                    getListVisitatore().add((Visitatore) objstream.readObject() );
                }
                
            }
        }
        catch (IOException | ClassNotFoundException ioExc) {
            return false;
        }
        
        return true;
    }
}

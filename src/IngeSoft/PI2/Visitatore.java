package IngeSoft.PI2;

import java.io.*;
import java.util.*;
import java.text.*;

public class Visitatore extends Entity implements Serializable {
    
    private String cognome;
    private List<GregorianCalendar> visite;
    private List<Valutazione> valutazioni;
    
    
    public Visitatore() {
        super();
        cognome = "";
        visite = new ArrayList<>();
        valutazioni = new ArrayList<>();
    }
    
    public Visitatore( String _nome, String _cognome, String _codiceFiscale ) {
        super(_codiceFiscale,_nome);
        cognome = _cognome;
        visite = new ArrayList<>();
        valutazioni = new ArrayList<>();
    }
    
    public void setCognome( String _cognome ) {
        cognome = _cognome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public void setCodiceFiscale( String _codiceFiscale ) {
        setCodice(_codiceFiscale);
    }
    
    public String getCodiceFiscale() {
        return getCodice();
    }
    
    public void addVisita( GregorianCalendar _visita ) {
        // gia' inserita
        if (visite.contains(_visita)) return;
        
        visite.add(_visita);
    }
    
    public void deleteVisita( GregorianCalendar _visita ) {
        // non presente
        if (!visite.contains(_visita)) return;
        
        visite.remove(_visita);
        
        for (int i=0; i<valutazioni.size(); i++) {
            if (valutazioni.get(i).visita.compareTo(_visita) == 0)
            {
                valutazioni.remove(i);
                i--; // riavvolgo l'indice
            }
        }
    }
    
    public boolean addValutazione( Espositore _espositore, Calendar _visita, int _valutazione ) {
        // nessuno da valutare
        if (_espositore == null) return true;
        // il visitatore non c'era il giorno della valutazione
        if (!visite.contains(_visita)) return false;
        
        Valutazione val = new Valutazione( _espositore.getIVA(), _visita, _valutazione );
        
        // la valutazione e' gia' stata assegnata
        if (valutazioni.contains(val)) return false;
        
        valutazioni.add(val);
            
        //valutazioni.
        return true;
    }
    
    public Valutazione getValutazione( Espositore _espositore ) {
        if (_espositore != null)
        {
            for (Valutazione val : valutazioni) {
                if (val.ivaEspositore.compareTo(_espositore.getIVA()) == 0)
                    return val;
            }
        }
        
        return null;
    }
    
    public void deleteValutazione( Espositore _espositore ) {
        // non valido
        if (_espositore == null) return;
        
        for (Valutazione val : valutazioni) {
            if (val.ivaEspositore.compareTo(_espositore.getIVA()) == 0) {
                valutazioni.remove(val);
                
                return;
            }
        }
    }
    
    public GregorianCalendar[] getVisite() {
        if (visite.isEmpty()) return null;
        
        GregorianCalendar [] aVisite = new GregorianCalendar[visite.size()];
        
        aVisite = visite.toArray(aVisite);
                
        return aVisite;
    }
    
    public List<Valutazione> getValutazioni() {
        return valutazioni;
    }
            
}

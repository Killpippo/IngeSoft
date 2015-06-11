package IngeSoft.PI1;

import java.io.*;
import java.util.*;
import java.text.*;

public class Visitatore extends Entity implements Serializable {
    
    private String cognome;
    private List<Calendar> visite;
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
    
    public void addVisita( Calendar _visita ) {
        // gia' inserita
        if (visite.contains(_visita)) return;
        
        visite.add(_visita);
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
    
    public Calendar[] Visite() {
        if (visite.isEmpty()) return null;
        
        Calendar [] aVisite = new Calendar[visite.size()];
        
        aVisite = visite.toArray(aVisite);
                
        return aVisite;
    }
    
    public String [] Valutazioni() {
        if (valutazioni == null || valutazioni.isEmpty()) return null;
        
        String [] aszValutazioni = new String[valutazioni.size()];
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        
        for ( int i=0; i<valutazioni.size(); i++ )
        {
            aszValutazioni[i] = valutazioni.get(i).ivaEspositore + "; " +
                                formatDate.format(valutazioni.get(i).visita.getTime()) + "; " +
                                valutazioni.get(i).valutazione;
        }
        
        return aszValutazioni;
    }
            
}

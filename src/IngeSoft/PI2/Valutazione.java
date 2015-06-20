package IngeSoft.PI2;

import java.io.*;
import java.util.*;

public class Valutazione implements Serializable {
    
    public String ivaEspositore;
    public Calendar visita;
    public int valutazione;
    
    public Valutazione( String _ivaEsp, Calendar _visita, int _valutazione ) {
        ivaEspositore = _ivaEsp;
        visita = _visita;
        valutazione = _valutazione;
    }
    
    @Override
    public boolean equals( Object o) {
        return ivaEspositore.equalsIgnoreCase(((Valutazione)o).ivaEspositore );
    }
}

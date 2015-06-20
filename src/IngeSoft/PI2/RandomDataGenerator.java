package IngeSoft.PI2;

import java.util.*;

public class RandomDataGenerator {

    static public void EseguiTest()
    {
        PI2Manager.SvuotaDati();
        
        // genera un tot di espositori
        for ( int i=0; i<20; i++) {
            PI2Manager.addEspositore(new Espositore("ESP" + (i + 1), "IVA" + (i + 1), "PAESE" + (i + 1), i + 10 ));
        }
        
        // genera un tot di visitatori
        for ( int i=0; i< 15; i++ ) {
            Visitatore vis = new Visitatore( "N" + i, "C" + i, "cf" + i);
        
            // immetti alcune visite
            vis.addVisita( new GregorianCalendar(2015, 1, 1) );
            vis.addVisita(new GregorianCalendar(2015, 1, 2));
            vis.addVisita(new GregorianCalendar(2015, 1, 3));
            vis.addVisita(new GregorianCalendar(2015, 1, 4));
            vis.addVisita(new GregorianCalendar(2015, 1, 5));

            // immetti alcune votazioni
            if ((i%2) == 0)
            {
                vis.addValutazione(PI2Manager.getEspositore("IVA" + (i+1)), new GregorianCalendar(2015, 1, 1), i * 5 );
                vis.addValutazione(PI2Manager.getEspositore("IVA" + (i+3)), new GregorianCalendar(2015, 1, 3), i * 3 );
                vis.addValutazione(PI2Manager.getEspositore("IVA" + (i+5)), new GregorianCalendar(2015, 1, 5), i * 4 );
            }
            else
            {
                vis.addValutazione(PI2Manager.getEspositore("IVA" + (i+1)), new GregorianCalendar(2015, 1, 2), i * 5 );
                vis.addValutazione(PI2Manager.getEspositore("IVA" + (i+2)), new GregorianCalendar(2015, 1, 4), i * 6 );
            }

            PI2Manager.addVisitatore(vis);
        }
    }
}

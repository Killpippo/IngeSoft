/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngeSoft.PI1;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pippo
 */
public class VisitatoreTest {
    
    public VisitatoreTest() {
    }

    /**
     * Test inserimento visite
     */
    @Test
    public void testAddVisita() {        
        Visitatore visitatore = new Visitatore();
        
        for ( int i=0; i<3; i++)
            visitatore.addVisita(new GregorianCalendar(2000,1,1));        
        
        assertEquals( 1, visitatore.Visite().length );
    }

    /**
     * Test inserimento valutazione valida
     */
    @Test
    public void testAddValutazioneValida() {
        Visitatore visitatore = new Visitatore();
        
        Espositore _espositore = new Espositore("nome", "IVA1", "paese", 123);
        
        visitatore.addVisita(new GregorianCalendar(2000,1,1));
        
        assertEquals( true, visitatore.addValutazione(_espositore, new GregorianCalendar(2000,1,1), 123 ) );
    }
    
    /**
     * Test inserimento valutazione non valida, manca la visita
     */
    @Test
    public void testAddValutazioneVisitaInvalida() {
        Visitatore visitatore = new Visitatore();
        
        Espositore _espositore = new Espositore("nome", "IVA1", "paese", 123);
        
        assertEquals( false, visitatore.addValutazione(_espositore, new GregorianCalendar(2000,1,1), 123 ) );
    }
    
    /**
     * Test inserimento valutazione non valida, espositore ripetuto
     */
    @Test
    public void testAddValutazioneDuplicate() {
        Visitatore visitatore = new Visitatore();
        
        Espositore _espositore = new Espositore("nome", "IVA1", "paese", 123);
        
        visitatore.addVisita(new GregorianCalendar(2000,1,1));
        
        visitatore.addValutazione(_espositore, new GregorianCalendar(2000,1,1), 123 );
        visitatore.addValutazione(_espositore, new GregorianCalendar(2000,1,1), 987 );
        
        assertEquals(1, visitatore.getValutazioni().size());
        assertEquals(123, visitatore.getValutazioni().get(0).valutazione);
    }
}

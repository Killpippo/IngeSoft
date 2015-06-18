package IngeSoft.PI1;

import java.util.GregorianCalendar;
import org.junit.Test;
import static org.junit.Assert.*;


public class ValutazioneTest {
    
    public ValutazioneTest() {
    }

    @Test
    public void testEqualsSame() {
        Valutazione v1 = new Valutazione("123456", new GregorianCalendar(2000, 1, 1), 123 );
        Valutazione v2 = new Valutazione("123456", new GregorianCalendar(2000, 1, 1), 123 );
        assertEquals( true, v1.equals(v2));
    }
    
    @Test
    public void testEqualsDiff() {
        Valutazione v1 = new Valutazione("654321", new GregorianCalendar(2000, 1, 1), 123 );
        Valutazione v2 = new Valutazione("123456", new GregorianCalendar(2000, 1, 1), 123 );
        assertEquals( false, v1.equals(v2));
    }
    
}

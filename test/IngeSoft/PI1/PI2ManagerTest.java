package IngeSoft.PI1;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;


public class PI2ManagerTest {
    
    public PI2ManagerTest() {
    }

    @Test
    public void testGetVisitatore() {
        Visitatore visitatore = new Visitatore( "nome", "cognome", "CF");
        PI2Manager.addVisitatore(visitatore);
                
        assertEquals(null, PI2Manager.getVisitatore("123"));
        assertNotNull(PI2Manager.getVisitatore("CF"));
    }

    @Test
    public void testAddVisitatoreNull() {
        assertEquals(false, PI2Manager.addVisitatore(null));
        assertEquals(0, PI2Manager.getListVisitatore().size());
    }
    
    @Test
    public void testAddVisitatoreValid() {        
        Visitatore visitatore = new Visitatore( "nome", "cognome", "CF");
        assertEquals(true, PI2Manager.addVisitatore(visitatore));        
        assertEquals(1, PI2Manager.getListVisitatore().size());
    }
    
    @Test
    public void testAddVisitatoreDuplicated() {
        Visitatore visitatore = new Visitatore( "nome", "cognome", "CF");        
        PI2Manager.addVisitatore(visitatore);
        
        visitatore = new Visitatore( "nome2", "cognome2", "CF");
        assertEquals(false, PI2Manager.addVisitatore(visitatore));
        assertEquals(1, PI2Manager.getListVisitatore().size());
    }

    @Test
    public void testDeleteVisitatore() {
        Visitatore visitatore = new Visitatore( "nome", "cognome", "CF");
        PI2Manager.addVisitatore(visitatore);
        PI2Manager.deleteVisitatore("CF");
        
        assertEquals(0, PI2Manager.getListVisitatore().size());
    }

    @Test
    public void testGetListVisitatore() {
        assertNotSame(null, PI2Manager.getListVisitatore());
    }

    @Test
    public void testGetEspositore() {
        Espositore espositore = new Espositore("nome", "IVA", "paese", 123 );
        PI2Manager.addEspositore(espositore);
                
        assertEquals(null, PI2Manager.getEspositore("123"));
        assertNotNull(PI2Manager.getEspositore("IVA"));
    }

    @Test
    public void testGetListEspositori() {
        assertNotSame(null, PI2Manager.getListEspositori());
    }

    @Test
    public void testAddEspositoreNull() {
        assertEquals(false, PI2Manager.addEspositore(null));
        assertEquals(0, PI2Manager.getListEspositori().size());
    }
    
    @Test
    public void testAddEspositoreValid() {
        Espositore espositore = new Espositore("nome", "IVA", "paese", 123 );        
                
        assertEquals(true, PI2Manager.addEspositore(espositore));
        assertEquals(1, PI2Manager.getListEspositori().size());
    }
    
    @Test
    public void testAddEspositoreDuplicated() {
        Espositore espositore = new Espositore("nome", "IVA", "paese", 123 );        
        PI2Manager.addEspositore(espositore);
        
        espositore = new Espositore("nome", "IVA", "paese", 123 );        
        PI2Manager.addEspositore(espositore);
        
        assertEquals(false, PI2Manager.addEspositore(espositore));
        assertEquals(1, PI2Manager.getListEspositori().size());
    }

    @Test
    public void testDeleteEspositore() {
        Espositore espositore = new Espositore("nome", "IVA", "paese", 123 );        
        PI2Manager.addEspositore(espositore);
        PI2Manager.deleteEspositore("IVA");
        assertEquals(0, PI2Manager.getListEspositori().size());
    }

    @Test
    public void testSvuotaDati() {
        PI2Manager.SvuotaDati();
        
        assertEquals(0, PI2Manager.getListEspositori().size() + PI2Manager.getListVisitatore().size());
    }

//    @Test
//    public void testSaveOnFile() {
//        System.out.println("SaveOnFile");
//        String _filename = "";
//        boolean expResult = false;
//        boolean result = PI2Manager.SaveOnFile(_filename);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    @Test
//    public void testLoadFromFile() {
//        System.out.println("LoadFromFile");
//        String _filename = "";
//        boolean expResult = false;
//        boolean result = PI2Manager.LoadFromFile(_filename);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
    
}

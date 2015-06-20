package IngeSoft.PI2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class EntityTest {
    
    public EntityTest() {
    }
    
    @Test
    public void testEqualsSame() {
        Entity e1 = new Entity();
        Entity e2 = new Entity();
        
        e1.setCodice("123456");
        e2.setCodice("123456");
        
        assertEquals( true, e1.equals(e2) );
    }
    
    @Test
    public void testEqualsDiff() {
        Entity e1 = new Entity();
        Entity e2 = new Entity();
        
        e1.setCodice("654321");
        e2.setCodice("123456");
        
        assertEquals( false, e1.equals(e2) );
    }
}

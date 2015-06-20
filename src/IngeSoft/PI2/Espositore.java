package IngeSoft.PI2;

import java.io.*;

public class Espositore extends Entity implements Serializable {
    
    private String paese;
    private int area;
    
    public Espositore() {
        super();
        
        paese = "";
        area = 0;
    }
     
    public Espositore( String _nome, String _IVA, String _paese, int _area ) {
        super(_IVA,_nome);
        
        paese = _paese;
        area = _area;
    }
    
    public void setPaese( String _paese ) {
        paese = _paese;
    }
    
    public String getPaese() {
        return paese;
    }
    
    public void setArea( int _area ) {
        area = _area;
    }
    
    public int getArea() {
        return area;
    }
    
    public void setIVA( String _IVA ) {
        setCodice(_IVA);
    }
    
    public String getIVA() {
        return getCodice();
    }
}

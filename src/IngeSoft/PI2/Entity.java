package IngeSoft.PI2;


import java.io.*;
        
public class Entity implements Serializable {
    
    private String codice;
    private String nome;
    
    public Entity(){
        codice = "";
        nome = "";
    }
    
    public Entity( String _codice, String _nome )
    {
        codice = _codice.toUpperCase();
        nome = _nome;
    }
    
    public void setNome( String _nome ) {
        nome = _nome;
    }
    
    protected void setCodice( String _codice ) {
        codice = _codice.toUpperCase();
    }
    
    public String getNome() {
        return nome;
    }
    
    protected String getCodice() {
        return codice;
    }
    
    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        
        return getCodice().equals( ((Entity)o).getCodice() );
    }
}

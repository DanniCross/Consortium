package Datos;
public class Datos 
{
    private String nomb;
    private int costo;
    private int tiemp;

    public Datos() 
    {
    }

    public Datos(String nomb, int costo, int tiemp)
    {
        this.nomb = nomb;
        this.costo = costo;
        this.tiemp = tiemp;
    }

    public String getNomb() {
        return nomb;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getTiemp() {
        return tiemp;
    }

    public void setTiemp(int tiemp) {
        this.tiemp = tiemp;
    }
    
}

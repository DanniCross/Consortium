package Datos;

public class AtraccionMec extends Datos
{
    int num;
    public AtraccionMec()
    {
    }

    public AtraccionMec(int num, String nomb, int costo, int tiemp)
    {
        super(nomb, costo, tiemp);
        this.num = num;
    }
    
    
}

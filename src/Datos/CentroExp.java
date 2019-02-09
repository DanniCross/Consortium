package Datos;
public class CentroExp extends Datos
{
    int num;
    public CentroExp() 
    {
    }

    public CentroExp(int num, String nomb, int costo, int tiemp) {
        super(nomb, costo, tiemp);
        this.num = num;
    }
    
}

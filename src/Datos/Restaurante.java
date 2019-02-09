package Datos;
public class Restaurante extends Datos
{
    int num;
    public Restaurante() 
    {
    }

    public Restaurante(int num, String nomb, int costo, int tiemp)
    {
        super(nomb, costo, tiemp);
        this.num = num;
    }
    
    
}

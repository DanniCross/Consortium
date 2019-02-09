package Datos;
public class ServicioPublic extends Datos
{
    int num;
    public ServicioPublic() 
    {
    }

    public ServicioPublic(int num, String nomb, int costo, int tiemp)
    {
        super(nomb, costo, tiemp);
        this.num = num;
    }
    
}

package Arbol;

import java.util.ArrayList;

public class ListaRama 
{
    private ArrayList<NodoArb> rama;
    private int costoTot;
    private int numMenores;
    private double promed;
   
    public ListaRama() 
    {
    }
 
    public ListaRama(ArrayList<NodoArb> rama, int costoTot) 
    {
        this.rama = rama;
        this.costoTot = costoTot;
    }

    public int getNumMenores() {
        return numMenores;
    }

    public double getPromed() {
        return promed;
    }

    public void setPromed(double promed) {
        this.promed = promed;
    }
    
    public void setNumMenores(int numMenores) {
        this.numMenores = numMenores;
    }

    
    public ArrayList<NodoArb> getRama() {
        return rama;
    }

    public void setRama(ArrayList<NodoArb> rama) {
        this.rama = rama;
    }

    

    public int getCostoTot() {
        return costoTot;
    }

    public void setCostoTot(int costoTot) {
        this.costoTot = costoTot;
    }
    
    
    
}

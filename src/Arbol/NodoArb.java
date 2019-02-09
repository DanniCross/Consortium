package Arbol;

import Datos.SitioInteres;

public class NodoArb 
{
    private SitioInteres cont;
    private int costTotal;
    NodoArb hijoIzq;
    NodoArb hijoDer;

    int dato;
    int fe;
    

    public NodoArb(SitioInteres cont, int dato) 
    {    
        this.cont=cont;
        this.hijoIzq=this.hijoDer=null;
        this.dato=dato;
       
    }

    public int getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(int costTotal) {
        this.costTotal = costTotal;
    }
 
    public SitioInteres getCont() {
        return cont;
    }

    public void setCont(SitioInteres cont) {
        this.cont = cont;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

   
    public NodoArb getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoArb hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoArb getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoArb hijoDer) {
        this.hijoDer = hijoDer;
    }

    
}

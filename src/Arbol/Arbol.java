package Arbol;

import Datos.SitioInteres;
import java.util.ArrayList;

public class Arbol
{
    private NodoArb raiz;
    
    public Arbol() 
    {
        this.raiz = null;
    }
    /*********************************/
    public NodoArb obtenerRaiz()
    {
        return this.raiz;
    }
    // Buscar
    public NodoArb buscar(int d, NodoArb r)
    {
        if (this.raiz==null)
        {
            return null;
        }else if(r.dato==d)
        {
            return r;
        }else if(r.dato<d)
        {
        return buscar(d,r.hijoDer);
        }else
        {
            return buscar(d, r.hijoIzq);
        }

    }
    //Obtener el factor de equelibrio
    public int obtenerFE(NodoArb x)
    {
        if (x==null) 
        {
         return -1;   
        }else
        {
        return x.fe;
        }   
    }
    //Rotacion Simple Izquierda
    public NodoArb rotacionIzq(NodoArb c)
    {
        NodoArb aux=c.hijoIzq;
        c.hijoIzq=aux.hijoDer;
        aux.hijoDer=c;
        
        c.fe=Math.max(obtenerFE(c.hijoIzq),obtenerFE(c.hijoDer))+1;
//        aux.fe=Math.max(obtenerFE(c.hijoIzq),obtenerFE(c.hijoDer))+1;
        return aux;
    }
    //Rotacion Simple Derecha
    public NodoArb rotacionDer(NodoArb c)
    {
        NodoArb aux=c.hijoDer;
        c.hijoDer=aux.hijoIzq;
        aux.hijoIzq=c;
        
        c.fe=Math.max(obtenerFE(c.hijoIzq),obtenerFE(c.hijoDer))+1;
        aux.fe=Math.max(obtenerFE(c.hijoIzq),obtenerFE(c.hijoDer))+1;
        return aux;
    }
    //Rotacion doble a la izquierda
    public NodoArb rotacionDIzq(NodoArb c)
    {
        NodoArb temp;
        c.hijoIzq=rotacionDer(c.hijoIzq);
        temp=rotacionIzq(c);
        return temp; 
    }
    //Rotacion doble a la derecha
    public NodoArb rotacionDDer(NodoArb c)
    {
        NodoArb temp;
        c.hijoDer=rotacionIzq(c.hijoDer);
        temp=rotacionDer(c);
        return temp;
    }
    //Método para insertar AVL
    public NodoArb insertarAVL(NodoArb nuevo, NodoArb subAr)
    {
        NodoArb newPadre=subAr;
        if (nuevo.dato<subAr.dato)
        {
            if (subAr.hijoIzq==null) 
            {
                subAr.hijoIzq=nuevo;
            }else
            {
                subAr.hijoIzq=insertarAVL(nuevo,subAr.hijoIzq);
                if (obtenerFE(subAr.hijoIzq)-obtenerFE(subAr.hijoDer)==2) 
                {
                    if (nuevo.dato<subAr.hijoIzq.dato) 
                    {
                        newPadre=rotacionIzq(subAr);
                    }else
                    {
                        newPadre=rotacionDIzq(subAr);
                    }
                }
            
            }
        }else if(nuevo.dato>subAr.dato)
        {
            if (subAr.hijoDer==null) 
            {
                subAr.hijoDer=nuevo;
            }else
            {
                subAr.hijoDer=insertarAVL(nuevo,subAr.hijoDer);
                if (obtenerFE(subAr.hijoDer)-obtenerFE(subAr.hijoIzq)==2) 
                {
                    if (nuevo.dato>subAr.hijoDer.dato) 
                    {
                        newPadre=rotacionDer(subAr);
                    }else
                    {
                        newPadre=rotacionDDer(subAr);
                    }
                }
            }
        }else
        {
            System.out.println("Nodo duplicado");
        }
        //actualizando la altura
        if (subAr.hijoIzq==null && subAr.hijoDer!=null) 
        {
            subAr.fe=subAr.hijoDer.fe+1;
        }else if(subAr.hijoDer==null&& subAr.hijoIzq!=null)
        {
            subAr.fe=subAr.hijoIzq.fe+1;
        }else
        {
            subAr.fe=Math.max(obtenerFE(subAr.hijoIzq), obtenerFE(subAr.hijoDer))+1;
        }
        
        return newPadre;
    }
    //Método para insertar
    public void insertar(SitioInteres cont,int d)
    {
        NodoArb nuevo=new NodoArb(cont,d);
        if (this.raiz==null) 
        {
            this.raiz=nuevo;
        }else
        {
            this.raiz=insertarAVL(nuevo,this.raiz);
        }
    
    }
    public void InOrder(NodoArb raiz)
    {
        if(raiz!=null)
        {
            
            InOrder(raiz.hijoIzq);
            System.out.println("*"+raiz.dato);
            InOrder(raiz.hijoDer);   
        }
    }
    
    public void PreOrder(NodoArb raiz)
    {
        if (raiz!=null)
        {
            System.out.println("**"+raiz.dato);
            PreOrder(raiz.hijoIzq);
            PreOrder(raiz.hijoDer);        
        }  
    }
    
    
    public void PostOrder(NodoArb raiz)
    {
        if (raiz!=null) 
        {
            PostOrder(raiz.hijoIzq);
            PostOrder(raiz.hijoDer);
            System.out.println("***"+raiz.dato);
            
        }
    
    
    }
   /*******************************/ 
    
     public ArrayList<ArrayList<NodoArb>> getRamas(NodoArb n, ArrayList<NodoArb> rama,ArrayList<ArrayList<NodoArb>> ramas){
      
       if(n != null)
       {  
        if(n.hijoIzq  == null && n.hijoDer == null)
        {   
             rama.add(n);
             ArrayList<NodoArb> nuevo = new ArrayList<>(rama);
             ramas.add(nuevo);
             rama.remove(n);
             
             return ramas;
        }
        else{
            
            rama.add(n);
            
            if(n.hijoIzq != null)
            {
                ramas = getRamas(n.getHijoIzq(), rama,ramas);
            }
            
            if(n.hijoDer != null)
            {       
                ramas = getRamas(n.getHijoDer(), rama, ramas);              
            }
            rama.remove(n);
            return ramas;        
        }        
     }
      return null;
 }
  
     //cantidad de nodos en el arbol
     
      public int  CantNodos(NodoArb raiz, int cont)
    {
        if(raiz!=null)
        { 
            cont=CantNodos(raiz.hijoIzq,cont);
            //System.out.println("*"+raiz.dato);
            cont++;
            cont=CantNodos(raiz.hijoDer,cont);   
        }
        
        return cont;
    }
      
      public void CostoTotalArbol(NodoArb raiz)
      {
          int cont;
          if(raiz!=null)
        { 
            CostoTotalArbol(raiz.hijoIzq);
            cont=0;
            if(raiz.getCont().getAtracMec()!=null)
            {
                for (int i = 0; i < raiz.getCont().getAtracMec().size(); i++)
                {
                    cont+=raiz.getCont().getAtracMec().get(i).getCosto();
                }
            }
            if (raiz.getCont().getCentExp()!=null) 
            {
                cont+=raiz.getCont().getCentExp().getCosto();
            }
            if (raiz.getCont().getRest()!=null) 
            {
                cont+=raiz.getCont().getRest().getCosto();
            }
            if (raiz.getCont().getServPubl()!=null) 
            {
                cont+=raiz.getCont().getServPubl().getCosto();
            }
            raiz.setCostTotal(cont);
            CostoTotalArbol(raiz.hijoDer);   
        }
      
      }
      
      public int SumatoriaArbol(NodoArb raiz, int cont)
      {
          if(raiz!=null)
        { 
            cont=SumatoriaArbol(raiz.hijoIzq,cont);
            cont+=raiz.getCostTotal();
            cont=SumatoriaArbol(raiz.hijoDer,cont);   
        }
        return cont;
      
      
      }
    
    
    
    /*____________________*/

    public NodoArb getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArb raiz) {
        this.raiz = raiz;
    }
    
    
}

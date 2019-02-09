package Interfaz;

import Arbol.Arbol;
import Arbol.ListaRama;
import Arbol.NodoArb;
import Datos.CarroCuat;
import Datos.CarroDos;

import Datos.SitioInteres;
import XML.FileXML;

import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import org.xml.sax.SAXException;

public class Paint extends javax.swing.JPanel 
{
 
    ArrayList<SitioInteres> node;
    ArrayList<SitioInteres> lista=new ArrayList<SitioInteres>();
    SitioInteres miAux;
    ImageIcon imageList[]= new ImageIcon[15];
    Arbol tree= new Arbol();
    ImageIcon fond= new ImageIcon(getClass().getResource("../Imagen/fondo.png"));
    ListaRama ramaMasDinero,ramaMenosDinero= new ListaRama();
    boolean bandCostMayor, bandCostMenor,bandCostProme=false;
    ArrayList <ArrayList<NodoArb>> listaRamas,listaRamasPromedio, rutaPosible;
    ArrayList <ListaRama> actDatoRama=new ArrayList<ListaRama>();
    ArrayList <ListaRama> ramasMenores=new ArrayList<ListaRama>();
    ArrayList <ListaRama> promedioRama=new ArrayList<ListaRama>();
    int cantNodos,costoTotal, tiemUser, pasUser=0;
    double promedio;
    double limiteAnt, limiteDesp=0;
    ArrayList <ListaRama> listaPromedios=new ArrayList<ListaRama>();
    ListaRama masDinero, menosDinero, gastoPromedio, recorridoFinal=new ListaRama();
    CarroDos carTwo[]=new CarroDos[2];
    CarroCuat carFour[]= new CarroCuat[2];
    boolean pintarCarro=false;

    
    public Paint() throws SAXException, IOException 
    {
      
      CargarImagenes();
      try{
      FileXML archivo=new FileXML();  
      archivo.makeFileXML();
      
      
      node=archivo.ArrayConsorcio();
      
      ConstruirArbol(tree);
      this.CosteTiemTotal(tree.getRaiz());
      lista=AgregarNodoList(tree.getRaiz(), lista);
      
      tree.CostoTotalArbol(tree.getRaiz());
      listaRamasPromedio=tree.getRamas(tree.getRaiz(), new ArrayList<NodoArb>(), new ArrayList<ArrayList<NodoArb>>());
      listaRamas=tree.getRamas(tree.getRaiz(), new ArrayList<NodoArb>(), new ArrayList<ArrayList<NodoArb>>());//lista que contiene cada una de las ramas del arbol
      rutaPosible=tree.getRamas(tree.getRaiz(), new ArrayList<NodoArb>(), new ArrayList<ArrayList<NodoArb>>());
      PasarRamaDatos(listaRamas); 
      ramaMasDinero=RamaMasCara(actDatoRama);


      PasarRamasMenores(listaRamas);//ArrayList <ListaRamas>;
      
      ModificarCantServRest(ramasMenores);//cantidad de nodos en las ramas que sean Restaurantes y Servicios publicos
      EliminarNodeRama(ramasMenores);//Elimina los nodos que van hasta la primera rama
      ModificarCostRestServ(ramasMenores);//sumatoria de cada rama
      ramaMenosDinero=MenorCosto(ramasMenores);
      
      PasarRamasPromedio(listaRamasPromedio);
      CostoPromedRama(promedioRama); //costo promedio de cada rama
      cantNodos=tree.CantNodos(tree.getRaiz(), cantNodos);//cantidad de nodos del arbol
      cantNodos--;
      costoTotal=tree.SumatoriaArbol(tree.getRaiz(), costoTotal);//sumatoria de costo de cada nodo del arbol
      promedio=(double)costoTotal/cantNodos;//promedio total de todo el arbol sin incluir la porteria que su datos son nullo o cero
      limiteAnt=promedio-1;
      limiteDesp=promedio+1;
      PromedioRamasCorrect(promedioRama,promedio);
      
  
       carTwo[0]=new CarroDos();
       carTwo[1]=new CarroDos();
       carFour[0]=new CarroCuat();
       carFour[1]=new CarroCuat();
           //Rutas pedidas en el proyecto
       masDinero=ramaMasDinero;
       menosDinero=ramaMenosDinero;
       gastoPromedio=listaPromedios.get(0);
       
      
       AsignarPosicionCar();

      
        }catch(IOException | SAXException e)
        {
           JOptionPane.showMessageDialog(null, e, "ERROR", 0);
        }
        

       initComponents(); 
       
    }
   //Asigna posicion en JPanel a las autos 
    public void AsignarPosicionCar()
    {
         carTwo[0].setPosX((float) 50);
         carTwo[0].setPosY((float)30); 
         carTwo[1].setPosX((float)200);
         carTwo[1].setPosY((float)30);
         
         carFour[0].setPosX((float)100);
         carFour[0].setPosY((float)30);
         carFour[1].setPosX((float)150);
         carFour[1].setPosY((float)30);  
          pintarCarro=true;
    }
    
    //Recorrido final el usuario selecciona la ruta a recorrer dentro del arbol
    public ListaRama RecorridoFinalUser(ListaRama h, int time)
    {
        ListaRama end=new ListaRama();
        NodoArb temp;
        ArrayList<NodoArb> aux=new ArrayList<NodoArb>();
        int cont=0;
        for (int i = 0; i < h.getRama().size(); i++) 
        {
            cont+=h.getRama().get(i).getCont().getTiempoTotal();
            
            if(cont<=time)
            {
                temp= new NodoArb(h.getRama().get(i).getCont(),0);
                aux.add(temp);
               
            }
        }
        end=new ListaRama(aux,0);
        
        return end;
                
       
    
    }
    
    //Busca una ruta que tenga mas o  menos el promedio que se aproxime al promedio global
    public void PromedioRamasCorrect(ArrayList<ListaRama> h, double prom)
    {  
       if(h!=null){ 
        if(PosiblePromedio(h,limiteAnt, limiteDesp))
        {
            for (int i = 0; i < h.size(); i++) 
            {
                if (limiteAnt<=h.get(i).getPromed()&& h.get(i).getPromed()<=limiteDesp) 
                {
                     listaPromedios.add(h.get(i));
                     
                }
            }
            return;
        }else
        {
            limiteAnt--;
            limiteDesp++;
            PromedioRamasCorrect(h,prom);
           
        }
       }
    }
    //verificar posibles promedios de cada rama
    public boolean PosiblePromedio(ArrayList<ListaRama> h, double ant, double des)
    {
        double m;
        boolean resp=false;
        if(h!=null)
        {
            for (int i = 0; i < h.size(); i++) 
        {
            m=h.get(i).getPromed();
            if(ant<h.get(i).getPromed() && h.get(i).getPromed()<des )
            {  // System.out.println("prom "+h.get(i).getPromed());
                resp=true;
                break;
            }
        }
        }
        return resp; 
    }
    //sumatoria de cada nodo del arbol para el costo total de la ListaRama
    public int SumatoriaNodosArb(ArrayList<NodoArb> m)
    {
        int cont=0;
            if(m!=null)
            {
                for (int i = 0; i <m.size(); i++) 
                {
                    cont+=m.get(i).getCostTotal();
                }
            }
            return cont;
    }
    //calculo el costo promedio para cada rama
    public void CostoPromedRama(ArrayList<ListaRama> k)
    {
        for (int i = 0; i < k.size(); i++) 
        {
          k.get(i).setPromed(k.get(i).getCostoTot()/ (k.get(i).getRama().size()-1));
           
        }
    } 
    
    //Me devuelve la rama mas cara del arbol
    public ListaRama RamaMasCara(ArrayList<ListaRama> m)
    {
        ListaRama aux=m.get(1);
        for (int i = 0; i < m.size(); i++)
        {
            if (m.get(i).getCostoTot()>aux.getCostoTot()) 
            {
                 aux=m.get(i); 
            }
        }
        return aux;
    }
     //Pasa las ramas para poder calcular el promedio
    private void PasarRamasPromedio(ArrayList <ArrayList<NodoArb>> h)
    {   
        ListaRama aux;
        for (int i = 0; i < h.size(); i++) 
        {
           aux=new ListaRama(h.get(i), SumatoriaNodosArb(h.get(i))); 
           promedioRama.add(aux);
        }
    }
    
    //Pasa las ramas para despues determinar cual es la menor de todas
    private void PasarRamasMenores(ArrayList <ArrayList<NodoArb>> h)
    {   //ramasMenores
        ListaRama aux;
        for (int i = 0; i < h.size(); i++) 
        {
            if(HayRestServ(h.get(i)))
            {
                aux= new ListaRama(h.get(i),0);
                ramasMenores.add(aux);           
            }
        }
    }
    //Eliminar elementos que no se deben visitar después de los restaurantes
    public void EliminarDatosRestServ(ListaRama h)
    {
        int aux=1;
        for (int i = h.getRama().size()-1;  i>=0; i--) 
        {
            if(h.getNumMenores()>1 && aux!=h.getNumMenores())
            {
               
                if(h.getRama().get(i).getCont().getAtracMec()==null
                   &&h.getRama().get(i).getCont().getCentExp()==null
                   &&h.getRama().get(i).getCont().getRest()!=null
                        &&h.getRama().get(i).getCont().getRest()!=null)
                {
                  h.getRama().get(i).setCont(null);
                   aux++;
                }
                else
                {
                     h.getRama().remove(i);
                }
                
                
            }else if(h.getNumMenores()==1)
            {
                if(h.getRama().get(i).getCont().getAtracMec()==null
                   &&h.getRama().get(i).getCont().getCentExp()==null
                   &&h.getRama().get(i).getCont().getRest()!=null
                        &&h.getRama().get(i).getCont().getRest()!=null)
                {
                    break;
                }
                else
                {   
                    h.getRama().remove(i);
                }
            }
        }
    }
    //Rama que contenga mas de un nodo Restaurante y servicio publico 
    //se eliminaran los nodos que los contenga para quedar con uno solo
    public void EliminarNodeRama(ArrayList <ListaRama> h)
    {
        for (int i = 0; i < h.size(); i++) 
        {
            EliminarDatosRestServ(h.get(i));
        }
    
    }
    //Retorna la rama menor de todas
    public ListaRama MenorCosto(ArrayList<ListaRama> h)
    {
        ListaRama aux=h.get(0);
        
        for (int i = 0; i < h.size(); i++) 
        {
            if (h.get(i).getCostoTot()<h.get(0).getCostoTot()) 
            {
                aux=h.get(i);
            }
        }
        return aux;
    }
    public void ModificarCantServRest(ArrayList<ListaRama> m)
    {
        for (int i = 0; i < m.size(); i++) 
        {
            m.get(i).setNumMenores(CantRestServ(m.get(i))); 
        }
    
    }
    //cuenta cuantos nodos de restaurantes y seervicios componen cada rama
    private int CantRestServ(ListaRama k)
    {
        int cont=0;
        
        for (int i = 0; i <k.getRama().size(); i++) 
        {
            if(k.getRama().get(i).getCont().getAtracMec()==null
               && k.getRama().get(i).getCont().getCentExp()==null
               && k.getRama().get(i).getCont().getRest()!=null
               &&k.getRama().get(i).getCont().getServPubl()!=null)
            {
                cont++;
            }
        }
        return cont;
    
    }
    //calcula el costo total de cada rama
    public void ModificarCostRestServ(ArrayList<ListaRama> m)
    {
        ListaRama aux;
        int cont;
        for (int i = 0; i < m.size(); i++) 
        {   cont=0;
        
            for (int j = 0; j < m.get(i).getRama().size(); j++) 
            {
                cont+=m.get(i).getRama().get(j).getCont().getCostoTotal();
                
            }
        
            m.get(i).setCostoTot(cont);
        }
        
    
    }
   
    //Verifica en cada lista de nodos si hay una rama que contenga 
    //un restaurante y un servicio público para añadirla a la lista de RamasMenores 
    private boolean HayRestServ(ArrayList<NodoArb> m)
    {
        boolean resp=false;
        int cont=0;
        for (int i = 0; i <m.size(); i++) 
        {
            if (m.get(i).getCont().getAtracMec()==null &&
                m.get(i).getCont().getCentExp()==null &&
                m.get(i).getCont().getServPubl()!=null && 
                m.get(i).getCont().getRest()!=null) 
            {
                resp=true; 
                break;
            }
        }
        
        return resp;
    }
     //Hace la sumatoria total de cada una para determinar cual es la mas cara
    private void PasarRamaDatos(ArrayList <ArrayList<NodoArb>> h)
    {  ListaRama aux= new ListaRama();
        for (int i = 0; i < h.size(); i++) 
        {
             aux=new ListaRama(h.get(i),SumatoriaArray(h.get(i))); 
             actDatoRama.add(aux);
        }
    }
    //Sumatoria total de cada una de las ramas para determinar su valor de costo de rama
    public int SumatoriaArray(ArrayList<NodoArb> m)
    {
        int cont=0;
            if(m!=null)
            {
                for (int i = 0; i <m.size(); i++) 
                {
                    cont+=m.get(i).getCont().getCostoTotal();
                }
            }
            return cont;
    }
    //Enlista todos los datos de cada nodo del arbol
    public ArrayList<SitioInteres> AgregarNodoList(NodoArb n, ArrayList<SitioInteres> h)
    {     
        if(n!=null)
        {
           
            h=AgregarNodoList(n.getHijoIzq(),h);
             h.add(n.getCont());
            h=AgregarNodoList(n.getHijoDer(),h);
        }  
        return h;
    }
    /*Imagenes para cada node del arbol*/
    private  void CargarImagenes()
    {
        imageList[0]=new ImageIcon(getClass().getResource("../Imagen/park1a.png"));//node 1
        imageList[1]=new ImageIcon(getClass().getResource("../Imagen/park2a.png"));//node 2
        imageList[2]=new ImageIcon(getClass().getResource("../Imagen/park3a.png"));//node 3
        imageList[3]=new ImageIcon(getClass().getResource("../Imagen/park4a.png"));//node 4
        imageList[4]=new ImageIcon(getClass().getResource("../Imagen/park5a.png"));//node 5
        imageList[5]=new ImageIcon(getClass().getResource("../Imagen/park6a.png"));//node 6
        imageList[6]=new ImageIcon(getClass().getResource("../Imagen/park7a.png"));//node 7
        imageList[7]=new ImageIcon(getClass().getResource("../Imagen/porteria.png"));//node 8-porteria
        imageList[8]=new ImageIcon(getClass().getResource("../Imagen/park8a.png"));//node 9
        imageList[9]=new ImageIcon(getClass().getResource("../Imagen/park9a.png"));//node 10
        imageList[10]=new ImageIcon(getClass().getResource("../Imagen/park10a.png"));//node 11
        imageList[11]=new ImageIcon(getClass().getResource("../Imagen/park11a.png"));//node 12
        imageList[12]=new ImageIcon(getClass().getResource("../Imagen/park12a.png"));//node 13
        imageList[13]=new ImageIcon(getClass().getResource("../Imagen/park13a.png"));//node 14
        imageList[14]=new ImageIcon(getClass().getResource("../Imagen/park14a.png"));//node 15
    }
   
    /*Construyo el arbol con base a la informacion recolectada
    por el documento info.xml y asigno una imagen para cada sitio de interes 
    tambien con la ubicacion de esta en el jpanel para poderlo pintar */
    private void ConstruirArbol(Arbol tree)
    {
        //node 1
       miAux=new SitioInteres(node.get(0).getAtracMec(), node.get(0).getCentExp(),
                node.get(0).getRest(),node.get(0).getServPubl(), 100, 400);
       miAux.setNameSite("SITIO DE INTERES: LA PAZ"); 
       miAux.setImage(imageList[0]);
      tree.insertar(miAux, 1);
      //node 2
       miAux=new SitioInteres(node.get(1).getAtracMec(), node.get(1).getCentExp(),
                node.get(1).getRest(),node.get(1).getServPubl(), 150, 300);
        miAux.setNameSite("SITIO DE INTERES: LA LUZ ");
       miAux.setImage(imageList[1]);
      tree.insertar(miAux, 2);
      //node 3
      miAux=new SitioInteres(node.get(2).getAtracMec(), node.get(2).getCentExp(),
                node.get(2).getRest(),node.get(2).getServPubl(), 200, 400);
       miAux.setNameSite("SITIO DE INTERES: LAS PALMAS");
      miAux.setImage(imageList[2]);
      tree.insertar(miAux, 3);
       //node 4
      miAux=new SitioInteres(node.get(3).getAtracMec(), node.get(3).getCentExp(),
                node.get(3).getRest(),node.get(3).getServPubl(), 250, 200);
      miAux.setNameSite("SITIO DE INTERES: EL BOSQUE ");
       miAux.setImage(imageList[3]);
      tree.insertar(miAux, 4);
      //node 5
      miAux=new SitioInteres(node.get(4).getAtracMec(), node.get(4).getCentExp(),
                node.get(4).getRest(),node.get(4).getServPubl(), 300, 400);
      miAux.setNameSite("SITIO DE INTERES: LA PILA ");
       miAux.setImage(imageList[4]);
      tree.insertar(miAux, 5);
       //node 6
      miAux=new SitioInteres(node.get(5).getAtracMec(), node.get(5).getCentExp(),
                node.get(5).getRest(),node.get(5).getServPubl(), 350, 300);
      miAux.setNameSite("SITIO DE INTERES: EL PINGüINO");
       miAux.setImage(imageList[5]);
      tree.insertar(miAux, 6);
      //node 7
      miAux=new SitioInteres(node.get(6).getAtracMec(), node.get(6).getCentExp(),
                node.get(6).getRest(),node.get(6).getServPubl(), 400, 400);
      miAux.setNameSite("SITIO DE INTERES: LA TORTUGA");
       miAux.setImage(imageList[6]);
      tree.insertar(miAux, 7);
      //node 8
      miAux=new SitioInteres(null, null,
                null,null, 450, 100);
      miAux.setNameSite("INGRESO A LOS SITIOS DE INTERES");
      miAux.setImage(imageList[7]);
      tree.insertar(miAux, 8);
      //node 9
      miAux=new SitioInteres(node.get(7).getAtracMec(), node.get(7).getCentExp(),
                node.get(7).getRest(),node.get(7).getServPubl(), 500, 400);
      miAux.setNameSite("SITIO DE INTERES: EL CANGREJO");
       miAux.setImage(imageList[8]);
      tree.insertar(miAux, 9);
      //node 10
      miAux=new SitioInteres(node.get(8).getAtracMec(), node.get(8).getCentExp(),
                node.get(8).getRest(),node.get(8).getServPubl(), 550, 300);
      miAux.setNameSite("SITIO DE INTERES: MECANIC ");
       miAux.setImage(imageList[9]);
      tree.insertar(miAux, 10);
      //node 11
      miAux=new SitioInteres(node.get(9).getAtracMec(), node.get(9).getCentExp(),
                node.get(9).getRest(),node.get(9).getServPubl(), 600, 400);
      miAux.setNameSite("SITIO DE INTERES: VERDE ");
       miAux.setImage(imageList[10]);
      tree.insertar(miAux, 11);
       //node 12
      miAux=new SitioInteres(node.get(10).getAtracMec(), node.get(10).getCentExp(),
                node.get(10).getRest(),node.get(10).getServPubl(), 650, 200);
      miAux.setNameSite("SITIO DE INTERES: EL VUELO ");
       miAux.setImage(imageList[11]);
      tree.insertar(miAux, 12);
      //node 13
      miAux=new SitioInteres(node.get(11).getAtracMec(), node.get(11).getCentExp(),
                node.get(11).getRest(),node.get(11).getServPubl(), 700, 400);
      miAux.setNameSite("SITIO DE INTERES: PLANET TIERRA ");
       miAux.setImage(imageList[12]);
      tree.insertar(miAux, 13);
       //node 14
      miAux=new SitioInteres(node.get(12).getAtracMec(), node.get(12).getCentExp(),
                node.get(12).getRest(),node.get(12).getServPubl(), 750, 300);
      miAux.setNameSite("SITIO DE INTERES: DIVERSION PLUSS");
       miAux.setImage(imageList[13]);
      tree.insertar(miAux, 14);
      //node 15
      miAux=new SitioInteres(node.get(13).getAtracMec(), node.get(13).getCentExp(),
                node.get(13).getRest(),node.get(13).getServPubl(), 800, 400);
      miAux.setNameSite("SITIO DE INTERES: THE MAN");
       miAux.setImage(imageList[14]);
      tree.insertar(miAux, 15);
    }

    /*Pinto en el Jpanel todas las imagenes de los sitios de interes
    y el fondo */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g); 
        
        g.drawImage(fond.getImage(), 0, 0, 900, 500, this);
//         NodoArb aux;
//         int auxPos;
//            for (int i = 0; i < listaRamas.size(); i++) 
//            {
//            
//                for (int j = 0; j < listaRamas.get(i).size(); j++) 
//                {
//                    auxPos=j+1;
//                   
//                    
//                    if(auxPos<listaRamas.get(i).size())
//                    {
//                         aux=listaRamas.get(i).get(auxPos);
//                        if(aux!=null)
//                        {g.drawLine(listaRamas.get(i).get(j).getCont().getX()+30, 
//                            listaRamas.get(i).get(j).getCont().getY(), 
//                            aux.getCont().getX()+30, aux.getCont().getY());
//                        }
//                    }   
//                }
//            }
        
        
        
           for (int i = 0; i < lista.size(); i++) 
            {
            g.drawImage(lista.get(i).getImage().getImage(), 
                    lista.get(i).getX(), lista.get(i).getY(), 50, 50, this);
           repaint();
            
             }  
        
           if(bandCostMayor)
           {
               for (int i = 0; i <  ramaMasDinero.getRama().size(); i++)
               {
                   g.drawImage(new ImageIcon(getClass().getResource("../Imagen/pos.png")).getImage(), 
                           ramaMasDinero.getRama().get(i).getCont().getX(), 
                           ramaMasDinero.getRama().get(i).getCont().getY()-10, 
                            50, 60, this);
                   repaint();
               }
           }
           
           if(bandCostMenor)
           {
               for (int i = 0; i < ramaMenosDinero.getRama().size(); i++) 
               {
                   g.drawImage(new ImageIcon(getClass().getResource("../Imagen/posMenor.png")).getImage(),
                           ramaMenosDinero.getRama().get(i).getCont().getX(),
                           ramaMenosDinero.getRama().get(i).getCont().getY()-10,
                           30,40,this);
               }
               repaint();
           
           }
           
           if(bandCostProme)
           {
               for (int i = 0; i <listaPromedios.size(); i++) 
               {
                   for (int j = 0; j < listaPromedios.get(i).getRama().size(); j++) 
                   {
                       g.drawImage(new ImageIcon(getClass().getResource("../Imagen/prom.png")).getImage(),
                               listaPromedios.get(i).getRama().get(j).getCont().getX(), 
                               listaPromedios.get(i).getRama().get(j).getCont().getY(), 
                               30, 40, this);
                   }
                   repaint();
               }
           
           
           }
           
          
         if( pintarCarro)  
         {  for (int i = 0; i < carTwo.length; i++) 
            {
              
                g.drawImage(carTwo[i].getImagPrinc().getImage(), (int)carTwo[i].getPosX(),
                        (int)carTwo[i].getPosY(), 50, 50, this);
                repaint();
            }
            
             for (int i = 0; i < carFour.length; i++) 
             {
                 g.drawImage(carFour[i].getImagPrinc().getImage(),
                         (int)carFour[i].getPosX(), (int)carFour[i].getPosY(),
                         50, 50, this);
                 repaint();
             }
         
         }
         
        repaint();
    }
    /*Modifico el costo y tiempo de cada uno de los sitios de interes*/
    public void CosteTiemTotal(NodoArb h)
    {
        if (h!=null) 
        {
            CosteTiemTotal(h.getHijoIzq());
            h.getCont().setCostoTotal(CostoTotal(h));
            h.getCont().setTiempoTotal(TiempoTotal(h));
            CosteTiemTotal(h.getHijoDer());
            
        } 
    
    }
    /*Calculo el costo total de cada uno de los sitios de interes*/
    private int CostoTotal(NodoArb m)
    {
        int costoTot=0;
        
       if(m.getCont().getAtracMec()!=null)
       {
           for (int i = 0; i < m.getCont().getAtracMec().size(); i++) 
           {
               costoTot+=m.getCont().getAtracMec().get(i).getCosto();
           } 
       }
       if(m.getCont().getCentExp()!=null)
       {
           costoTot+=m.getCont().getCentExp().getCosto();
       }
        if (m.getCont().getRest()!=null) 
        {
            costoTot+=m.getCont().getRest().getCosto();
        }
        if(m.getCont().getServPubl()!=null)
        {
            costoTot+=m.getCont().getServPubl().getCosto();
        }
 
        return costoTot;
    
    }
     /*Calculo el tiempo total de cada uno de los sitios de interes*/
    private int TiempoTotal(NodoArb m)
    {
        int tiempTot=0; 
        
       if(m.getCont().getAtracMec()!=null)
       {
           for (int i = 0; i < m.getCont().getAtracMec().size(); i++) 
           {
               tiempTot+=m.getCont().getAtracMec().get(i).getTiemp();
           } 
       }
       if(m.getCont().getCentExp()!=null)
       {
           tiempTot+=m.getCont().getCentExp().getTiemp();
       }
        if (m.getCont().getRest()!=null) 
        {
            tiempTot+=m.getCont().getRest().getTiemp();
        }
        if(m.getCont().getServPubl()!=null)
        {
            tiempTot+=m.getCont().getServPubl().getTiemp();
        }
 
        return tiempTot;
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(98, 248, 198));
        setPreferredSize(new java.awt.Dimension(900, 500));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        System.out.println("x "+evt.getX()+" y "+evt.getY());
       
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
//              System.out.println("/*___________________________*/");
//             if(n.getCont().getAtracMec()!=null)
//             {  System.out.println(""+n.getCont().getNameSite());
//                 System.out.println("Atracciones");
//                 for (int i = 0; i < n.getCont().getAtracMec().size(); i++) 
//                 {
//                     System.out.println(""+n.getCont().getAtracMec().get(i).getNomb());
//                     System.out.println("C "+n.getCont().getAtracMec().get(i).getCosto());
//                     System.out.println("T"+n.getCont().getAtracMec().get(i).getTiemp());
//                 }
//                 System.out.println("----------------");
//             }
//             if (n.getCont().getCentExp()!=null) 
//             { System.out.println("Centro de Exposicion");
//                 System.out.println(""+n.getCont().getCentExp().getNomb());
//                  System.out.println("C "+n.getCont().getCentExp().getCosto());
//                   System.out.println("T "+n.getCont().getCentExp().getNomb());
//            }
//             
//             if(n.getCont().getRest()!=null)
//             {
//                 System.out.println("Restaurante");
//                 System.out.println(""+n.getCont().getRest().getNomb());
//                 System.out.println("C "+n.getCont().getRest().getCosto());
//                 System.out.println("T "+n.getCont().getRest().getTiemp());
//             }
//             if (n.getCont().getServPubl()!=null) 
//             {      System.out.println("Servicio publico");
//                 System.out.println(""+n.getCont().getServPubl().getNomb());
//                 System.out.println("C "+n.getCont().getServPubl().getCosto());
//                 System.out.println("T "+n.getCont().getServPubl().getTiemp());
//            }
//             System.out.println("/*___________________________*/");
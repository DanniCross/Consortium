package Datos;

import Arbol.ListaRama;
import Arbol.NodoArb;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CarroDos implements Runnable
{
    private int numPasaj;
    private ImageIcon[] imagCarro;
    private ImageIcon imagPrinc;
    private float posX;
    private float posY;
    private int timeUser;
    private int timeRec;
    private ListaRama recorre;
    private boolean bandArranq;
    
    public CarroDos() 
    {
        imagCarro= new ImageIcon[2];
        imagCarro[0]=new ImageIcon(getClass().getResource("../Imagen/vagonDosDer.png"));
        imagCarro[1]=new ImageIcon(getClass().getResource("../Imagen/vagonDosIzq.png"));
        imagPrinc= new ImageIcon(getClass().getResource("../Imagen/vagonDos.png")); 
        this.posX=0;
        this.posY=0;
    }

    public CarroDos(ListaRama recorrido, int time)
    {
        this.recorre=recorrido;
        this.timeUser=time;
        imagCarro= new ImageIcon[2];
        imagCarro[0]=new ImageIcon(getClass().getResource("../Imagen/vagonDosDer.png"));
        imagCarro[1]=new ImageIcon(getClass().getResource("../Imagen/vagonDosIzq.png"));
        imagPrinc= new ImageIcon(getClass().getResource("../Imagen/vagonDos.png")); 
        
        this.posX=recorrido.getRama().get(0).getCont().getX();
        this.posY=recorrido.getRama().get(0).getCont().getY();
        this.bandArranq=true;
    }

    public ImageIcon getImagPrinc() {
        return imagPrinc;
    }

    public void setImagPrinc(ImageIcon imagPrinc) {
        this.imagPrinc = imagPrinc;
    }

    public int getTimeRec() {
        return timeRec;
    }

    public boolean isBandArranq() {
        return bandArranq;
    }

    public void setBandArranq(boolean bandArranq) {
        this.bandArranq = bandArranq;
    }
    

    public void setTimeRec(int timeRec) {
        this.timeRec = timeRec;
    }
    
    public int getTimeUser() {
        return timeUser;
    }
    
    public void setTimeUser(int timeUser) {
        this.timeUser = timeUser;
    }
 
    public ListaRama getRecorre() {
        return recorre;
    }

    public void setRecorre(ListaRama recorre) {
        this.recorre = recorre;
    }
    
    
    
    public ImageIcon[] getImagCarro() {
        return imagCarro;
    }

    public void setImagCarro(ImageIcon[] imagCarro) {
        this.imagCarro = imagCarro;
    }

   

    public float getPosX() {
        return posX;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public float getPosY() {
        return posY;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public CarroDos(int numPasaj) 
    {
        this.numPasaj = numPasaj;
    }

    public int getNumPasaj() {
        return numPasaj;
    }

    public void setNumPasaj(int numPasaj) {
        this.numPasaj = numPasaj;
    }

    @Override
    public void run() 
    {
        float pend;
        float y,x;
        NodoArb aux;
        int pos;
        
        
        if(this.bandArranq)
        {
            for (int i = 0; i < this.recorre.getRama().size(); i++) 
            {
                pos=i+1;
              if(pos<this.recorre.getRama().size())
              {  
                aux=this.recorre.getRama().get(pos); 
                
                if(aux!=null)
                {
                     
                    if(this.recorre.getRama().get(i).getCont().getX()>aux.getCont().getX())
                    {
                       
                        this.imagPrinc=this.imagCarro[1];
                        y=(this.recorre.getRama().get(i).getCont().getY()-aux.getCont().getY());
                        x=(this.recorre.getRama().get(i).getCont().getX()-aux.getCont().getX());
                        pend=y/x;
                 
                     while(this.posX>=aux.getCont().getX())
                        {
                            try {
                            
                            //yInic=this.recorre.getRama().get(i).getCont().getY();
                            
                            this.posX--;
                            this.posY=(pend*this.posX)-(pend*aux.getCont().getX())+aux.getCont().getY();
                            
                                sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CarroDos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        
                        }
                    
                        if (aux.getCont().getTiempoTotal()<15) 
                        {
                            try {
                                sleep(2000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CarroDos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }else if(aux.getCont().getTiempoTotal()>15&&aux.getCont().getTiempoTotal()<=30)
                        {
                            
                            try {
                                sleep(3000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CarroDos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                                            
                    }else
                    {
                    //
                    
                       
                        this.imagPrinc=this.imagCarro[0];
                        y=(this.recorre.getRama().get(i).getCont().getY()-aux.getCont().getY());
                        x=(this.recorre.getRama().get(i).getCont().getX()-aux.getCont().getX());
                        pend=y/x;
                 
                     while(this.posX<=aux.getCont().getX())
                        {
                            try {
                            
                         
                            
                            this.posX++;
                            this.posY=(pend*this.posX)-(pend*aux.getCont().getX())+aux.getCont().getY();
                            
                                sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CarroDos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        
                        }
                    
                        if (aux.getCont().getTiempoTotal()<15) 
                        {
                            try {
                                sleep(1500);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CarroDos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }else if(aux.getCont().getTiempoTotal()>15&&aux.getCont().getTiempoTotal()<=30)
                        {
                            
                            try {
                                sleep(3000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CarroDos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        }
                    }
                  }
                }
                     
              }
                
                this.imagPrinc= new ImageIcon(getClass().getResource("../Imagen/vagonDos.png")); 
                JOptionPane.showMessageDialog(null, "Has realizado tu recorrido:\n"+"Te esperamos de nuevo",
                        "RECORRIDO TERMINADO",1);
                
               ////////////////////////////
               for (int i = this.recorre.getRama().size()-1; i >=0; i--) 
            {
                pos=i-1;
              if(pos>=0)
              {  
                aux=this.recorre.getRama().get(pos); 
                
                if(aux!=null)
                {
                     
                    if(this.recorre.getRama().get(i).getCont().getX()>aux.getCont().getX())
                    {
                       
                        this.imagPrinc=this.imagCarro[0];
                        y=(this.recorre.getRama().get(i).getCont().getY()-aux.getCont().getY());
                        x=(this.recorre.getRama().get(i).getCont().getX()-aux.getCont().getX());
                        pend=y/x;
                 
                     while(this.posX>=aux.getCont().getX())
                        {
                            try {
  
                            this.posX--;
                            this.posY=(pend*this.posX)-(pend*aux.getCont().getX())+aux.getCont().getY();
                            
                                sleep(80);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CarroDos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        
                        }
                                            
                    }else
                    {

                        this.imagPrinc=this.imagCarro[1];
                        y=(this.recorre.getRama().get(i).getCont().getY()-aux.getCont().getY());
                        x=(this.recorre.getRama().get(i).getCont().getX()-aux.getCont().getX());
                        pend=y/x;
                 
                     while(this.posX<=aux.getCont().getX())
                        {
                            try {
                            
                         
                            
                            this.posX++;
                            this.posY=(pend*this.posX)-(pend*aux.getCont().getX())+aux.getCont().getY();
                            
                                sleep(80);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(CarroDos.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        
                        
                        }
                   
                    }
                  }
                }
                     
              }
               this.imagPrinc= new ImageIcon(getClass().getResource("../Imagen/vagonDos.png")); 
           
            }
        }
        
        
        
        
        
    }
    
    
    


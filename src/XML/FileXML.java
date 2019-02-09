package XML;

import Datos.AtraccionMec;
import Datos.CentroExp;
import Datos.Restaurante;
import Datos.ServicioPublic;
import Datos.SitioInteres;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileXML 
{
   File xmlFile;
   DocumentBuilderFactory factory;
   DocumentBuilder builder;
   Document doc;

    public FileXML(){
    }
   
   
   public void makeFileXML() throws SAXException, IOException
   {
       try {
           xmlFile= new File("/home/josec/Documentos/Netbeans Projects/info.xml");
           factory=DocumentBuilderFactory.newInstance();
           builder=factory.newDocumentBuilder();
           doc=builder.parse(xmlFile);
           int z=0;
           
       } catch (ParserConfigurationException ex) 
       {
           Logger.getLogger(FileXML.class.getName()).log(Level.SEVERE, null, ex);
       }catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, e,"Crear archivo XML", 0);
       }
   }
   
   
   
   
   public void VerDatoXML()
   {
   ArrayList<AtraccionMec> atracMec;
   NodeList cab=doc.getElementsByTagName("sitio");
  
       for (int i = 0; i < cab.getLength(); i++) 
       {  
           Node a=cab.item(i);
           
           if (a.getNodeType()==Node.ELEMENT_NODE) 
           {   
               
               //sitios
               NodeList b=a.getChildNodes();
               
               for (int j = 0; j <b.getLength() ; j++) 
               {   
                   Node c=b.item(j);
                   
                   if (c.getNodeType()==Node.ELEMENT_NODE) 
                   {    //Sitio--> atracciones-restaurantes-serviciosPublicos
                     
                       NodeList d=c.getChildNodes();
                       for (int k = 0; k < d.getLength(); k++) 
                       {
                           
                           Node e=d.item(k);
                           if (e.getNodeType()==Node.ELEMENT_NODE)
                           {
                              //atracciones-restaurantes-serviciosPublicos
                             
                              NodeList m=c.getChildNodes();
                               for (int l = 0; l < m.getLength(); l++) 
                               {
                                   Node y=m.item(l);
                                   
                                   if (y.getNodeType()==Node.ELEMENT_NODE) 
                                   {    
                                    System.out.println(""+" "+y.getTextContent());
                                   }
                               }
                           }
                       }
                   }
               }
           }
       }
   }
   
   public ArrayList<SitioInteres> ArrayConsorcio() 
   {
       ArrayList<AtraccionMec> miAtrac= new ArrayList<>();
       ArrayList<AtraccionMec> auxAtrac= new ArrayList<>();
       AtraccionMec v;
       Restaurante rest=new Restaurante();
       ServicioPublic servic= new ServicioPublic();
       CentroExp centro=new CentroExp();
       SitioInteres sitioInt= new SitioInteres();
       
       ArrayList<SitioInteres> nodes=new ArrayList<>();
       
       String atracName, restName, servName, centName;
       int atracTime, atracCoste, restTime, restCoste, servTime, servCoste, centTime, centCoste;
       
        NodeList cab=doc.getElementsByTagName("consorcio");
        Node aA= cab.item(0);
        Element a1= (Element) aA;
        NodeList cabA=a1.getElementsByTagName("sitio");
        
        for(int x=0; x<cabA.getLength(); x++)
        { 
            atracName=restName=servName=centName="";
            atracTime=atracCoste=restTime=restCoste=servTime=servCoste=centTime=centCoste=0;
            Node bA=cabA.item(x);
   
            Element a2=(Element) bA;//-------->
            if(bA!=null)
            { 

                  NodeList cabCE=a2.getElementsByTagName("centExps");
                Node CEa=cabCE.item(0);
                Element CEuno=(Element)CEa;

                NodeList cabSCE=CEuno.getElementsByTagName("centExp");
                Node CEaux=cabSCE.item(0);
                Element CE1=(Element)CEaux;


                if(CEaux!=null)
                {
                    NodeList cabCE1=CE1.getElementsByTagName("nombre");
                    Node CEa1=cabCE1.item(0);

                    NodeList cabCE2=CE1.getElementsByTagName("tiempo");
                    Node CEa2=cabCE2.item(0);

                    NodeList cabCE3=CE1.getElementsByTagName("costo");
                    Node CEa3=cabCE3.item(0);

                    if(CEa1!=null && CEa2!=null && CEa3!=null)
                    {
                        centName=CEa1.getTextContent();
                        centTime=Integer.parseInt(CEa2.getTextContent());
                        centCoste=Integer.parseInt(CEa3.getTextContent());
                        
                        centro=new CentroExp(1,centName, centCoste, centTime);
                    }else
                    {
                        centro=null;
                    }
                }
             ////////////////////////////////  
            NodeList cabB=a2.getElementsByTagName("atracciones");     
            Node cA=cabB.item(0);
            Element a3=(Element)cA;  
            NodeList cabC=a3.getElementsByTagName("atraccion");

            for(int i=0; i<cabC.getLength(); i++)
            {
                Node dA=cabC.item(i);
                Element a4=(Element)dA;
                    if(dA!=null)
                    { 
                        NodeList cabD=a4.getElementsByTagName("nombre");
                        Node eA1=cabD.item(0);

                        NodeList cabE=a4.getElementsByTagName("tiempo");
                        Node eA2=cabE.item(0);

                        NodeList cabF=a4.getElementsByTagName("costo");
                        Node eA3=cabF.item(0);

                         if(eA1!=null && eA2!=null &&eA3!=null)
                           {
                            atracName=eA1.getTextContent();
                            atracTime=Integer.parseInt(eA2.getTextContent());
                            atracCoste=Integer.parseInt(eA3.getTextContent());

                             v= new AtraccionMec(i,eA1.getTextContent(),
                                                Integer.parseInt(eA3.getTextContent()),
                                                Integer.parseInt(eA2.getTextContent()));
                                miAtrac.add(v);
                                auxAtrac=(ArrayList<AtraccionMec>) miAtrac.clone();
                           }else
                         {
                             auxAtrac=null;
                         }

                    }

                }
                
                ///////////////////////////////////////////////////////777
                NodeList cabR=a2.getElementsByTagName("restaurantes"); 
                Node RA=cabR.item(0);
                Element Runo=(Element) RA;

                NodeList cabRSec=Runo.getElementsByTagName("restaurante");
                Node RAux=cabRSec.item(0);
                Element R1=(Element)RAux;
                if(RAux!=null)
                { 
                    NodeList cabR1=R1.getElementsByTagName("nombre");
                    Node RAa=cabR1.item(0);

                    NodeList cabR2=R1.getElementsByTagName("tiempo");
                    Node RAb=cabR2.item(0);

                    NodeList cabR3=R1.getElementsByTagName("costo");
                    Node RAc=cabR3.item(0);

                    if(RAa!=null && RAb!=null && RAc!=null)
                    {
                        restName=RAa.getTextContent();
                        restTime=Integer.parseInt(RAb.getTextContent());
                        restCoste=Integer.parseInt(RAc.getTextContent());

                        rest= new Restaurante(1,restName, restCoste, restTime);
                    }

                }
              

                
                NodeList cabS=a2.getElementsByTagName("serviciosPublicos"); 
                Node SA=cabS.item(0);
                Element Suno=(Element) SA;
                
                NodeList cabSSec=Suno.getElementsByTagName("servicioPublico");
                Node SAux=cabSSec.item(0);
                Element S1=(Element)SAux;
                    if(SAux!=null)
                    {
                        NodeList cabS1=S1.getElementsByTagName("nombre");
                        Node SAa=cabS1.item(0);

                        NodeList cabS2=S1.getElementsByTagName("tiempo");
                        Node SAb=cabS2.item(0);

                        NodeList cabS3=S1.getElementsByTagName("costo");
                        Node SAc=cabS3.item(0);

                        if(SAa!=null && SAb!=null && SAc!=null)
                        {
                            servName=SAa.getTextContent();
                            servTime=Integer.parseInt(SAb.getTextContent());
                            servCoste=Integer.parseInt(SAc.getTextContent());

                            servic= new ServicioPublic(1, servName, servCoste, servTime);
                        }

                    }


            
            
          }
            
          sitioInt= new SitioInteres(auxAtrac,centro,rest,servic,0,0);
            nodes.add(sitioInt);
           // miAtrac.clone();
            miAtrac.clear();
            centro=null;
            rest=null;
            servic=null;  
        }
//        for(int r=0; r<miAtrac.size(); r++)
//        {
//            System.out.println(""+miAtrac.get(r).getNomb());
//            System.out.println(""+miAtrac.get(r).getCosto());
//            System.out.println("--------------------");
//        }
    return nodes;
   }
}

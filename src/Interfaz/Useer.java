package Interfaz;

import Arbol.ListaRama;
import Arbol.NodoArb;
import Datos.CarroCuat;
import Datos.CarroDos;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Useer extends javax.swing.JFrame {

    int buttonCosteMay=1;
    int buttonCosteMen=1;
    int buttonCosteProm=1;
    int time, cantPas,tempUno,tempDos=0;
    ListaRama rutaUser,ramaUser=new ListaRama();
    Thread hiloCarro=new Thread();
    boolean bandRecorrido=false;
    String inforRuta="";
    
    public Useer() {
       
        initComponents();
      nodeInf.setVisible(false); 
      this.contenerdoRutaFin.setVisible(false);
      this.setLocation(10, 10);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        timeDisp = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        masDinero = new javax.swing.JRadioButton();
        menosDinero = new javax.swing.JRadioButton();
        gastoPromedio = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        cantPers = new javax.swing.JFormattedTextField();
        iniciar = new javax.swing.JButton();
        reiniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        costeRamaMay = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        opcionRuta = new javax.swing.JComboBox<>();
        recorridoPers = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cantPasajeros1 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        try {
            paint1 = new Interfaz.Paint();
        } catch (org.xml.sax.SAXException e1) {
            e1.printStackTrace();
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
        }
        nodeInf = new javax.swing.JPanel();
        photo = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inf = new javax.swing.JTextArea();
        TiemTot = new javax.swing.JLabel();
        costeTot = new javax.swing.JLabel();
        contenerdoRutaFin = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        recorridoFin = new javax.swing.JTextArea();
        exitInf = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("CONSORCIO: SITIOS DE INTERES"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Tiempo disponible");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 137, -1, -1));

        timeDisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeDispActionPerformed(evt);
            }
        });
        jPanel1.add(timeDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 136, 141, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Recorrido a realizar:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 220, -1, -1));

        masDinero.setText("Gasto más dinero");
        masDinero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(masDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 214, -1, -1));

        menosDinero.setText("Gasto menos dinero");
        menosDinero.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(menosDinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 239, -1, -1));

        gastoPromedio.setText("Gasto promedio");
        gastoPromedio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(gastoPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 262, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Cantidad de pasajeros");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));
        jPanel1.add(cantPers, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 120, -1));

        iniciar.setBackground(new java.awt.Color(103, 189, 146));
        iniciar.setText("Iniciar Recorrido");
        iniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });
        jPanel1.add(iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 57));

        reiniciar.setBackground(new java.awt.Color(153, 255, 204));
        reiniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/Restart.png"))); // NOI18N
        reiniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });
        jPanel1.add(reiniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 101, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/userDos.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 13, 100, 87));

        costeRamaMay.setBackground(new java.awt.Color(102, 255, 102));
        costeRamaMay.setText("Ruta más cara");
        costeRamaMay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        costeRamaMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costeRamaMayActionPerformed(evt);
            }
        });
        jPanel1.add(costeRamaMay, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 140, 44));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setText("Rutas costo promedio");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 140, 44));

        jButton1.setBackground(new java.awt.Color(102, 51, 255));
        jButton1.setText("Ruta menos costosa");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 140, 44));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 371, 472, 10));

        opcionRuta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01. LA PAZ", "02. LA LUZ", "03. LAS PALMAS", "04. EL BOSQUE", "05. LA PILA", "06. EL PIGüINO", "07. LA TORTUGA", "08. PORTERIA", "09. EL CANGREJO", "10. MECANIC", "11. VERDE", "12. ELVUELO", "13. PLANET TIERRA", "14. DIVERSION PLUSS", "15. THE MAN" }));
        jPanel1.add(opcionRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        recorridoPers.setBackground(new java.awt.Color(204, 204, 255));
        recorridoPers.setText("Recorrido Personal");
        recorridoPers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recorridoPersActionPerformed(evt);
            }
        });
        jPanel1.add(recorridoPers, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, 50));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Realizar recorrido personal");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Cantidad de pasajeros");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 175, -1, -1));
        jPanel1.add(cantPasajeros1, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 174, 141, -1));

        jLabel7.setFont(new java.awt.Font("Bodoni MT Black", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("Consorcio Las Palmas");

        paint1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paint1MousePressed(evt);
            }
        });

        nodeInf.setBackground(new java.awt.Color(153, 255, 102));
        nodeInf.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        title.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        title.setForeground(new java.awt.Color(51, 51, 255));
        title.setText("INFORMACION");

        inf.setEditable(false);
        inf.setBackground(new java.awt.Color(204, 204, 255));
        inf.setColumns(20);
        inf.setRows(5);
        jScrollPane1.setViewportView(inf);

        TiemTot.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        TiemTot.setForeground(new java.awt.Color(0, 102, 102));
        TiemTot.setText("tiemTotal");

        costeTot.setFont(new java.awt.Font("Calibri", 3, 14)); // NOI18N
        costeTot.setForeground(new java.awt.Color(0, 102, 102));
        costeTot.setText("costeTot");

        javax.swing.GroupLayout nodeInfLayout = new javax.swing.GroupLayout(nodeInf);
        nodeInf.setLayout(nodeInfLayout);
        nodeInfLayout.setHorizontalGroup(
            nodeInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nodeInfLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(nodeInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nodeInfLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(nodeInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(costeTot)
                            .addComponent(TiemTot)
                            .addGroup(nodeInfLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(title)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nodeInfLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        nodeInfLayout.setVerticalGroup(
            nodeInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nodeInfLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(nodeInfLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(nodeInfLayout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TiemTot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costeTot))
        );

        contenerdoRutaFin.setBackground(new java.awt.Color(73, 219, 146));
        contenerdoRutaFin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        contenerdoRutaFin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("LISTADO LUGARES A VISITAR EN EL RECORRIDO");
        contenerdoRutaFin.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 14, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/people.png"))); // NOI18N
        contenerdoRutaFin.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 37, -1, -1));

        recorridoFin.setEditable(false);
        recorridoFin.setBackground(new java.awt.Color(204, 204, 255));
        recorridoFin.setColumns(20);
        recorridoFin.setRows(5);
        jScrollPane2.setViewportView(recorridoFin);

        contenerdoRutaFin.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 245, 86));

        exitInf.setText("Cerrar");
        exitInf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitInfActionPerformed(evt);
            }
        });
        contenerdoRutaFin.add(exitInf, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        javax.swing.GroupLayout paint1Layout = new javax.swing.GroupLayout(paint1);
        paint1.setLayout(paint1Layout);
        paint1Layout.setHorizontalGroup(
            paint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paint1Layout.createSequentialGroup()
                .addComponent(nodeInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                .addComponent(contenerdoRutaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        paint1Layout.setVerticalGroup(
            paint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paint1Layout.createSequentialGroup()
                .addGroup(paint1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nodeInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contenerdoRutaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 298, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(paint1);

        jLabel8.setText("Estudiante: Leonardo González Gutierrez / Estructura de Datos III Semestre/ Prog: Ing. Sistemas y Computación ");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagen/ucaldas.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel7))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paint1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paint1MousePressed
        
        String information="";
                for (int i = 0; i < paint1.lista.size(); i++)
                {
                    if((evt.getX()>=paint1.lista.get(7).getX() && evt.getX()<=paint1.lista.get(7).getX()+50) && 
                            (evt.getY()>=paint1.lista.get(7).getY() && 
                            evt.getY()<=paint1.lista.get(7).getY()+50))
                    {

                    information+="BIENVENIDO A NUESTRO CONSORCIO"+"\n";
                    information+="Diviertete al máximo!!"+"\n";
                    photo.setIcon(paint1.lista.get(7).getImage());
                    inf.setText(information);
                    title.setText(paint1.lista.get(7).getNameSite());
                     TiemTot.setText(" ");
                     costeTot.setText(" ");
                    nodeInf.setVisible(true);
                    break;
                    }else if((evt.getX()>=paint1.lista.get(i).getX() && evt.getX()<=(paint1.lista.get(i).getX()+50))
                                    &&(evt.getY()>=paint1.lista.get(i).getY() && 
                                    evt.getY()<=(paint1.lista.get(i).getY()+50)))
                    {
                        
                       // System.out.println("eyyyyyyy "+paint1.lista.get(i).getNameSite());
                        if(!paint1.lista.get(i).getNameSite().equals("INGRESO A LOS SITIOS DE INTERES"))
                        {
                        photo.setIcon(paint1.lista.get(i).getImage());
                        title.setText(paint1.lista.get(i).getNameSite());
                        
                           if(paint1.lista.get(i).getAtracMec()!=null)
                           {    information+="ATRACCIONES: "+"\n";
                               for (int j = 0; j < paint1.lista.get(i).getAtracMec().size(); j++) 
                            {
                                if(paint1.lista.get(i).getAtracMec().get(j)!=null)
                                {    
                                    information+=""+paint1.lista.get(i).getAtracMec().get(j).getNomb()+"\n";
                                    information+="Costo: "+paint1.lista.get(i).getAtracMec().get(j).getCosto()+"\n";
                                    information+="Tiempo: "+paint1.lista.get(i).getAtracMec().get(j).getTiemp()+"\n";
                                }
                                information+="\n";
                            }
                           }
                           if(paint1.lista.get(i).getCentExp()!=null)
                           {    
                               information+="CENTRO DE INTERES: "+"\n";
                               information+="Nombre: "+paint1.lista.get(i).getCentExp().getNomb()+"\n";
                               information+="Costo: "+paint1.lista.get(i).getCentExp().getCosto()+"\n";
                               information+="Tiempo: "+paint1.lista.get(i).getCentExp().getTiemp()+"\n";
                               information+="\n";
                           }
                           if(paint1.lista.get(i).getRest()!=null)
                           {
                               information+="RESTAURANTE: "+"\n";
                               information+="Nombre: "+paint1.lista.get(i).getRest().getNomb()+"\n";
                               information+="Costo: "+paint1.lista.get(i).getRest().getCosto()+"\n";
                               information+="Tiempo: "+paint1.lista.get(i).getRest().getTiemp()+"\n";
                               information+="\n";
                           }
                           
                           if(paint1.lista.get(i).getServPubl()!=null)
                           {
                               information+="SERVICIO PUBLICO: "+ "\n";
                               information+="Nombre: "+paint1.lista.get(i).getServPubl().getNomb()+"\n";
                               information+="Costo: "+paint1.lista.get(i).getServPubl().getCosto()+"\n";
                               information+="Tiempo: "+paint1.lista.get(i).getServPubl().getTiemp()+"\n";
                               information+="\n";
                           }
                            inf.setText(information); 
                            TiemTot.setText("Tiempo total: "+paint1.lista.get(i).getTiempoTotal());
                            costeTot.setText("Costo total: "+paint1.lista.get(i).getCostoTotal());
                            nodeInf.setVisible(true);
                            information="";
                        break;
                         
                        }
                    }else
                    {
                     nodeInf.setVisible(false);
                     information="";
                       inf.setText(information); 
                    }
                
                
                
           
            }
            
    }//GEN-LAST:event_paint1MousePressed

    private void costeRamaMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costeRamaMayActionPerformed
       if(buttonCosteMay!=0)
       {
        paint1.bandCostMayor=true;
        buttonCosteMay=0;
       }else
       {
         paint1.bandCostMayor=false;  
         buttonCosteMay=1;
       }
       
    }//GEN-LAST:event_costeRamaMayActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(buttonCosteMen!=0)
        {
            paint1.bandCostMenor=true;
            buttonCosteMen=0;
        }else
        {
            paint1.bandCostMenor=false;
            buttonCosteMen=1;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if(buttonCosteProm!=0)
        {
            paint1.bandCostProme=true;
            buttonCosteProm=0;
        }else
        {
            paint1.bandCostProme=false;
            buttonCosteProm=1;
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void timeDispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeDispActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeDispActionPerformed

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
      //extraigo todos los datos ingresados por el usuario para realizar las debidas operaciones
        try{
        
            time=Integer.parseInt(timeDisp.getText());
            cantPas=Integer.parseInt(cantPasajeros1.getText());
            if(1<=cantPas && cantPas<=4)
            {
                paint1.tiemUser=time;
                paint1.pasUser=cantPas;
            
                if((masDinero.isSelected()&& !menosDinero.isSelected()&& !gastoPromedio.isSelected())||
                        (!masDinero.isSelected()&& menosDinero.isSelected()&& !gastoPromedio.isSelected())||
                        (!masDinero.isSelected()&& !menosDinero.isSelected()&& gastoPromedio.isSelected()))
                {
                    if(masDinero.isSelected()&& time>=paint1.masDinero.getRama().get(1).getCont().getTiempoTotal())
                    {
                        ramaUser=paint1.masDinero;
                        bandRecorrido=true;
                    }else if(menosDinero.isSelected()&& time>=paint1.ramaMenosDinero.getRama().get(1).getCont().getTiempoTotal())
                    {
                        ramaUser=paint1.ramaMenosDinero;
                        bandRecorrido=true;
                    }else if(gastoPromedio.isSelected()&& time>=paint1.gastoPromedio.getRama().get(1).getCont().getTiempoTotal())
                    {
                        ramaUser=paint1.gastoPromedio; 
                        bandRecorrido=true;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"El tiempo que dispone no alcanza para realizar \n"
                                + "la visita al Sitio de Interes","INFORMACION",0);
                    }
                    
                    

                    
                    if(bandRecorrido)
                    {
                    rutaUser=paint1.RecorridoFinalUser(ramaUser,time);
                    this.contenerdoRutaFin.setVisible(true);
                    for (int i = 0; i < rutaUser.getRama().size(); i++) 
                    {
                        inforRuta+=""+rutaUser.getRama().get(i).getCont().getNameSite()+"\n";
                    }
                    
                    this.recorridoFin.setText(inforRuta);
                    if(cantPas==1 || cantPas==2)
                    {
                        if(tempUno<paint1.carTwo.length)
                        {
                            paint1.carTwo[tempUno]= new CarroDos(rutaUser,time);
                            hiloCarro= new Thread(paint1.carTwo[tempUno]);
                            hiloCarro.start();
                            tempUno++;
                        }else
                        {
                        JOptionPane.showMessageDialog(null,"Señor(a) usuario(a) en este momento son se encuentran \n"+
                                "disponibles autos para capacidad de 1 a 2 personas", "AUTO 1-2 PASAJEROS", 0);
                        }

                    }else if(cantPas==3 || cantPas==4)
                    {
                        if(tempDos<paint1.carFour.length)
                        {
                            paint1.carFour[tempDos]=new CarroCuat(rutaUser, time);
                            hiloCarro=new Thread(paint1.carFour[tempDos]);
                            hiloCarro.start();
                            tempDos++;
                        }else
                        {
                        JOptionPane.showMessageDialog(null,"Señor(a) usuario(a) en este momento son se encuentran \n"+
                                "disponibles autos para capacidad de 3 a 4 personas", "AUTO 1-2 PASAJEROS", 0);
                        }
                    }
                   }
                }else
                {
                JOptionPane.showMessageDialog(null,"NO ES PERMITIDO SELECCIONAR \n MAS DE UNA OPCION","Rutas",1);
                }
            }else 
            {
                JOptionPane.showMessageDialog(null, "Señor(a) usuario no se permite \n mas de 4 pasajeros, vuelva a ingresar el número de pasajeros",
                                               "Número de pasajeros no permitido",0);
            
            }
            
        
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e+"\n"+"!! Por favor ingrese bien los datos !!", "Error usuario", 2);
            
        }
    }//GEN-LAST:event_iniciarActionPerformed

    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
      
        cantPasajeros1.setText("");
        this.timeDisp.setText("");
        this.cantPers.setText("");
        paint1.AsignarPosicionCar();
         tempUno=0;
         tempDos=0;
        this.contenerdoRutaFin.setVisible(false);
        this.recorridoFin.setText("");
    }//GEN-LAST:event_reiniciarActionPerformed

    private void exitInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitInfActionPerformed
       this.contenerdoRutaFin.setVisible(false);
    }//GEN-LAST:event_exitInfActionPerformed

    private void recorridoPersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recorridoPersActionPerformed
       
       try{
        String rutaBuscar= opcionRuta.getSelectedItem().toString();
       String datoUno=(""+rutaBuscar.charAt(0));
       String datoDos=(""+rutaBuscar.charAt(1));
       int numFin=Integer.parseInt(datoUno+datoDos);
       
        System.out.println(""+numFin);
        
       ListaRama rutaPersonal=RutaPersonal(numFin);
       int pasajPriva=Integer.parseInt(cantPers.getText());   

       
                    rutaUser=paint1.RecorridoFinalUser(rutaPersonal,1000);
                    this.contenerdoRutaFin.setVisible(true);
                    for (int i = 0; i < rutaUser.getRama().size(); i++) 
                    {
                        inforRuta+=""+rutaUser.getRama().get(i).getCont().getNameSite()+"\n";
                    }
                    
                    this.recorridoFin.setText(inforRuta);
                    if(pasajPriva==1 || pasajPriva==2)
                    {
                        if(tempUno<paint1.carTwo.length)
                        {
                            paint1.carTwo[tempUno]= new CarroDos(rutaUser,time);
                            hiloCarro= new Thread(paint1.carTwo[tempUno]);
                            hiloCarro.start();
                            tempUno++;
                        }else
                        {
                        JOptionPane.showMessageDialog(null,"Señor(a) usuario(a) en este momento son se encuentran \n"+
                                "disponibles autos para capacidad de 1 a 2 personas", "AUTO 1-2 PASAJEROS", 0);
                        }

                    }else if(pasajPriva==3 || pasajPriva==4)
                    {
                        if(tempDos<paint1.carFour.length)
                        {
                            paint1.carFour[tempDos]=new CarroCuat(rutaUser, time);
                            hiloCarro=new Thread(paint1.carFour[tempDos]);
                            hiloCarro.start();
                            tempDos++;
                        }else
                        {
                        JOptionPane.showMessageDialog(null,"Señor(a) usuario(a) en este momento son se encuentran \n"+
                                "disponibles autos para capacidad de 3 a 4 personas", "AUTO 1-2 PASAJEROS", 0);
                        }
                    }
       }catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e+"\n"+"!! Por favor ingrese bien los datos !!", "Error usuario", 2);
       }
    }//GEN-LAST:event_recorridoPersActionPerformed

    public  ListaRama RutaPersonal(int sitio)
    {
        ListaRama temp=new ListaRama();
        ArrayList<NodoArb> lugares=new ArrayList<NodoArb>();
        ArrayList<NodoArb> pasar=new ArrayList<NodoArb>();
        boolean avanc=false;
        
        for (int i = 0; i < paint1.rutaPosible.size()&&!avanc; i++) 
        {
            for (int j = 0; j < paint1.rutaPosible.get(i).size()&&!avanc; j++) 
            {
                lugares.add(paint1.rutaPosible.get(i).get(j));
                if (paint1.rutaPosible.get(i).get(j).getDato()==sitio) 
                {
                    pasar= (ArrayList<NodoArb>) lugares.clone();
                    avanc=true;      
                }

            }
              lugares.clear(); 
        }
    
        int costTotal=0;
        for (int i = 0; i < pasar.size(); i++) 
        {
            costTotal+=pasar.get(i).getCostTotal();
        }
        
        temp=new ListaRama(pasar,costTotal);
       return  temp;
    
        
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Useer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Useer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Useer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Useer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Useer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TiemTot;
    private javax.swing.JFormattedTextField cantPasajeros1;
    private javax.swing.JFormattedTextField cantPers;
    private javax.swing.JPanel contenerdoRutaFin;
    private javax.swing.JButton costeRamaMay;
    private javax.swing.JLabel costeTot;
    private javax.swing.JButton exitInf;
    private javax.swing.JRadioButton gastoPromedio;
    private javax.swing.JTextArea inf;
    private javax.swing.JButton iniciar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton masDinero;
    private javax.swing.JRadioButton menosDinero;
    private javax.swing.JPanel nodeInf;
    private javax.swing.JComboBox<String> opcionRuta;
    private Interfaz.Paint paint1;
    private javax.swing.JLabel photo;
    private javax.swing.JTextArea recorridoFin;
    private javax.swing.JButton recorridoPers;
    private javax.swing.JButton reiniciar;
    private javax.swing.JFormattedTextField timeDisp;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}

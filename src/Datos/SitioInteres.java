package Datos;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class SitioInteres 
{
    private ArrayList<AtraccionMec> atracMec;
    private CentroExp centExp;
    private Restaurante rest;
    private ServicioPublic servPubl;
    private int x,y, costoTotal, tiempoTotal;
    private String nameSite;
    private ImageIcon image;

    public SitioInteres() 
    {
    }

    public SitioInteres(ArrayList<AtraccionMec> atracMec, CentroExp centExp, 
                     Restaurante rest, ServicioPublic servPubl, int x, int y) {
        this.atracMec = atracMec;
        this.centExp = centExp;
        this.rest = rest;
        this.servPubl = servPubl;
        this.x=x;
        this.y=y;
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public String getNameSite() {
        return nameSite;
    }

    public void setNameSite(String nameSite) {
        this.nameSite = nameSite;
    }
    
    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }
    
    public ArrayList<AtraccionMec> getAtracMec() 
    {
        return atracMec;
    }

    public void setAtracMec(ArrayList<AtraccionMec> atracMec) {
        this.atracMec = atracMec;
    }

    public CentroExp getCentExp() {
        return centExp;
    }

    public void setCentExp(CentroExp centExp) {
        this.centExp = centExp;
    }

    public Restaurante getRest() {
        return rest;
    }

    public void setRest(Restaurante rest) {
        this.rest = rest;
    }

    public ServicioPublic getServPubl() {
        return servPubl;
    }

    public void setServPubl(ServicioPublic servPubl) {
        this.servPubl = servPubl;
    }

    
    
}

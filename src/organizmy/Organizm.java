package organizmy;

import java.awt.Color;
import swiat.Swiat;

public abstract class Organizm {
    //METODY ABSTRAKCYJNE
    public abstract void akcja();
    public abstract void kolizja(Organizm organizm, Organizm przeciwnik);
    public abstract char rysowanie();
    
    //KONSTRUKTOR
    public Organizm (Swiat swiat, int x, int y) {
        this.sila = 0;
        this.inicjatywa = 0;
        this.wiek = 0;
        this.x = x;
        this.y = y;
        this.refSwiat = swiat;  
        this.skaleczenie = 0;
        refSwiat.organizmy[x][y] = this;
        refSwiat.zwiekszIloscOrganizmow();
        this.czyZyje = true;
        this.kolor = Color.WHITE;
        
    }
    
    //GETTERY
    public int getSila() {
        return this.sila;
}
    public int getInicjatywa() {
        return this.inicjatywa;
}
    public int getWiek() {
        return this.wiek;
}
    public int getX() {
        return this.x;
}
    public int getY() {
        return this.y;
}
    public int getSkaleczenie() {
        return this.skaleczenie;
}
    public boolean getCzyZyje() {
        return this.czyZyje;
    }
    public Color getKolor() {
           return kolor;
    }
    
    
    //SETTERY
    public void setSila(int sila) {
        this.sila = sila;
    }  
    public void setInicjatywa(int inicjatywa) {
        this.inicjatywa = inicjatywa;
    }
    public void setWiek(int wiek) {
        this.wiek = wiek;
    }
    public void setPozycja(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setSkaleczenie(int skaleczenie) {
        this.skaleczenie = skaleczenie;
    }
    public void setUsmierc () {
        this.czyZyje = false; 
    }
    //INNE
    public void zmniejszSkaleczenie() {
        (this.skaleczenie)--;
    }
    public void skalecz() {
        this.skaleczenie = 2;
    }
    public void zwiekszWiek() {
        (this.wiek)++;
    }
    
    
    //POLA
    protected int sila;
    protected int inicjatywa;
    protected int wiek;
    protected int x;
    protected int y;
    protected int skaleczenie;
    protected boolean czyZyje;
    protected Swiat refSwiat;
    protected Color kolor;
}

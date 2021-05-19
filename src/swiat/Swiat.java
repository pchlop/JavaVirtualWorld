/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swiat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import organizmy.*;
import organizmy.rosliny.*;
import organizmy.zwierzeta.*;

public class Swiat extends JFrame implements ActionListener{
    public Swiat (int x, int y) {
        
        JFrame ramka = new JFrame(); //stworzenie okna aplikacji
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //po zamknieciu okna, aplikacja konczy dzialanie
        ramka.setSize(x*20, ((y*20) + y*8));
        ramka.setTitle("Piotr Chłopski, nr albumu 151635"); //ustawienie tytulu
       /* ramka.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints(); 
        c.fill = GridBagConstraints.HORIZONTAL;  */
       //ramka.setLayout(new GridLayout(2,1));
       ramka.setLayout(null);
       ramka.setResizable(false); //wylaczenie maksymalizowania
        
        
        szerokosc = x;
        dlugosc = y;
        this.iloscOrganizmow = 0;
        organizmy = new Organizm[x][y];
        guziki = new JButton[x][y];
        sterujace = new JButton[3];
        
       JPanel gorny = new JPanel();
       gorny.setLayout(new GridLayout(x,y,2,2));
       gorny.setSize(x*19,y*19);
       gorny.setLocation(0, y*7);
       //gorny.setLocation((((20*x)-(19*x))/x), 0);
        for(int j=0; j < x; j++) {
            for (int i=0; i < y; i++) {
                this.organizmy[i][j] = null;
                guziki[i][j] = new JButton();
                guziki[i][j].setBackground(null);
                gorny.add(guziki[i][j]);
            }
        }
        gorny.setVisible(true);
        
        ramka.add(gorny); //dodaje panel z mapa swiata do okna(ramka)
        
        
        JPanel dolny = new JPanel();
        dolny.setSize(19*x, y*3);
        dolny.setLocation(0, 0);
        dolny.setLayout(new FlowLayout());
        
        sterujace[0] = new JButton("Wykonaj turę!");
        sterujace[0].addActionListener(this);
        sterujace[1] = new JButton("Wczytaj z pliku");
        sterujace[1].addActionListener(this);
        sterujace[2] = new JButton("Zapisz do pliku");
        sterujace[2].addActionListener(this);
        
        dolny.add(sterujace[0]);
        dolny.add(sterujace[1]);
        dolny.add(sterujace[2]);
        
        dolny.setVisible(true);
        
        ramka.add(dolny); //dodaje panel z przyciskami sterujacymi do okna (ramka)
        
        JPanel komentator = new JPanel();
        komentator.setLayout(new FlowLayout());
        poleTekstu = new JTextArea();
        poleTekstu.setPreferredSize(new Dimension (19*x, y*3));
        komentator.add(poleTekstu);
        komentator.setSize(19*x, 4*y);
        komentator.setLocation(0, 3*y);
        komentator.setVisible(true);
        
        ramka.add(komentator); 
        ramka.setVisible(true); //wyswietlanie okna
        
        
        
        Organizm w1 = new Wilk(this, 1,1);
        Organizm w2 = new Wilk(this, 2,2);
        Organizm w3 = new Wilk(this, 8,2);
        Organizm w4 = new Wilk(this, 12,5);
        Organizm w5 = new Wilk(this, 9,7);
        Organizm w6 = new Wilk(this, 11,19);
        Organizm t1 = new Trawa(this, 1,2);
        Organizm t2 = new Trawa(this, 3,14);
        Organizm t3 = new Trawa(this, 4,13);
        Organizm t4 = new Trawa(this, 15,8);
        Organizm t5 = new Trawa(this, 15,9);
        Organizm m1 = new Mlecz(this, 2,1);
        Organizm m2 = new Mlecz(this, 3,7);
        Organizm m4 = new Mlecz(this, 4,8);
        Organizm m5 = new Mlecz(this, 18,12);
        Organizm wj1 = new WilczaJagoda(this, 1,3);
        Organizm wj2 = new WilczaJagoda(this, 0,0);
        Organizm wj5 = new WilczaJagoda(this, 6,16);
        Organizm wj6 = new WilczaJagoda(this, 13,13);
        Organizm b1 = new Bobr(this, 3,1);
        Organizm b2 = new Bobr(this, 10,17);
        Organizm b3 = new Bobr(this, 12,15);
        Organizm j1 = new Jez(this, 1,4);
        Organizm s1 = new Slimak(this, 4,1);
        Organizm s2 = new Slimak(this, 2,10);
        Organizm s3 = new Slimak(this, 1,18);
        Organizm s4 = new Slimak(this, 8,11);
        Organizm o1 = new Owca(this, 2,3);
        Organizm o2 = new Owca(this, 3,2);
        Organizm o4 = new Owca(this, 16,1);
        Organizm o5 = new Owca(this, 15,2);
        Organizm o6 = new Owca(this, 18,4);
        
        
    };
    
    public void rysujSwiat() {
        System.out.println("Piotr Chłopski, 151635");
         System.out.println("X X X X X X X X X X X X X X X X X X X X ");

    for (int j = 0; j < szerokosc; j++) {
        for (int i = 0; i < dlugosc; i++) {
            if (organizmy[i][j] != null) {
                System.out.print(organizmy[i][j].rysowanie() + " ");
                guziki[i][j].setBackground(organizmy[i][j].getKolor());
            }
            else {
                System.out.print(". ");
                guziki[i][j].setBackground(null);
            }
        }
        System.out.println();
    }
    System.out.println("X X X X X X X X X X X X X X X X X X X X ");
    };
    public void wykonajTure() {
        poleTekstu.setText("");
        int licznik = 0;
        Organizm tmp;
        Organizm [] posortowaneOrganizmy = new Organizm[400];
        
        for (int j = 0; j < szerokosc; j++) {
            for (int i = 0; i < dlugosc; i++) {
                if (organizmy[i][j] != null) {
                    posortowaneOrganizmy[licznik] = organizmy[i][j];
                licznik++;
                }
            }
        } 
        //SORTOWANIE
        for (int k = 0; k < licznik; k++) {
        for (int l = 0; l < licznik - 1; l++) {
            if (posortowaneOrganizmy[l].getInicjatywa() != posortowaneOrganizmy[l + 1].getInicjatywa()) {
                if (posortowaneOrganizmy[l].getInicjatywa() < posortowaneOrganizmy[l + 1].getInicjatywa()) {
                   tmp = posortowaneOrganizmy[l];
                   posortowaneOrganizmy[l] = posortowaneOrganizmy[l+1];
                   posortowaneOrganizmy[l+1] = tmp;
                   
                }
            }
            else {
                if (posortowaneOrganizmy[l].getWiek() < posortowaneOrganizmy[l + 1].getWiek()) {
                    tmp = posortowaneOrganizmy[l];
                    posortowaneOrganizmy[l] = posortowaneOrganizmy[l+1];
                    posortowaneOrganizmy[l+1] = tmp;;
                }
            }
        }
    }
        // KONIEC SORTOWANIA
        
     for (int i = 0; i < licznik; i++) {
        if (posortowaneOrganizmy[i].getCzyZyje() == true) {
            posortowaneOrganizmy[i].akcja();
            posortowaneOrganizmy[i].zwiekszWiek();
        }
        }
    }
    
    
    public void zwiekszIloscOrganizmow() {
        (this.iloscOrganizmow)++;
    }
    
    public void zmniejszIloscOrganizmow() {
        (this.iloscOrganizmow)--;
    }
    
    public int getSzerokosc() {
        return this.szerokosc;
    }
    public int getDlugosc() {
        return this.dlugosc;
    }
    
    @Override
     public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if(source == sterujace[0]){
                wykonajTure();
                rysujSwiat();
            
            }	
            if(source == sterujace[1]){
            rysujSwiat();
                try {
                    wczytajSwiat("swiat.txt");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Swiat.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }	
            if(source == sterujace[2]){
                try {
                    zapiszSwiat();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            
            }	
    }
     
     public void dodajKomentarz(String kom) {
         poleTekstu.append(kom);
         poleTekstu.append("\n");
     }
     
     public void zapiszSwiat() throws FileNotFoundException {
         PrintWriter zapis = new PrintWriter("swiat.txt");
         zapis.println(szerokosc + " " + dlugosc);
        for (int j = 0; j<szerokosc; j++) {
            for (int i=0; i<dlugosc; i++){
                if (organizmy[i][j] != null){
                    zapis.println(organizmy[i][j].rysowanie() + " " + organizmy[i][j].getX() + " " + organizmy[i][j].getY() + " " + organizmy[i][j].getSila() + " " + organizmy[i][j].getInicjatywa() + " " + organizmy[i][j].getWiek() + " "+ organizmy[i][j].getSkaleczenie());
                }
            }
        }
        zapis.close();
     }
     
     public void  wczytajSwiat(String nazwa) throws FileNotFoundException{
      for (int j = 0; j < szerokosc; j++) {
            for (int i = 0; i < dlugosc; i++) {
		organizmy[i][j] = null;
            }
	}
         
        File x = new File(nazwa);
        Scanner skaner = new Scanner(x);
        
        szerokosc = skaner.nextInt();
        dlugosc = skaner.nextInt();
        organizmy = new Organizm[szerokosc][dlugosc];
        
        String symbol;
        int xx, yy, sila, inicjatywa, wiek, skaleczenie;
        
        while(skaner.hasNext()) {
            symbol = skaner.next(".");
            xx = skaner.nextInt();
            yy = skaner.nextInt();
            sila = skaner.nextInt();
            inicjatywa = skaner.nextInt();
            wiek = skaner.nextInt();
            skaleczenie = skaner.nextInt();
            
            if (symbol.equals("W")) organizmy[xx][yy] = new Wilk(this, xx,yy);
            else if (symbol.equals("B")) organizmy[xx][yy] = new Bobr(this, xx,yy);
            else if (symbol.equals("J")) organizmy[xx][yy] = new Jez(this, xx,yy);
            else if (symbol.equals("O")) organizmy[xx][yy] = new Owca(this, xx,yy);
            else if (symbol.equals("S")) organizmy[xx][yy]= new Slimak(this, xx,yy);
    
            else if (symbol.equals("m")) organizmy[xx][yy] = new Mlecz(this, xx,yy);
            else if (symbol.equals("b")) organizmy[xx][yy] = new WilczaJagoda(this, xx,yy);
            else if (symbol.equals("t")) organizmy[xx][yy] = new Trawa(this, xx,yy);
        }
        rysujSwiat();
     }
    
    public Organizm organizmy[][];
    private int iloscOrganizmow; 
    private int szerokosc;
    private int dlugosc;
    private JButton guziki[][];
    private JButton sterujace[];
    private JTextArea poleTekstu;
}

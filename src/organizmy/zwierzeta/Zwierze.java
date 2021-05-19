package organizmy.zwierzeta;

import java.util.Random;
import organizmy.Organizm;
import swiat.Swiat;

public abstract class Zwierze extends Organizm {
    
    public Zwierze (Swiat swiat, int x, int y) {
        super(swiat, x, y);
    }
    
    @Override
    public void akcja() {
        if (this.skaleczenie == 0){
        int nx = this.x;
        int ny = this.y;
        
        Random random = new Random();
        int kierunek = random.nextInt(8); //generuje losowo liczbe od 0 do 7...
        System.out.println(kierunek);
        switch (kierunek) {
            case 0:
                ny++;
                break;
            case 1: 
                ny++;
                nx++;
                break;
            case 2:
                nx++;
                break;
            case 3: 
                nx++;
                ny--;
                break;
            case 4: 
                ny--;
                break;
            case 5: 
                ny--;
                nx--;
                break;
            case 6: 
                nx--;
                break;
            case 7: 
                nx--;
                ny++;
                break;
        } // koniec switcha
        if (nx < 0) nx = nx + 2;
        if (nx > 19) nx = nx - 2;  // uniwersalizacja
        if (ny < 0) ny = ny + 2;
        if (ny > 19) ny = ny - 2; // uniwersalizacja
        
        if (refSwiat.organizmy[nx][ny] == null) {
            refSwiat.organizmy[nx][ny] = refSwiat.organizmy[x][y];
            refSwiat.organizmy[x][y] = null;
            this.setPozycja(nx, ny);
        }
        
         else {
            kolizja(this, refSwiat.organizmy[nx][ny]);
        }
    } // koniec ifa ze skaleczeniem
    else {
        this.zmniejszSkaleczenie();
    }
    }
    
 
    @Override 
    public void kolizja(Organizm organizm, Organizm przeciwnik) {
        Random random = new Random();
        if (organizm.rysowanie() != przeciwnik.rysowanie()) {
        if (organizm.getSila() >= przeciwnik.getSila()) {
            if ((przeciwnik.rysowanie() == 'S') && (organizm.getSila() > 4)){
                if (random.nextInt(10) > 6) {
                    organizm.akcja();
                    System.out.println(przeciwnik.rysowanie() + " uciekl rywalowi."); 
                     refSwiat.dodajKomentarz(przeciwnik.rysowanie() + " uciekl rywalowi."); 
                }
            }
            if (przeciwnik.rysowanie() != 'J') {}
            else {
                organizm.skalecz();
                System.out.println(organizm.rysowanie() + " atakuje " + przeciwnik.rysowanie() + ". " + przeciwnik.rysowanie() + " umiera raniac powaznie " + organizm.rysowanie());
                refSwiat.dodajKomentarz(organizm.rysowanie() + " atakuje " + przeciwnik.rysowanie() + ". " + przeciwnik.rysowanie() + " umiera raniac powaznie " + organizm.rysowanie());
            }

            if (przeciwnik.rysowanie() != 'b'){
                int px = przeciwnik.getX();
                int py = przeciwnik.getY();
                int ax = organizm.getX();
                int ay = organizm.getY();
                refSwiat.zmniejszIloscOrganizmow();
                refSwiat.organizmy[px][py].setUsmierc();
                refSwiat.organizmy[px][py] = refSwiat.organizmy[ax][ay];
                refSwiat.organizmy[px][py].setPozycja(px, py);
                refSwiat.organizmy[ax][ay] = null;
                refSwiat.dodajKomentarz(organizm.rysowanie() + " zjadl " + przeciwnik.rysowanie());
                
            }
            else {
                refSwiat.organizmy[przeciwnik.getX()][przeciwnik.getY()] = null;
                refSwiat.organizmy[organizm.getX()][organizm.getY()] = null;
                //refSwiat.organizmy[organizm.getX()][organizm.getX()].setUsmierc();
                
                System.out.println(organizm.rysowanie() + " zjadl " + przeciwnik.rysowanie() + " i umarl.");
                refSwiat.dodajKomentarz(organizm.rysowanie() + " zjadl " + przeciwnik.rysowanie() + " i umarl.");
            }
            
        }
        else { //jesli sila organizmu < sila przeciwnika
            if (organizm.rysowanie() != 'J') {}
            else {
                przeciwnik.skalecz();
            }
            refSwiat.organizmy[organizm.getX()][organizm.getY()] = null;
            refSwiat.zmniejszIloscOrganizmow();
            System.out.println(przeciwnik.rysowanie() + " zjadl " + organizm.rysowanie());
            refSwiat.dodajKomentarz(przeciwnik.rysowanie() + " zjadl " + organizm.rysowanie());
        }
    } //koniec ifa z roznymi znakami (zwierzetami)
    else {
        rozmnazanie(przeciwnik);
    }
}
    
    
    @Override 
    public char rysowanie() {
        return 0;
    }



public void rozmnazanie(Organizm organizm){
    int nowy_x = organizm.getX();
    int nowy_y = organizm.getY();
    
    Random random = new Random();
    
    switch (random.nextInt(8)) {
    case 0: nowy_y = nowy_y + 1; break;
    case 1: nowy_x = nowy_x + 1; nowy_y = nowy_y + 1; break;
    case 2: nowy_x = nowy_x + 1; break;
    case 3: nowy_x = nowy_x + 1; nowy_y = nowy_y - 1; break;
    case 4: nowy_y = nowy_y - 1; break;
    case 5: nowy_x = nowy_x - 1; nowy_y = nowy_y - 1; break;
    case 6: nowy_x = nowy_x - 1; break;
    case 7: nowy_x = nowy_x - 1; nowy_y = nowy_y + 1;  break;
    }

    if (nowy_x < 0) nowy_x = nowy_x + 2;
    if (nowy_x > 19) nowy_x = nowy_x - 2;
    if (nowy_y < 0) nowy_y = nowy_y + 2;
    if (nowy_y > 19) nowy_y = nowy_y - 2;

    if (refSwiat.organizmy[nowy_x][nowy_y] == null)
    {
        if (this.rysowanie() == 'W') {
            Organizm wilk = new Wilk(refSwiat, nowy_x, nowy_y);
            System.out.println("Urodzil sie Wilk.");
            refSwiat.dodajKomentarz("Urodzil sie Wilk.");
        }
        if (this.rysowanie() == 'S') {
            Organizm slimak = new Slimak(refSwiat, nowy_x, nowy_y);
            System.out.println("Urodzil sie Slimak.");
             refSwiat.dodajKomentarz("Urodzil sie Slimak.");
        }
        if (this.rysowanie() == 'J') {
            Organizm jez = new Jez(refSwiat, nowy_x, nowy_y);
            System.out.println("Urodzil sie Jez.");
             refSwiat.dodajKomentarz("Urodzil sie Jez.");
        }
        if (this.rysowanie() == 'O') {
            Organizm owca = new Owca(refSwiat, nowy_x, nowy_y);
            System.out.println("Urodzil sie Owca.");
             refSwiat.dodajKomentarz("Urodzil sie Owca.");
        }
        if (this.rysowanie() == 'B') {
            Organizm bobr = new Bobr(refSwiat, nowy_x, nowy_y);
            System.out.println("Urodzil sie Bobr.");
             refSwiat.dodajKomentarz("Urodzil sie Bobr.");
        }
    }
}
}
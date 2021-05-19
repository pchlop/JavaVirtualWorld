package organizmy.rosliny;

import java.util.Random;
import organizmy.Organizm;
import swiat.Swiat;


public abstract class Roslina extends Organizm {
    
    public Roslina(Swiat swiat, int x, int y) {
        super(swiat, x, y);
       // this.sila = 0;
       // this.inicjatywa = 0;
    }
    
    @Override
    public void kolizja(Organizm organizm, Organizm przeciwnik) {
    
    }
 
    @Override
    public void akcja() {
        Random random = new Random();
    if (random.nextInt(100) < 15) {
        int nowy_x = this.getX();
        int nowy_y = this.getY();
        
        Random random2 = new Random();
        
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
            if (this.rysowanie() == 't') {
                Organizm trawa = new Trawa(refSwiat, nowy_x, nowy_y);
            }
            if (this.rysowanie() == 'b') {
                Organizm wilcza = new WilczaJagoda(refSwiat, nowy_x, nowy_y);
            }
            if (this.rysowanie() == 'm') {
                Organizm mlecz = new Mlecz(refSwiat, nowy_x, nowy_y);
            }
        }
    }
    }
    
    @Override 
    public char rysowanie() {
        return 0;
    }   
} 

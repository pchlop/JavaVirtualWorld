package organizmy.zwierzeta;

import java.awt.Color;
import swiat.Swiat;

public class Jez extends Zwierze{
    
    public Jez(Swiat swiat, int x, int y) {
        super(swiat, x, y);
        this.sila = 2;
        this.inicjatywa = 3;
        this.kolor = Color.RED;
    }
    
     @Override 
    public char rysowanie() {
        return 'J';
    }
}



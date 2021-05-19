package organizmy.zwierzeta;

import java.awt.Color;
import swiat.Swiat;

public class Bobr extends Zwierze {
    
    public Bobr(Swiat swiat, int x, int y) {
        super(swiat, x, y);
        this.sila = 3;
        this.inicjatywa = 1;
        this.kolor = Color.ORANGE;
    }
    
 
   @Override 
    public char rysowanie() {
        return 'B';
        
    }
}

 
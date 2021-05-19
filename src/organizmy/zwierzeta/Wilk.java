package organizmy.zwierzeta;

import java.awt.Color;
import swiat.Swiat;

public class Wilk extends Zwierze {
    
    public Wilk(Swiat swiat, int x, int y) {
        super(swiat, x, y);
        this.sila = 9;
        this.inicjatywa = 5;
        this.kolor = Color.getHSBColor(0.055F, 0.5F, 0.3F);
    }
    
     @Override 
    public char rysowanie() {
        return 'W';
    }
}

package organizmy.zwierzeta;

import java.awt.Color;
import swiat.Swiat;

public class Owca extends Zwierze {
    
    public Owca(Swiat swiat, int x, int y) {
        super(swiat, x, y);
        this.sila = 4;
        this.inicjatywa = 4;
        this.kolor = Color.getHSBColor(0.0F, 0.0F, 0.7F);
    }
    
     @Override 
    public char rysowanie() {
        return 'O';
    }
}

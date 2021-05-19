package organizmy.rosliny;

import java.awt.Color;
import swiat.Swiat;

public class Trawa extends Roslina {
    
    public Trawa(Swiat swiat, int x, int y) {
        super(swiat, x, y);
        this.kolor = Color.GREEN;
    }
    
     @Override 
    public char rysowanie() {
        return 't';
    }
}

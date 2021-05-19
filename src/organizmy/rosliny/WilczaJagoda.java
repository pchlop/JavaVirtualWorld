package organizmy.rosliny;

import java.awt.Color;
import swiat.Swiat;

public class WilczaJagoda extends Roslina {
    
    public WilczaJagoda(Swiat swiat, int x, int y) {
        super(swiat, x, y);
        this.kolor = Color.getHSBColor(0.77F, 1.0F, 1.0F);
    }
    
     @Override 
    public char rysowanie() {
        return 'b';
    }
}

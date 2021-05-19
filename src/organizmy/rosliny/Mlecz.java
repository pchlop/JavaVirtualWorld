package organizmy.rosliny;

import java.awt.Color;
import swiat.Swiat;

public class Mlecz extends Roslina {

    public Mlecz(Swiat swiat, int x, int y) {
        super(swiat, x, y);
        this.kolor = Color.YELLOW;
    }
    
     @Override 
    public char rysowanie() {
        return 'm';
        
    }
    @Override
    public void akcja() {
        for (int i=0; i<3; i++){
            super.akcja();
        }
    }
}


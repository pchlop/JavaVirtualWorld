package organizmy.zwierzeta;

import java.awt.Color;
import java.util.Random;
import swiat.Swiat;

public class Slimak extends Zwierze {
    
    public Slimak(Swiat swiat, int x, int y) {
        super(swiat, x, y);
        this.sila = 1;
        this.inicjatywa = 1;
        this.kolor = Color.getHSBColor(0.5F, 0.8F, 0.6F);
    }
    
     @Override 
    public char rysowanie() {
        return 'S';
    }


@Override
public void akcja(){
    Random random = new Random();
    if (random.nextInt(11) == 0) {
        super.akcja();
    }
}
}
    

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Karte{
    private int wert;
    private Image bild;
    private URL url;

    public Karte(int wert) {
        this.wert = wert;
        try {
            this.url = new URL("H://Fächer/Sen/VPR/Kart_" + wert);
            this.bild = ImageIO.read(url);
        }catch(IOException e){
            System.out.println("Das Bild für Karte " + this.wert + " konnte nicht geladen werden!");
            e.printStackTrace();
        }
    }

    public int getWert(){
        return this.wert;
    }

    public Image getBild(){
        return this.bild;
    }
}

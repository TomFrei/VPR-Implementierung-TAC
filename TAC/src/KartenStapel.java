import java.util.ArrayList;

public class KartenStapel {
    ArrayList<Karte> stapel = new ArrayList<Karte>();

    public void StapelErzeugen(){
		for(int j = 0; j <= 7; j++)
			for(int i = 1; i < 13; i++)
				if (i == 11){
					continue;
				} else {
					stapel.add(new Karte(i));
				}
		for (int i = 0; i <= 8; i++){
			stapel.add(new Karte(100));
			stapel.add(new Karte(101));
		}
		
		
    }
}

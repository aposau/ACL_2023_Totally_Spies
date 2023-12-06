package projet_totally_spies;

import java.util.Arrays;

public class Heros extends Personnage  {
	
	public Heros(int nb_PV ,int positionX,int positionY ) {
		super( nb_PV , positionX,positionY );
		this.nb_PV= 150;
	}

	@Override
	public String toString() {
		return "Heros [nb_PV=" + nb_PV + ", positionX=" + positionX + ", positionY=" + positionY  + "]";
	}
	
/*
	public boolean peut_avancer(int x,int y) {
		if (tableau[y][x]==0) {
			return true;
		}
		
	}*/
}
	

package projet_totally_spies;


public class Heros extends Personnage  {
	
	public Heros(int nb_PV ,int positionX,int positionY ,int ant_positionX,int ant_positionY) {
		super( nb_PV , positionX,positionY ,ant_positionX, ant_positionY);
		this.nb_PV= 150;
	}
/*
	public boolean peut_avancer(int x,int y) {
		if (tableau[y][x]==0) {
			return true;
		}
		
	}*/
}
	

package projet_totally_spies;

public class Monstre extends Personnage {
 int matricule;
 public Monstre(int nb_PV ,int positionX,int positionY, int ant_positionX,int ant_positionY,  int matricule) {
		super(nb_PV ,positionX,positionY,ant_positionX, ant_positionY);
		this.nb_PV= 150;
	}
 
}

package projet_totally_spies;

public class Monstre extends Personnage {
 int matricule;
 public Monstre(int nb_PV ,int positionX,int positionY, int matricule) {
		super(nb_PV ,positionX,positionY);
		this.matricule=matricule;
		this.nb_PV= 80;
	}
 
}

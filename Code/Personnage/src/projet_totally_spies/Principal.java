package projet_totally_spies;
public class Principal {

	public static void main(String[] args) {
		Personnage a= new Personnage(3,1,2,1,2);
		System.out.println("nb pv=" + a.getNb_PV());
		System.out.println("position=(" + a.getPositionX()+ "," + a.getPositionY() + ")");
		a.move_right();
		System.out.println("position=(" + a.getPositionX()+ "," + a.getPositionY() + ")");
		a.move_down();
		System.out.println("position=(" + a.getPositionX()+ "," + a.getPositionY() + ")");
		Labyrinthe lab = new Labyrinthe(1);
		int[][] table = lab.lireFichier();
		System.out.println(table[0][0]);
		table[0][0]=2;
		System.out.println(table[0][0]);
	}

}

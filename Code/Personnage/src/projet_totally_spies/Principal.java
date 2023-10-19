package projet_totally_spies;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 //Personnage a=Personnage(3,1,2);
		Personnage a= new Personnage(3,1,2);
		System.out.println("nb pv=" + a.getNb_PV());
		System.out.println("position=(" + a.getPositionX()+ "," + a.getPositionY() + ")");
		a.move_right();
		System.out.println("position=(" + a.getPositionX()+ "," + a.getPositionY() + ")");
		a.move_down();
		System.out.println("position=(" + a.getPositionX()+ "," + a.getPositionY() + ")");
	}

}

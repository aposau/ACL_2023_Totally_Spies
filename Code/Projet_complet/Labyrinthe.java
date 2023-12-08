

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labyrinthe{

	int nv;
	public Labyrinthe(int nv) {
		this.nv = nv;

	}

	// Fonction pour lire le fichier et créer un tableau bidimensionnel

	public int[][] lireFichier() {
		String cheminFichier=null;
		if (this.nv==1) {

			cheminFichier="C:\\Users\\r0man\\OneDrive\\Documents\\Ensem\\2A\\Info\\javoute\\Projet\\LabyrintheNiveauFacile.txt";

		}else if (this.nv==2) {

			cheminFichier="C:\\\\Users\\\\r0man\\\\OneDrive\\\\Documents\\\\Ensem\\\\2A\\\\Info\\\\javoute\\\\Projet\\\\LabyrintheNiveauMoyen.txt";

		}else if (this.nv==3) {

			cheminFichier="C:\\\\Users\\\\r0man\\\\OneDrive\\\\Documents\\\\Ensem\\\\2A\\\\Info\\\\javoute\\\\Projet\\\\LabyrintheNiveauDifficile.txt";

		}


		try {

			// Créez un objet Scanner pour lire le fichier

			Scanner scanner = new Scanner(new File(cheminFichier));

			// Obtenez le nombre de lignes et de colonnes dans le fichier

			int lignes = 0;

			int colonnes = 0;

			while (scanner.hasNextLine()) {

				lignes++;

				String[] elements = scanner.nextLine().split(" ");

				colonnes = Math.max(colonnes, elements.length);

			}

			// Réinitialisez le scanner pour lire à partir du début du fichier

			scanner.close();

			scanner = new Scanner(new File(cheminFichier));

			// Créez le tableau bidimensionnel

			int[][] tableauDentiers = new int[lignes][colonnes];

			// Remplissez le tableau avec les entiers du fichier

			for (int i = 0; i < lignes; i++) {

				String[] elements = scanner.nextLine().split(" ");


				for (int j = 0; j < elements.length; j++) {

					tableauDentiers[i][j] = Integer.parseInt(elements[j]);

				}

			}
			// Fermez le scanner

			scanner.close();

			return tableauDentiers;

		} catch (FileNotFoundException e) {

			e.printStackTrace();

			return null;

		}

	}
	public int[][] getPic(){
		int[][] tableau = lireFichier();
		int [][] liste = new int [5][2];
		int num = 0;
		for (int i=0;i<tableau.length;i++) {
			for (int j=0;j<tableau[0].length; j++) {
				if (tableau[i][j]==2) {
					liste[num][0]=i;
					liste[num][1]=j;
					num++;
				}
			}

		}
		return liste;

	}
	public int[][] getPotion(){
		int[][] tableau = lireFichier();
		int [][] liste = new int [2][2];
		int num = 0;
		for (int i=0;i<tableau.length;i++) {
			for (int j=0;j<tableau[0].length; j++) {
				if (tableau[i][j]==3) {
					liste[num][0]=i;
					liste[num][1]=j;
					num++;
				}
			}

		}
		return liste;
	}
	public int[][] getTrou(){
		int[][] tableau = lireFichier();
		int [][] liste = new int [4][2];
		int num = 0;
		for (int i=0;i<tableau.length;i++) {
			for (int j=0;j<tableau[0].length; j++) {
				if (tableau[i][j]==4) {
					liste[num][0]=i;
					liste[num][1]=j;
					num++;
				}
			}

		}
		return liste;
	}
	public int[][] getFin(){
		int[][] tableau = lireFichier();
		int [][] liste = new int [1][2];
		int num = 0;
		for (int i=0;i<tableau.length;i++) {
			for (int j=0;j<tableau[0].length; j++) {
				if (tableau[i][j]==5) {
					liste[num][0]=i;
					liste[num][1]=j;
					num++;
				}
			}

		}
		return liste;
	}
	
}
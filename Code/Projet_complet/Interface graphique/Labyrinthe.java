package projet_totally_spies;
import java.io.File;

	import java.io.FileNotFoundException;

	import java.util.Scanner;

public class Labyrinthe {

	public String cheminFichier;

	int nv;

	public Labyrinthe(int nv) {

	this.nv = nv;

	}

	// Fonction pour lire le fichier et créer un tableau bidimensionnel

	public int[][] lireFichier() {

	if (this.nv==1) {

	cheminFichier="C:\\Users\\Guillian\\ACL_2023_Totally_Spies\\Code\\Personnage\\src\\projet_totally_spies\\LabyrintheNiveauFacile.txt";

	}else if (this.nv==2) {

	cheminFichier=" ";

	}else if (this.nv==3) {

	cheminFichier=" ";

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

	}


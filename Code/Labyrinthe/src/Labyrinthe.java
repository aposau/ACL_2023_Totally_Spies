import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Labyrinthe {

       //Fonction pour lire le fichier et créer un tableau bidimensionnel
     public static int[][] lireFichier(String cheminFichier) {
         try {
               //Créez un objet Scanner pour lire le fichier
             Scanner scanner = new Scanner(new File(cheminFichier));
 
               //Obtenez le nombre de lignes et de colonnes dans le fichier
             int lignes = 0;
             int colonnes = 0;
 
             while (scanner.hasNextLine()) {
                 lignes++;
                 String[] elements = scanner.nextLine().split(" ");
                 colonnes = Math.max(colonnes, elements.length);
             }
 
               //Réinitialisez le scanner pour lire à partir du début du fichier
             scanner.close();
             scanner = new Scanner(new File(cheminFichier));
 
               //Créez le tableau bidimensionnel
             int[][] tableauDentiers = new int[lignes][colonnes];
 
               //Remplissez le tableau avec les entiers du fichier
             for (int i = 0; i < lignes; i++) {
                 String[] elements = scanner.nextLine().split(" ");
                 for (int j = 0; j < elements.length; j++) {
                     tableauDentiers[i][j] = Integer.parseInt(elements[j]);
                 }
             }
 
               //Fermez le scanner
             scanner.close();
 
             return tableauDentiers;
 
         } catch (FileNotFoundException e) {
             e.printStackTrace();
             return null;
         }
     }
 
       //Fonction pour obtenir un élément spécifique du tableau bidimensionnel
     public static int getElement(int[][] tableau, int ligne, int colonne) {
           //Vérifiez d'abord si les indices de ligne et de colonne sont valides
         if (ligne >= 0 && ligne < tableau.length && colonne >= 0 && colonne < tableau[ligne].length) {
             return tableau[ligne][colonne];
         } else {
               //Si les indices sont invalides, renvoyez une valeur par défaut ou lancez une exception selon votre besoinIci, on renvoie -1 comme valeur par défaut
             return -1;
         }
     }
 }

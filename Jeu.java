package bataille;

import java.util.Scanner;
import bataille.Bateau;
import bataille.Joueur;

public class Jeu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Créer les joueurs
        System.out.print("Nom du joueur 1 : ");
        Joueur joueur1 = new Joueur(scanner.nextLine());
        System.out.print("Nom du joueur 2 : ");
        Joueur joueur2 = new Joueur(scanner.nextLine());

        // Placer les bateaux des joueurs
        System.out.println(joueur1.getNom() + ", placez vos bateaux :");
        joueur1.placerBateaux(new Bateau("porte-avion", 5), 1, 1, false);
        joueur1.placerBateaux(new Bateau("croiseur", 4), 2, 1, false);
        joueur1.placerBateaux(new Bateau("contre-torpilleur", 3), 3, 1, false);
        joueur1.placerBateaux(new Bateau("sous-marin", 3), 4, 1, false);
        joueur1.placerBateaux(new Bateau("torpilleur", 2), 5, 1, false);

        System.out.println(joueur2.getNom() + ", placez vos bateaux :");
        joueur2.placerBateaux(new Bateau("porte-avion", 5), 1, 1, false);
        joueur2.placerBateaux(new Bateau("croiseur", 4), 2, 1, false);
        joueur2.placerBateaux(new Bateau("contre-torpilleur", 3), 3, 1, false);
        joueur2.placerBateaux(new Bateau("sous-marin", 3), 4, 1, false);
        joueur2.placerBateaux(new Bateau("torpilleur", 2), 5, 1, false);

        // Afficher les grilles de jeu
        System.out.println("\nGrille de " + joueur1.getNom() + " :");
        afficherGrille(joueur1.getGrille());
        System.out.println("\nGrille de " + joueur2.getNom() + " :");
        afficherGrille(joueur2.getGrille());

        // Jouer
        Joueur joueurCourant = joueur1;
        Joueur autreJoueur = joueur2;

        while (true) {
        	System.out.println("\n" + joueurCourant.getNom() + ", à vous de jouer ! \nEntrez les coordonnées de votre tir (ex: A1) :");
        	int colonne;
        	int ligne;
        	while (true) {
        	    String coord = scanner.nextLine().toUpperCase();
        	    try {
        	        colonne = coord.charAt(0) - 'A';
        	        ligne = Integer.parseInt(coord.substring(1)) - 1;
        	        if (colonne < 0 || colonne >= 10 || ligne < 0 || ligne >= 10) {
        	            System.out.println("Coordonnées invalides. Entrez à nouveau.");
        	        } else {
        	            break;
        	        }
        	    } catch (Exception e) {
        	        System.out.println("Coordonnées invalides. Entrez à nouveau.");
        	    }
        	}

        	if (autreJoueur.estTouche(ligne, colonne)) {
        	    System.out.println("Touché !");
        	    if (autreJoueur.getBateaux().isEmpty()) {
        	        System.out.println("Félicitations, " + joueurCourant.getNom() + " a gagné !");
        	        break;
        	    }
        	} else {
        	    System.out.println("Raté !");
        	}
            
         // Afficher les grilles de jeu
            System.out.println("\nGrille de " + joueur1.getNom() + " :");
            afficherGrille(joueur1.getGrille());
            System.out.println("\nGrille de " + joueur2.getNom() + " :");
            afficherGrille(joueur2.getGrille());

            if (joueurCourant.getBateaux().isEmpty()) {
                System.out.println("Dommage, " + joueurCourant.getNom() + " a perdu !");
                break;
            }

            // On inverse les rôles des joueurs
            Joueur joueurTemp = joueurCourant;
            joueurCourant = autreJoueur;
            autreJoueur = joueurTemp;
        }
            
         // Afficher les grilles de jeu
            System.out.println("\nGrille de " + joueur1.getNom() + " :");
            afficherGrille(joueur1.getGrille());
            System.out.println("\nGrille de " + joueur2.getNom() + " :");
            afficherGrille(joueur2.getGrille());

            Joueur temp = joueurCourant;
            joueurCourant = autreJoueur;
            autreJoueur = temp;
        

        scanner.close();
    }

    private static void afficherGrille(char[][] grille) {
        System.out.print("  ");
        for (int i = 0; i < grille.length; i++) {
            System.out.print((char)('A' + i) + " ");
        }
        System.out.println();
        for (int i = 0; i < grille.length; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < grille[i].length; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int demanderCoordonnee(String message, int max) {
        Scanner scanner = new Scanner(System.in);
        int coordonnee;

        do {
            System.out.print(message);
            while (!scanner.hasNextInt()) {
                System.out.println("La valeur saisie n'est pas un entier.");
                scanner.next();
                System.out.print(message);
            }
            coordonnee = scanner.nextInt();
            if (coordonnee < 1 || coordonnee > max) {
                System.out.println("La valeur saisie doit être comprise entre 1 et " + max + ".");
            }
        } while (coordonnee < 1 || coordonnee > max);
        
        scanner.close();

        return coordonnee - 1; // On soustrait 1 pour obtenir l'indice correspondant en Java (qui commence à 0)
    }
    
}
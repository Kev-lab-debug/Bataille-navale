package bataille;

import java.util.ArrayList;

public class Joueur {
    private String nom;
    private char[][] grille;
    private ArrayList<Bateau> bateaux;

    public Joueur(String nom) {
        this.nom = nom;
        this.grille = new char[10][10];
        this.bateaux = new ArrayList<Bateau>();
        initialiserGrille();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public char[][] getGrille() {
        return grille;
    }

    public void setGrille(char[][] grille) {
        this.grille = grille;
    }

    public ArrayList<Bateau> getBateaux() {
        return bateaux;
    }

    public void setBateaux(ArrayList<Bateau> bateaux) {
        this.bateaux = bateaux;
    }

    private void initialiserGrille() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                grille[i][j] = '~'; // '~' représente une case d'eau
            }
        }
    }

    public void placerBateaux(Bateau bateau, int ligne, int colonne, boolean estVertical) {
        if (estVertical) {
            for (int i = 0; i < bateau.getTaille(); i++) {
                grille[ligne + i][colonne] = bateau.getNom().charAt(0);
                bateau.ajouterCase(ligne + i, colonne);
            }
        } else {
            for (int i = 0; i < bateau.getTaille(); i++) {
                grille[ligne][colonne + i] = bateau.getNom().charAt(0);
                bateau.ajouterCase(ligne, colonne + i);
            }
        }
        bateaux.add(bateau);
    }
    
    public boolean attaque(int ligne, int colonne, Joueur adversaire) {
        if (adversaire.estTouche(ligne, colonne)) {
            System.out.println("Touché !");
            return true;
        } else {
            System.out.println("Manqué !");
            return false;
        }
    }

    public boolean estTouche(int ligne, int colonne) {
        for (Bateau bateau : bateaux) {
            if (bateau.contientCase(ligne, colonne)) {
                bateau.toucher();
                grille[ligne][colonne] = 'X'; // 'X' représente une case touchée
                return true;
            }
        }
        grille[ligne][colonne] = 'O'; // 'O' représente une case manquée
        return false;
    }
}
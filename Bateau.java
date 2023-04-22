package bataille;

import java.util.ArrayList;

public class Bateau {
    // Attributs
    private String nom; // Le nom du bateau
    private int taille; // La taille du bateau
    private ArrayList<int[]> cases; // Les cases occupées par le bateau
    private boolean estCoule; // Indique si le bateau est coulé ou non

    // Constructeur
    public Bateau(String nom, int taille) {
        this.nom = nom;
        this.taille = taille;
        this.cases = new ArrayList<int[]>();
        this.estCoule = false;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public ArrayList<int[]> getCases() {
        return cases;
    }

    public void setCases(ArrayList<int[]> cases) {
        this.cases = cases;
    }

    public boolean estCoule() {
        return estCoule;
    }

    public void setEstCoule(boolean estCoule) {
        this.estCoule = estCoule;
    }

    // Méthodes
    // Ajoute une case occupée par le bateau
    public void ajouterCase(int ligne, int colonne) {
        int[] caseBateau = { ligne, colonne };
        cases.add(caseBateau);
    }

    // Vérifie si une case est occupée par le bateau
    public boolean contientCase(int ligne, int colonne) {
        for (int[] caseBateau : cases) {
            if (caseBateau[0] == ligne && caseBateau[1] == colonne) {
                return true;
            }
        }
        return false;
    }

    // Marque le bateau comme touché et vérifie s'il est coulé
    public void toucher() {
        for (int[] caseBateau : cases) {
            if (!estCoule && caseBateau[0] != -1 && caseBateau[1] != -1) {
                return;
            }
        }
        estCoule = true;
    }
}
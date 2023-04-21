package bataille;

import java.util.ArrayList;

public class Bateau {
    private String nom;
    private int taille;
    private ArrayList<int[]> cases;
    private boolean estCoule;

    public Bateau(String nom, int taille) {
        this.nom = nom;
        this.taille = taille;
        this.cases = new ArrayList<int[]>();
        this.estCoule = false;
    }

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

    public void ajouterCase(int ligne, int colonne) {
        int[] caseBateau = { ligne, colonne };
        cases.add(caseBateau);
    }

    public boolean contientCase(int ligne, int colonne) {
        for (int[] caseBateau : cases) {
            if (caseBateau[0] == ligne && caseBateau[1] == colonne) {
                return true;
            }
        }
        return false;
    }

    public void toucher() {
        for (int[] caseBateau : cases) {
            if (!estCoule && caseBateau[0] != -1 && caseBateau[1] != -1) {
                return;
            }
        }
        estCoule = true;
    }
}
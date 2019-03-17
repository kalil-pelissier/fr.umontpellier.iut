package fr.umontpellier.iut.exo4;

import java.util.ArrayList;

public class Couple {
    private JeuPuzzle puzzle;
    private Couple predecesseur;

    public Couple(JeuPuzzle puzzle, Couple predecesseur) {
        this.puzzle = puzzle;
        this.predecesseur = predecesseur;
    }

    public JeuPuzzle getPuzzle() {
        return puzzle;
    }

    public ArrayList<JeuPuzzle> getListeDeMouvements() {
        ArrayList<JeuPuzzle> chemin = new ArrayList<>();
        Couple cur = this;
        while (cur != null){
            chemin.add(0, cur.puzzle);
            cur = cur.predecesseur;
        }
        return (chemin);
    }

    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<JeuPuzzle> fils, ArrayList<JeuPuzzle> dejaVus) {
        for (JeuPuzzle taq : fils) {
            if (!dejaVus.contains(taq)){
                dejaVus.add(taq);
                frontiere.add(new Couple(taq, this));
            }
        }
    }


}

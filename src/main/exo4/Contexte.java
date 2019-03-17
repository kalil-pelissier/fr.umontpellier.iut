package fr.umontpellier.iut.exo4;

import java.util.ArrayList;

public class Contexte {
    private JeuPuzzle puzzle;
    private ArrayList<JeuPuzzle> solution;

    public Contexte(JeuPuzzle puzzle) {
        this.puzzle = puzzle;
    }

    public ArrayList<JeuPuzzle> getSolution() {
        return solution;
    }

    public void resoudre() {
        ArrayList<Couple> frontiere = new ArrayList<>();
        ArrayList<JeuPuzzle> dejaVus = new ArrayList<>();
        frontiere.add(new Couple(puzzle, null));
            while (!frontiere.isEmpty() && !frontiere.get(0).getPuzzle().estGagnant()) {
                frontiere.get(0).mettreAJour(frontiere, frontiere.get(0).getPuzzle().genererFils(), dejaVus);
                frontiere.remove(0);
                //System.out.println(frontiere.size());
            }
            if (!frontiere.isEmpty()){
                solution = frontiere.get(0).getListeDeMouvements();
                System.out.println("Solution trouvée");
            }
            else{
                System.out.println("Pas de Solutions");
            }
    }
}
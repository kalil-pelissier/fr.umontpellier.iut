import java.util.ArrayList;

public class Contexte {

    private JeuPuzzle puzzle;
    private ArrayList<JeuPuzzle> solution = new ArrayList<>();

    public Contexte(JeuPuzzle puzzle) {
        this.puzzle = puzzle;
    }

    public ArrayList<JeuPuzzle> getSolution() {
        return solution;
    }

    @Override
    public String toString() {
        String afficher = null;
        if(solution==null) {
            afficher = "pas de solution";
        }
        else {
            afficher =  this.solution.toString();
        }
        return afficher;
    }

    public void resoudre() {

        ArrayList<JeuPuzzle> dejaVus = new ArrayList<>();
        ArrayList<Couple> frontiere = new ArrayList<>();
        frontiere.add(new Couple(puzzle,null));
        dejaVus.add(frontiere.get(0).getJeuPuzzle());
        boolean trouve = false;

        if (puzzle.estGagnant()) {
            trouve = true;
            solution.add(puzzle);
        }

        while(!frontiere.isEmpty() && !trouve){
            Couple curr = frontiere.remove(0);
            if (curr.getJeuPuzzle().estGagnant()){
                trouve= true;
                solution = curr.getListeDeMouvements();
            }else {
                curr.mettreAJour(frontiere,curr.getJeuPuzzle().genererFils(),dejaVus);
            }
        }
    }
}
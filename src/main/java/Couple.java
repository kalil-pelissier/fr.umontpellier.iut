import java.util.ArrayList;

public class Couple {

    private JeuPuzzle puzzle;
    private Couple predecesseur;

    public Couple(JeuPuzzle puzzle, Couple predecesseur) {
        this.puzzle = puzzle;
        this.predecesseur = predecesseur;
    }

    public JeuPuzzle getJeuPuzzle() {
        return puzzle;
    }

    public ArrayList<JeuPuzzle> getListeDeMouvements() {
        ArrayList<JeuPuzzle> mouvement= new ArrayList<>();
        Couple current = this;
        mouvement.add(this.puzzle);
        while(current.predecesseur != null) {
            current = current.predecesseur;
            mouvement.add(current.puzzle);
        }
        return mouvement;
    }

    public void mettreAJour(ArrayList<Couple> frontiere, ArrayList<JeuPuzzle> tab, ArrayList<JeuPuzzle> dejaVus) {
        for(JeuPuzzle t : tab) {
            if(!dejaVus.contains(t)) {
               dejaVus.add(t);
               frontiere.add(new Couple(t, this));
            }
        }
    }
}

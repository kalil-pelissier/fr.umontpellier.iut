import java.util.ArrayList;

public interface JeuPuzzle {
    public boolean estGagnant();
    public ArrayList<JeuPuzzle> genererFils();
}

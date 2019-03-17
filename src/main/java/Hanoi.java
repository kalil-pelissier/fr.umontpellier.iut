import java.util.ArrayList;

public class Hanoi implements JeuPuzzle{
    private ArrayList<Integer>[] colonnes;
    private int taille;

    public Hanoi(int taille){
        this.taille = taille;
        this.colonnes = new ArrayList[3];
        colonnes[0] = new ArrayList<>();
        colonnes[1] = new ArrayList<>();
        colonnes[2] = new ArrayList<>();
        for(int i=1; i<=taille; i++) {
            this.colonnes[0].add(i);
        }

    }

    public boolean estGagnant() {
        return colonnes[0].isEmpty() && colonnes[1].isEmpty();
    }

    @Override
    public String toString() {
        return "Hanoi{" +
                "1=" + colonnes[0].toString()+ "\n" +
                "2=" + colonnes[1].toString()+ "\n" +
                "3=" + colonnes[2].toString()+
                '}';
    }

    public ArrayList<JeuPuzzle> genererFils() {
        ArrayList<JeuPuzzle> listeFils = new ArrayList<>();
        if ((!colonnes[0].isEmpty() && !colonnes[1].isEmpty() && colonnes[0].get(0)<colonnes[1].get(0)) || (!colonnes[0].isEmpty() && colonnes[1].isEmpty())){
            Hanoi fils = new Hanoi(colonnes);
            fils.colonnes[1].add(0, fils.colonnes[0].get(0));
            fils.colonnes[0].remove(0);
            listeFils.add(fils);
        }
        if ((!colonnes[0].isEmpty() && !colonnes[2].isEmpty() && colonnes[0].get(0)<colonnes[2].get(0)) || (!colonnes[0].isEmpty() && colonnes[2].isEmpty())){
            Hanoi fils = new Hanoi(colonnes);
            fils.colonnes[2].add(0, fils.colonnes[0].get(0));
            fils.colonnes[0].remove(0);
            listeFils.add(fils);
        }
        if ((!colonnes[1].isEmpty() && !colonnes[0].isEmpty() && colonnes[1].get(0)<colonnes[0].get(0)) || (!colonnes[1].isEmpty() && colonnes[0].isEmpty())){
            Hanoi fils = new Hanoi(colonnes);
            fils.colonnes[0].add(0, fils.colonnes[1].get(0));
            fils.colonnes[1].remove(0);
            listeFils.add(fils);
        }
        if ((!colonnes[1].isEmpty() && !colonnes[2].isEmpty() && colonnes[1].get(0)<colonnes[2].get(0)) || (!colonnes[1].isEmpty() && colonnes[2].isEmpty())){
            Hanoi fils = new Hanoi(colonnes);
            fils.colonnes[2].add(0, fils.colonnes[1].get(0));
            fils.colonnes[1].remove(0);
            listeFils.add(fils);
        }
        if ((!colonnes[2].isEmpty() && !colonnes[0].isEmpty() && colonnes[2].get(0)<colonnes[0].get(0)) || (!colonnes[2].isEmpty() && colonnes[0].isEmpty())){
            Hanoi fils = new Hanoi(colonnes);
            fils.colonnes[0].add(0, fils.colonnes[2].get(0));
            fils.colonnes[2].remove(0);
            listeFils.add(fils);
        }
        if ((!colonnes[2].isEmpty() && !colonnes[1].isEmpty() && colonnes[2].get(0)<colonnes[1].get(0)) || (!colonnes[2].isEmpty() && colonnes[1].isEmpty())){
            Hanoi fils = new Hanoi(colonnes);
            fils.colonnes[1].add(0, fils.colonnes[2].get(0));
            fils.colonnes[2].remove(0);
            listeFils.add(fils);
        }
        return listeFils;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hanoi hanoi = (Hanoi) o;
        return Arrays.deepEquals(colonnes, hanoi.colonnes);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(colonnes);
    }
}

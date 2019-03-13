import java.util.ArrayList;

public class Hanoi {
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

    /*public ArrayList<JeuPuzzle> genererFils() {
        ArrayList<JeuPuzzle> fils = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (!colonnes[i].isEmpty()) {
                Integer d = colonnes[i].get(0);
                for (int j = 0; j < 3; j++) {
                    if (colonnes[j].isEmpty() || d < colonnes[j].get(0)) {
                        Hanoi prov = new Hanoi(this);
                        int b = prov.colonnes[i].remove(0);
                        prov.colonnes[j].add(0, b);
                        fils.add(prov);
                    }
                }
            }
        }
        return fils;
    }*/
}

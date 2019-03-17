import java.util.ArrayList;
import java.util.Arrays;

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

    public Hanoi(ArrayList<Integer>[] colonnes) {
        this.colonnes = new ArrayList[3];
        this.colonnes[0] = new ArrayList<>();
        this.colonnes[1] = new ArrayList<>();
        this.colonnes[2] = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < colonnes[i].size(); j++) {
                this.colonnes[i].add(colonnes[i].get(j));
            }
        }
        int max1 = 0, max2 = 0, max3 = 0;
        if (!colonnes[0].isEmpty()){max1 = colonnes[0].get(colonnes[0].size()-1);}
        if (!colonnes[1].isEmpty()){max2 = colonnes[1].get(colonnes[1].size()-1);}
        if (!colonnes[2].isEmpty()){max3 = colonnes[2].get(colonnes[2].size()-1);}
        if (max1>max2){max2 = max1;}
        if (max2>max3){max3 = max2;}
        this.taille = max3;
    }

    public Hanoi(Hanoi h){
        colonnes = new ArrayList[3];
        this.colonnes[0] = new ArrayList<>();
        this.colonnes[1] = new ArrayList<>();
        this.colonnes[2] = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < h.colonnes[i].size(); j++) {
                this.colonnes[i].add(h.colonnes[i].get(j));
            }
        }
        this.taille = h.taille;
    }

    public boolean estGagnant() {
        return (colonnes[0].isEmpty() && colonnes[1].isEmpty());
    }
    
    @Override
    public String toString(){
        String str = "+";
        for (int i = 0; i < 3*(taille*2-1)+4; i++) {
            str += "-";
        }
        str += "+\n";
        for (int i = 0; i < taille; i++) {
            str += "| ";
            for (int k = 0; k < 3; k++) {
                if (colonnes[k].size() >= taille - i) {
                    for (int j = 0; j < taille - colonnes[k].get(i-(taille-colonnes[k].size())); j++) {
                        str += " ";
                    }
                    for (int j = 0; j < 2 * (colonnes[k].get(i-(taille-colonnes[k].size())) - 1) + 1; j++) {
                        str += "-";
                    }
                    for (int j = 0; j < taille - colonnes[k].get(i-(taille-colonnes[k].size())) + 1; j++) {
                        str += " ";
                    }
                }
                else {
                    for (int j = 0; j < taille*2; j++) {
                        str += " ";
                    }
                }
            }
            str += "|\n";
        }
        str += "+";
        for (int i = 0; i < 3*(taille*2-1)+4; i++) {
            str += "-";
        }
        str += "+";
        return (str);
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

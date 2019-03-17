package fr.umontpellier.iut.exo4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Hanoi implements JeuPuzzle{
    private ArrayList<Integer>[] configuration;
    private int taille;

    public Hanoi(ArrayList<Integer>[] configuration) {
        this.configuration = new ArrayList[3];
        this.configuration[0] = new ArrayList<>();
        this.configuration[1] = new ArrayList<>();
        this.configuration[2] = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < configuration[i].size(); j++) {
                this.configuration[i].add(configuration[i].get(j));
            }
        }
        int max1 = 0, max2 = 0, max3 = 0;
        if (!configuration[0].isEmpty()){max1 = configuration[0].get(configuration[0].size()-1);}
        if (!configuration[1].isEmpty()){max2 = configuration[1].get(configuration[1].size()-1);}
        if (!configuration[2].isEmpty()){max3 = configuration[2].get(configuration[2].size()-1);}
        if (max1>max2){max2 = max1;}
        if (max2>max3){max3 = max2;}
        this.taille = max3;
    }

    public Hanoi(Hanoi h){
        configuration = new ArrayList[3];
        this.configuration[0] = new ArrayList<>();
        this.configuration[1] = new ArrayList<>();
        this.configuration[2] = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j < h.configuration[i].size(); j++) {
                this.configuration[i].add(h.configuration[i].get(j));
            }
        }
        this.taille = h.taille;
    }

    public Hanoi(int taille) {
        configuration = new ArrayList[3];
        this.configuration[0] = new ArrayList<>();
        this.configuration[1] = new ArrayList<>();
        this.configuration[2] = new ArrayList<>();
        for (int i = 1; i <= taille; i++) {
            this.configuration[0].add(i);
        }
        this.taille = taille;
    }

    public boolean estGagnant() {
        return (configuration[0].isEmpty() && configuration[1].isEmpty());
    }

    @Override
    public String toString() {
        String str = "+";
        for (int i = 0; i < 3*(taille*2-1)+4; i++) {
            str += "-";
        }
        str += "+\n";
        for (int i = 0; i < taille; i++) {
            str += "| ";
            for (int k = 0; k < 3; k++) {
                if (configuration[k].size() >= taille - i) {
                    for (int j = 0; j < taille - configuration[k].get(i-(taille-configuration[k].size())); j++) {
                        str += " ";
                    }
                    for (int j = 0; j < 2 * (configuration[k].get(i-(taille-configuration[k].size())) - 1) + 1; j++) {
                        str += "-";
                    }
                    for (int j = 0; j < taille - configuration[k].get(i-(taille-configuration[k].size())) + 1; j++) {
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

        if ((!configuration[0].isEmpty() && !configuration[1].isEmpty() && configuration[0].get(0)<configuration[1].get(0)) || (!configuration[0].isEmpty() && configuration[1].isEmpty())){
            Hanoi fils = new Hanoi(configuration);
            fils.configuration[1].add(0, fils.configuration[0].get(0));
            fils.configuration[0].remove(0);
            listeFils.add(fils);
        }
        if ((!configuration[0].isEmpty() && !configuration[2].isEmpty() && configuration[0].get(0)<configuration[2].get(0)) || (!configuration[0].isEmpty() && configuration[2].isEmpty())){
            Hanoi fils = new Hanoi(configuration);
            fils.configuration[2].add(0, fils.configuration[0].get(0));
            fils.configuration[0].remove(0);
            listeFils.add(fils);
        }
        if ((!configuration[1].isEmpty() && !configuration[0].isEmpty() && configuration[1].get(0)<configuration[0].get(0)) || (!configuration[1].isEmpty() && configuration[0].isEmpty())){
            Hanoi fils = new Hanoi(configuration);
            fils.configuration[0].add(0, fils.configuration[1].get(0));
            fils.configuration[1].remove(0);
            listeFils.add(fils);
        }
        if ((!configuration[1].isEmpty() && !configuration[2].isEmpty() && configuration[1].get(0)<configuration[2].get(0)) || (!configuration[1].isEmpty() && configuration[2].isEmpty())){
            Hanoi fils = new Hanoi(configuration);
            fils.configuration[2].add(0, fils.configuration[1].get(0));
            fils.configuration[1].remove(0);
            listeFils.add(fils);
        }
        if ((!configuration[2].isEmpty() && !configuration[0].isEmpty() && configuration[2].get(0)<configuration[0].get(0)) || (!configuration[2].isEmpty() && configuration[0].isEmpty())){
            Hanoi fils = new Hanoi(configuration);
            fils.configuration[0].add(0, fils.configuration[2].get(0));
            fils.configuration[2].remove(0);
            listeFils.add(fils);
        }
        if ((!configuration[2].isEmpty() && !configuration[1].isEmpty() && configuration[2].get(0)<configuration[1].get(0)) || (!configuration[2].isEmpty() && configuration[1].isEmpty())){
            Hanoi fils = new Hanoi(configuration);
            fils.configuration[1].add(0, fils.configuration[2].get(0));
            fils.configuration[2].remove(0);
            listeFils.add(fils);
        }
        return listeFils;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hanoi hanoi = (Hanoi) o;
        return Arrays.deepEquals(configuration, hanoi.configuration);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(configuration);
    }
}

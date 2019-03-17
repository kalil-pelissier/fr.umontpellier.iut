package fr.umontpellier.iut.exo4;

import java.util.ArrayList;
import java.util.Arrays;

public class Taquin implements JeuPuzzle {
    private int[][] configuration;

    public Taquin(int[][] configuration) {
        this.configuration = configuration;
    }

    public Taquin(Taquin t){
        this.configuration = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.configuration[i][j] = t.configuration[i][j];
            }
        }
    }

    public Taquin() {
        this(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}});
    }

    public boolean estGagnant() {
        int[][] solution = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        return (Arrays.deepEquals(configuration, solution));
    }

    @Override
    public String toString() {
        String str = "+-------+\n";
        for (int i=0; i<3; i++){
            str += "| ";
            for (int j=0; j<3; j++){
                if (this.configuration[i][j] == 0){
                    str += "  ";
                }
                else{
                    str += this.configuration[i][j] + " ";
                }
            }
            str +=  "|\n";
        }
        str += "+-------+\n";
        return (str);
    }

    public ArrayList<JeuPuzzle> genererFils() {
        ArrayList<JeuPuzzle> listeFils = new ArrayList<>();
        boolean trouve = false;
        int zi = 0;
        int zj = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.configuration[i][j] == 0){
                    zi = i;
                    zj = j;
                }
            }
        }

        if (zi != 0){
            Taquin fils = new Taquin(this);
            fils.configuration[zi][zj] = fils.configuration[zi-1][zj];
            fils.configuration[zi-1][zj] = 0;
            listeFils.add(fils);
        }
        if (zi != 2){
            Taquin fils = new Taquin(this);
            fils.configuration[zi][zj] = fils.configuration[zi+1][zj];
            fils.configuration[zi+1][zj] = 0;
            listeFils.add(fils);
        }
        if (zj != 0){
            Taquin fils = new Taquin(this);
            fils.configuration[zi][zj] = fils.configuration[zi][zj-1];
            fils.configuration[zi][zj-1] = 0;
            listeFils.add(fils);
        }
        if (zj != 2){
            Taquin fils = new Taquin(this);
            fils.configuration[zi][zj] = fils.configuration[zi][zj+1];
            fils.configuration[zi][zj+1] = 0;
            listeFils.add(fils);
        }
        return listeFils;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taquin taquin = (Taquin) o;
        return Arrays.deepEquals(configuration, taquin.configuration);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(configuration);
    }
}

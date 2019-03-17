import java.util.ArrayList;
import java.util.Arrays;

public class Taquin implements JeuPuzzle{

    private int[][] configuration;

    public Taquin(int[][] configuration) {
        this.configuration = configuration;
    }

    public Taquin(Taquin t) {
        this.configuration = new int[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                this.configuration[i][j] = t.configuration[i][j];
            }
        }
    }

    public Taquin() {
        this.configuration = (new int [][]{{0,1,2},{3,4,5},{6,7,8}});
    }

    public int[][] getConfiguration() {
        return configuration;
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

    @Override
    public String toString() {
        String affichage = "\n+-------+\n";
                for(int i=0; i<3; i++) {
                    affichage = affichage+"| ";
                    for(int j=0; j<3; j++) {
                        if(configuration[i][j] == 0){
                            affichage = affichage +"  ";
                        }
                        else {
                            affichage = affichage+configuration[i][j]+" ";
                        }
                    }
                    affichage = affichage+"|\n";
                }
                affichage = affichage+"+-------+\n";
                return affichage;
    }

    public boolean estGagnant() {
        int[][] sol = (new int [][]{{1,2,3},{4,5,6},{7,8,0}});
        Taquin solution = new Taquin(sol);
        if(!this.equals(solution)) {
            return false;
        }
        return true;
    }

    public ArrayList<JeuPuzzle> genererFils() {
        ArrayList<JeuPuzzle> listFils = new ArrayList<>();
        int zi = 0;
        int zj = 0;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                if(configuration[i][j]==0) {
                    zi = i;
                    zj = j;
                }
            }
        }
        if(zi > 0) {
            Taquin fils = new Taquin(this);
            fils.configuration[zi][zj] = fils.configuration[zi-1][zj];
            fils.configuration[zi-1][zj] =0;
            listFils.add(fils);
        }
        if(zi < 2) {
            Taquin fils = new Taquin(this);
            fils.configuration[zi][zj] = fils.configuration[zi+1][zj];
            fils.configuration[zi+1][zj] =0;
            listFils.add(fils);
        }
        if(zj > 0) {
            Taquin fils = new Taquin(this);
            fils.configuration[zi][zj] = fils.configuration[zi][zj-1];
            fils.configuration[zi][zj-1] =0;
            listFils.add(fils);
        }
        if(zj < 2) {
            Taquin fils = new Taquin(this);
            fils.configuration[zi][zj] = fils.configuration[zi][zj+1];
            fils.configuration[zi][zj+1] =0;
            listFils.add(fils);
        }
        return listFils;
    }


}

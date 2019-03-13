public class App {
    public static void main(String[] args) {
       /* int[][] tconf1;
        int[][] tconf2;
        tconf1 = new int[][]{{0,1,2},{4,5,3},{7,8,6}};
        tconf2 = new int[][]{{1,2,3},{4,5,6},{7,8,0}};
        Taquin t1 = new Taquin(tconf1);
        Taquin t2 = new Taquin(tconf2);
        Couple c1 = new Couple(t1, null);
        Contexte cont1 = new Contexte(t1);
        Contexte cont2 = new Contexte(t2);

        cont1.resoudre();
        System.out.println(cont1);*/


       Taquin t = new Taquin(new int[][]{{1,2,3},{4,0,6},{7,5,8}});
        Contexte c = new Contexte(t);
        c.resoudre();
        System.out.println(c);
    }
}

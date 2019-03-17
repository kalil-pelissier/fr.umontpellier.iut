package fr.umontpellier.iut.exo4;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(4);
        Contexte contexte = new Contexte(hanoi);
        contexte.resoudre();
        ArrayList<JeuPuzzle> sol = contexte.getSolution();
        for (int i = 0; i < sol.size(); i++) {
            System.out.println(sol.get(i).toString());
        }
    }
}

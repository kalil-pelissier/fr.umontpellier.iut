package fr.umontpellier.iut.exo4;

import java.util.ArrayList;

public interface JeuPuzzle {
    public boolean estGagnant();
    public ArrayList<JeuPuzzle> genererFils();
}
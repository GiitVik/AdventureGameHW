package org.example.MainGame;
import org.example.Players.Hero;

interface Purchaseable {
    void purchase(Hero hero);
    public String getName();
    int getCost();
    boolean canAfford(int gold);
}

package org.example.MainGame;

import org.example.Players.Hero;

public class Shop implements Purchaseable {
    private int cost;
    @Override
    public void purchase(Hero hero) {
        System.out.println(hero.getName() + " buys an item!");
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public boolean canAfford(int gold) {
        if (gold >= cost) {
            System.out.println("Can't afford this item!");
            return true;
        }
        return false;
    }
}

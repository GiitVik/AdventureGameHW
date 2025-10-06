package org.example.MainGame;

import org.example.Players.Hero;
import org.example.MainGame.Item;
import org.example.Utils.InputReader;

public class Shop implements Purchaseable {
    Shop(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
    private String name;
    private int cost;

    @Override
    public void purchase(Hero hero) {
        if (canAfford(hero.getGold())) {
            System.out.println(hero.getName() + " buys a " + this.name + "!");
            hero.loseGold(cost);
            hero.addItemToList(new Item(this.name, this.cost));
            System.out.println(this.name + " has been added to inventory.");
        }
        else {
            canAfford(hero.getGold());
        }
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public boolean canAfford(int gold) {
        if (gold <= cost) {
            System.out.println("Can't afford this item!");
            return false;
        }
        return true;
    }
}

package org.example;
import org.example.Players.Hero;
import org.example.Players.Weapon;
import org.example.MainGame.Game;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*Game game = new Game();
        game.start();*/
        Hero hero = new Hero("Jakob", 75, 100,new Weapon("Hands", 10, 0));
        hero.setLevel(1); // Characters.Hero is instantiated
        hero.setGold(25);
        hero.setMaxLevel(10);
        startGame(hero);
    }

    public static void startGame(Hero hero) {
        Game game = new Game();
        game.worldMenu(hero);
    }
}
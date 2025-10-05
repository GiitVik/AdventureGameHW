package org.example;
import org.example.Players.Hero;
import org.example.Players.Weapon;
import org.example.MainGame.Game;
import org.example.Utils.InputReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static boolean endGame = false;
    public static void main(String[] args) {
        /*Game game = new Game();
        game.start();*/
        menu();
    }
    public static void menu() {
        while(!endGame) {
            System.out.println("----------");
            InputReader reader = new InputReader();
            System.out.println("Adventure game menu");
            System.out.println("1. Start the game!");
            System.out.println("2. End game");
            int number = reader.readInt("Select your choice with number");
            switch (number) {
                case 1:
                    startGame();
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    endGame = true;
                    break;
            }
        }
    }
    public static void startGame() {
        System.out.println("-------------");
        System.out.println("Welcome to the game!");
        Hero hero = new Hero("Jakob", 75, 100,new Weapon("Sword", 40, 0));
        hero.setLevel(1); // Characters.Hero is instantiated
        hero.setGold(25);
        hero.setMaxLevel(10);
        Game game = new Game();
        game.states(hero);
    }
}
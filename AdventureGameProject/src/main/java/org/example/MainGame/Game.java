package org.example.MainGame;

import org.example.Players.Boss;
import org.example.Players.Enemy;
import org.example.Players.Hero;
import org.example.Players.Weapon;
import org.example.Utils.Helper;
import org.example.Utils.InputReader;

public class Game {
    public boolean isEncounter() {
        return false;
    }

    private int number;
    private int randomNumber;
    // Method that handles choices for the player in the world
    public void worldMenu(Hero hero) {
        InputReader reader = new InputReader();
        Helper helper = new Helper();
        System.out.println("Welcome to the game!");
        if (isEncounter()) {}
        System.out.println("Select one of the following: ");
        System.out.println("1. Battle");
        System.out.println("9. ");
        number = reader.readInt("Select your choice with number");

        while(hero.isAlive()) {
            switch (number) {
                case 1:
                    System.out.println("Test battle");
                    startBattle(hero);
                    break;
                case 9:

                    break;
            }
        }
    }

    public void startBattle(Hero hero) {
        //isBattling = true;
        //escapeValue = 0;
        playerTurn = 1;
        //Boss boss = new Boss("Balrog", 100, 100,new Weapon("Mace", 40, 0), 100, 200);
        //Enemy goblin = new Enemy("Goblin", 50, 50, new Weapon("Club", 15, 0), 25, 50);
        randomizeEnemy(hero);

        // Enter battle menu if both objects have health
    }

    private int playerTurn;
    public void battleMenuEnemyBattle(Hero hero, Enemy enemy) {
        System.out.println("You're fighting a: " + enemy.getName());
        InputReader reader = new InputReader();
        while (hero.isAlive() && enemy.isAlive()) {
            System.out.println("Battle choices: ");
            System.out.println("1. Attack");
            number = reader.readInt("Select your choice with number");
            switch (number) {
                case 1:
                    hero.attack(enemy);
                    enemy.attack(hero);
                    break;
                case 2:
                    break;
            }
        }
    }
    public void battleMenuBossBattle(Hero hero, Boss boss) {
        System.out.println("You're fighting a: " + boss.getName());
        InputReader reader = new InputReader();
        while (hero.isAlive() && boss.isAlive()) {
            System.out.println("Battle choices: ");
            System.out.println("1. Attack");
            number = reader.readInt("Select your choice with number");
            switch (number) {
                case 1:
                    hero.attack(boss);
                    boss.attack(hero);
                    break;
                case 2:
                    break;
            }
        }
    }

    private int randomNum;
    private boolean isBossBattle;

    public void randomizeEnemy(Hero hero) {
        Game game = new Game();
        Helper helper = new Helper();
        randomNum = helper.generateRandomNumber();
        System.out.println("Random Number: " + randomNum);
        if (randomNum > 0 && randomNum <= 70) {
            battleMenuEnemyBattle(hero, new Enemy("Goblin", 50, 50, new Weapon("Club", 15, 0), 25, 50));
        }
        else if (randomNum > 70 && randomNum <= 90) {
        }
        else if (randomNum > 90 && randomNum <= 100) {
            battleMenuBossBattle(hero, new Boss("Balrog", 100, 100,new Weapon("Mace", 40, 0), 100, 200));
            //Boss enemy
        }
    }
}

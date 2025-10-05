package org.example.MainGame;

import org.example.Players.Boss;
import org.example.Players.Enemy;
import org.example.Players.Hero;
import org.example.Players.Weapon;
import org.example.Utils.Helper;
import org.example.Utils.InputReader;

public class Game {
    public boolean isEncounter = false;

    private int number;
    private int randomNumber;
    // Method that handles choices for the player in the world
    public void states(Hero hero) {
        isBattling = false;
        Helper helper = new Helper();
        while (!isGameOver(hero)) {
            while (hero.isAlive() && !isBattling) {
                hero.lvlUp();
                InputReader reader = new InputReader();
                System.out.println("Select one of the following: ");
                System.out.println("1. Battle");
                System.out.println("2. Character stats");
                System.out.println("3. Shop");
                System.out.println("9. Kill player");
                number = reader.readInt("Select your choice with number");
                {switch (number) {
                    case 1:
                        startBattle(hero);
                        break;
                    case 2:
                        hero.playerStats(hero);
                        break;
                    case 3:
                        break;
                    case 9:
                        hero.takeDamage(10000);
                        break;
                    }
                }
            }
        }
    }

    public boolean isBattling;
    //Starts battle, jumps between randomize enemy, which initiates a fight if the right condition is triggered,
    //or goes back to the "regular states", which is when you're not fighting.
    //Basically randomizeenemy (chance to enter combat) or go back to states(after fight is won, or
    //if no random encounter is activated.
    public void startBattle(Hero hero) {
        randomizeEnemy(hero);
        states(hero);
        // Enter battle menu if both objects have health
    }
    //Switch menu that manages regular enemy battles
    public void battleMenuEnemyBattle(Hero hero, Enemy enemy) {
        System.out.println("You're fighting a: " + enemy.getName());
        while (hero.isAlive() && enemy.isAlive()) {
            InputReader reader = new InputReader();
            System.out.println("Battle choices: ");
            System.out.println("1. Attack");
            number = reader.readInt("Select your choice with number");
            switch (number) {
                case 1:
                    hero.attack(enemy);
                    if (enemy.isAlive())
                        enemy.attack(hero);
                    break;
                case 2:
                    break;
            }
        }

        if (!enemy.isAlive()) {
            System.out.println(enemy.getName() + " is DEAD");
            xpReward(hero, enemy.getXpReward());
            goldReward(hero, enemy.getGoldReward());
            isBattling = false;
        }
    }
    //Alternative switch menu for boss battle
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
                    if (boss.isAlive()) {
                        boss.attack(hero);
                    }
                    break;
                case 2:
                    break;
            }
        }
        isBattling = false;
        System.out.println("Isbattling: " + isBattling);
    }

    private int randomNum;
    private boolean isBossBattle;

    public boolean isGameOver(Hero hero) {
        if (!hero.isAlive())
        {
            System.out.println(hero.getName() + " is dead.");
            System.out.println("Game over!");
            return true;
        }
        return false;
    }

    public void xpReward(Hero hero, int xp) {
        hero.gainXp(xp);
        System.out.println("------------");
    }

    public void goldReward(Hero hero, int gold) {
        hero.gainGold(gold);
        System.out.println("------------");
    }

    // Decides a specific outcome for the player, like battling enemy, boss or nothing happens.
    public void randomizeEnemy(Hero hero) {
        Game game = new Game();
        Helper helper = new Helper();
        randomNum = helper.generateRandomNumber();
        if (randomNum > 0 && randomNum <= 70) {
            isBattling = true;
            battleMenuEnemyBattle(hero, new Enemy("Goblin", 50, 50, new Weapon("Club", 5, 0), 50, 50));
        }
        else if (randomNum > 70 && randomNum <= 90) {
            System.out.println("Nothing here!");
            isBattling = false;
        }
        else if (randomNum > 90 && randomNum <= 100) {
            isBattling = true;
            battleMenuBossBattle(hero, new Boss("Balrog", 100, 100,new Weapon("Mace", 25, 0), 1000, 100));
        }
    }
}

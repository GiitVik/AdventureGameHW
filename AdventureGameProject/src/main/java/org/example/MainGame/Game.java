package org.example.MainGame;

import org.example.Players.Boss;
import org.example.Players.Enemy;
import org.example.Players.Hero;
import org.example.Players.Weapon;
import org.example.Utils.Helper;
import org.example.Utils.InputReader;
import org.example.MainGame.Shop;


//This is the game class. This is where all game events occur outside of menu, which occurs in main.
public class Game {
    private boolean isEncounter;
    private boolean isShopping;
    private boolean triggerGameOver;
    private int number;
    private int randomNumber;
    ItemList items = new ItemList();
    // Method that handles choices for the player in the world
    public void states(Hero hero) {
        triggerGameOver = false;
        isBattling = false;
        Helper helper = new Helper();
        while (!isGameOver(hero)) {
            while (hero.isAlive() && !isBattling && !hero.isLevelMax() && !triggerGameOver) {
                hero.lvlUp();
                InputReader reader = new InputReader();
                System.out.println("Select one of the following: ");
                System.out.println("1. Battle");
                System.out.println("2. Character stats");
                System.out.println("3. Shop");
                System.out.println("4. Level up to max");
                System.out.println("5. Display all items");
                System.out.println("6: Battle boss");
                System.out.println("7: End game");
                System.out.println("8. Kill player");
                number = reader.readInt("Select your choice with number");{
                    switch (number)
                    {
                        case 1:
                            startBattle(hero);
                            break;
                        case 2:
                            hero.playerStats(hero);
                            break;
                        case 3:
                            isShopping = true;
                            shopMenu(hero);
                            break;
                        case 4:
                            hero.gainXp(10000);
                            break;
                        case 5:
                            hero.allItemsOnList();
                            break;
                        case 6:
                            battleMenuBossBattle(hero, new Boss("Balrog", 100, 100,new Weapon("Mace", 25, 0), 1000, 100));
                            break;
                        case 7:
                            triggerGameOver = true;
                            break;
                        case 8:
                            hero.takeDamage(100000);
                            break;
                    }
                }
            }
        }
    }

    public void shopMenu(Hero hero) {
        isShopping = true;
        Shop shopItem1 = new Shop("Potion", 10);
        //Item potion = new Item("Potion", 50);
        System.out.println("Welcome to the shop!");
        System.out.println("Here are the available items in stock: ");
        System.out.println("Potion");

        while (isShopping) {
            InputReader reader = new InputReader();
            System.out.println("Your balance is: " + hero.getGold());
            System.out.println("Select one of the following: ");
            System.out.println("1. Buy item");
            System.out.println("2. Leave store");
            int number = reader.readInt("Select your choice with number");
            switch (number) {
                case 1:
                    if (shopItem1.canAfford(hero.getGold()))
                        shopItem1.purchase(hero);
                        break;
                case 2:
                    isShopping = false;
                    break;
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
        System.out.println("----------");
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
        System.out.println("----------");
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

        if (!boss.isAlive()) {
            System.out.println(boss.getName() + " is DEAD");
            xpReward(hero, boss.getXpReward());
            goldReward(hero, boss.getGoldReward());
            isBattling = false;
        }
    }

    private int randomNum;
    private boolean isBossBattle;

    //If game is over, depending on if hero is alvie or if hero is max level.
    public boolean isGameOver(Hero hero) {
        if (!hero.isAlive())
        {
            System.out.println(hero.getName() + " is dead.");
            System.out.println("Game over!");
            return true;
        }
        else if (hero.isLevelMax())
        {
            return true;
        }
        else if (triggerGameOver)
        {
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
        // Picks random number between 0 and 70
        if (randomNum > 0 && randomNum <= 70) {
            isBattling = true;
            battleMenuEnemyBattle(hero, new Enemy("Goblin", 30, 30, new Weapon("Club", 10, 0), 50, 50));
        }
        // Picks random number between 70 and 90
        else if (randomNum > 70 && randomNum <= 90) {
            System.out.println("-------------");
            System.out.println("Nothing here!");
            isBattling = false;
        }
        // and finally picks random number between 90 and 100
        else if (randomNum > 90 && randomNum <= 100) {
            isBattling = true;
            battleMenuBossBattle(hero, new Boss("Balrog", 100, 100,new Weapon("Mace", 25, 0), 1000, 100));
        }
    }
}

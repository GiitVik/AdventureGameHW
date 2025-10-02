package MainGame;
import Characters.Hero; import Characters.Enemy; import Characters.Boss; import Characters.Weapon;
import Utils.InputReader;

import javax.management.monitor.MonitorSettingException;
import java.util.Scanner;

public class Game {
    //Game start class, instantiates hero values
    public void start() {
        System.out.println("----------");
        Hero hero = new Hero("Jakob", 75, 100,new Weapon("Hands", 10, 0));
        hero.setLevel(1); // Characters.Hero is instantiated
        hero.setGold(25);
        hero.setMaxLevel(10);

        worldGame(hero);
    }

    public boolean isEncounter() {
        return false;
    }

    // Method that instantiates other values for objects instantiated in the "world" area
    //Basically the state when you're not fighting
    public void worldGame(Hero hero) {
        Boss boss = new Boss("Balrog", 100, 100,new Weapon("Mace", 40, 0), 100, 200);
        Enemy goblin = new Enemy("Goblin", 50, 50, new Weapon("Club", 15, 0), 25, 50);

        while (!hero.isLevelMax()) {
            for (int i = 0; i < hero.getMaxLevel(); i++) {
                hero.gainXp(100);
                hero.lvlUp();
            }
        }
        worldMenu(hero);
    }
    private int number;
    // Method that handles choices for the player in the world
    public void worldMenu(Hero hero) {
        InputReader reader = new InputReader();
        number = reader.readInt("Select your choice with number");

        switch (number) {
            case 1:
                System.out.println("Test battle");
                startBattle(hero);
                break;
            case 9:
                break;
        }
    }

    public void startBattle(Hero hero) {
        //isBattling = true;
        //escapeValue = 0;
        playerTurn = 1;
        Boss boss = new Boss("Balrog", 100, 100,new Weapon("Mace", 40, 0), 100, 200);
        Enemy goblin = new Enemy("Goblin", 50, 50, new Weapon("Club", 15, 0), 25, 50);

        System.out.println("---------");
        System.out.println("Battle start!");
        System.out.println("You're fighting a " + goblin.getName());

        // Enter battle menu if both objects have health
        while (hero.isAlive() && goblin.isAlive())
        {
            battleMenu(hero, goblin);
        }
    }

    private int playerTurn;
    public void battleMenu(Hero hero, Characters.Enemy enemy) {
        InputReader reader = new InputReader();
        System.out.println("Battle choices: ");
        System.out.println("1. Attack");
        number = reader.readInt("Select your choice with number");

        switch (number) {
            case 1:
                hero.attack(enemy);
                enemy.attack(hero);
                break;
        }
    }
}

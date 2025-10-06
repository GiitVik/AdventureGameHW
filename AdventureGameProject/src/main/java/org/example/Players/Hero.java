package org.example.Players;

import org.example.MainGame.Item;
import org.example.MainGame.ItemList;

import java.util.ArrayList;
import java.util.List;

//Hero class, this is where the player stores data like name, hp, weapon damage,
//but also can check when the hero levels up, when the enemy dies, gain experience points from battles.
public class Hero extends Character {
    private List<Item> itemList = new ArrayList<>();
    private int xp;
    private int level;
    private int maxLevel;
    private int gold;
    //Hero constructor
    public Hero(String name, int hp, int maxHp, Weapon weapon) {
        super(name, hp, maxHp, weapon);
    }
    @Override
    public void takeDamage(int damage) {
        System.out.println(super.name + " takes damage!");
        System.out.println(super.name + "'s health was: " + super.hp);
        super.hp -= damage;
        System.out.println(super.name + " now has " + hp + " health points");
        System.out.println("-------------");
    }
    //Displays character status
    public void playerStats(Hero hero) {
        System.out.println("-------------");
        System.out.println("Character name: " + hero.getName());
        System.out.println("Character level: " + hero.level);
        System.out.println("Character hp: " + hero.hp);
        System.out.println("Character damage: " + hero.weapon.getDamage());
        System.out.println("Character xp: " + hero.getXp());
        System.out.println("Character gold: " + hero.getGold());
        System.out.println("-------------");
    }
    // Method for hero to attack target (character)
    public void attack(Character character) {
        System.out.println("-------------");
        System.out.println(super.name + " attacks!");
        System.out.println(character.name + "'s health was: " + character.hp);
        System.out.println(character.name + " took " + super.weapon.getDamage() + " points in damage.");
        character.hp -= super.weapon.getDamage();
        if (character.hp <= 0) {
            character.hp = 0;
        }
        System.out.println(character.name + " now has " + character.hp + " health points");
        System.out.println("-------------");
    }
    // Method to check if hero is alive
    @Override
    public boolean isAlive() {
        if (super.hp <= 0) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public void gainXp(int xp) {
        if (this.level < this.maxLevel) {
            System.out.println("Gained experience: " + xp + " xp.");
            System.out.println("Xp increased from: " + this.xp + " xp.");
            this.xp += xp;
            System.out.println(" to: " + this.xp + " xp.");
            lvlUp();
        }
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void gainGold(int gold) {
        System.out.println("Gained gold: " + gold + "g");
        System.out.println("Gold increased from: " + this.gold + " g.");
        this.gold += gold;
        System.out.println(" to: " + this.gold + " g.");
    }

    public void loseGold(int gold) {
        System.out.println("Lost gold: " + gold + "g");
        System.out.println("Gold decreased from: " + this.gold + " g.");
        this.gold -= gold;
        System.out.println(" to: " + this.gold + " g.");
    }

    public int getXp() {
        return xp;
    }

    public void getLevel() {
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public void levelStatus() {
        System.out.println(super.name + " is level: " + this.level);
        System.out.println("Current level: " + this.level);
        System.out.println("Max level: " + this.maxLevel);
    }

    private int levelUpCondition;

    public int getLevelUpCondition() {
        return levelUpCondition;
    }

    public void setLevelUpCondition(int levelUpCondition) {
        this.levelUpCondition = levelUpCondition;
    }

    public boolean isLevelMax() {
        if (this.level == this.maxLevel) {
            System.out.println("You won! " + super.name + " is at level " + this.level);
            System.out.println("---------");
            return true;
        }

        return false;
    }

    public void lvlUp() {
        if (this.level == 1)
        {
            levelUpCondition = 100;
        }
        if (this.level <= this.maxLevel && this.level >= 0) {
            while (this.levelUpCondition <= xp && this.level < this.maxLevel)
            {
                System.out.println(super.name + " leveled up!");
                System.out.println("Levelup condition was: " + this.levelUpCondition);
                this.levelUpCondition += 100;
                System.out.println("Levelup condition is now: " + this.levelUpCondition);
                this.level++;
                System.out.println(super.name + " levelled up to level: " + this.level);
                System.out.println("Max hp went from: " + super.maxHp + " hp. to: ");
                super.maxHp += 20;
                System.out.println(super.maxHp + ".");
                if (super.hp <= super.maxHp) {
                    System.out.println("Restored current health to max health, from: " + super.hp);
                    super.hp = super.maxHp;
                    System.out.println("to: " + super.hp);
                }
                System.out.println("----------");
            }
        }
    }
    public void addItemToList(Item item) {
        itemList.add(item);
    }
    public void allItemsOnList() {
        System.out.println("----------");
        System.out.println("All items: ");
        System.out.println("----------");
        if (itemList.size() > 0) {
            for (Item item : itemList) {
                System.out.println("Item: " + item.getName());
            }
        }
        else if (itemList.size() == 0)
        {
            System.out.println("No items in your inventory");
        }
        System.out.println("----------");
    }
}

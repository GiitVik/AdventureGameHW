package org.example.Players;

public class Hero extends Character {
    private int xp;
    private int level;
    private int maxLevel;
    private int gold;
    public Hero(String name, int hp, int maxHp, Weapon weapon) {
        super(name, hp, maxHp, weapon);
    }
    @Override
    public void takeDamage(Character character) {
        System.out.println(super.name + " took " + character.weapon.getDamage() + " points in damage.");
        System.out.println(super.name + "'s health was: " + super.hp);
        super.hp -= character.weapon.getDamage();
        System.out.println(super.name + " now has " + hp + " health points");
        System.out.println("-------------");
    }

    public void attack(Character character) {
        System.out.println(super.name + " attacks!");
        System.out.println(character.name + "'s health was: " + character.hp);
        System.out.println(character.name + " took " + super.weapon.getDamage() + " points in damage.");
        character.hp -= super.weapon.getDamage();
        System.out.println(character.name + " now has " + character.hp + " health points");
        System.out.println("-------------");
    }

    @Override
    public boolean isAlive() {
        if (super.hp <= 0) {
            return false;
        }
        return true;
    }

    public void gainXp(int xp) {
        if (this.level < this.maxLevel) {
            System.out.println("Gained experience: " + xp);
            System.out.println("Xp increased from: " + this.xp + ".");
            this.xp += xp;
            System.out.println(" to: " + this.xp + ".");
            System.out.println("----------");
        }
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void gainGold(int gold) {
        System.out.println(super.name + " gains gold: " + gold);
        this.gold += gold;
        System.out.println("Gold count is now: " + this.gold + ".");
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
            if (this.levelUpCondition == xp) {
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
}

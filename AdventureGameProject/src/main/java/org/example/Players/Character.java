package org.example.Players;

// Abstract character class, parent to Enemy, Hero, Boss, Monster
abstract class Character {
    protected String name;
    protected int hp, maxHp;
    protected Weapon weapon;

    //Character constructor
    Character(String name, int hp, int maxHp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.weapon = weapon;
    }

    abstract void takeDamage(Character character);
    abstract void attack(Character character);
    abstract boolean isAlive();
}
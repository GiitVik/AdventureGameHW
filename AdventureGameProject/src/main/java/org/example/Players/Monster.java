package org.example.Players;

//Abstract Monster class, has variables like name, int, maxHp, weapon, xpReward and goldReward.
//xpReward and goldReward are given to the player after each battle.
abstract class Monster extends Character {
    protected int xpReward, goldReward;
    Monster(String name, int hp, int maxHp, Weapon weapon, int xpReward, int goldReward) {
        super(name, hp, maxHp, weapon);
        this.xpReward = xpReward;
        this.goldReward = goldReward;
    }
}

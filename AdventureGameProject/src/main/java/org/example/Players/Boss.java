package org.example.Players;
import org.example.Utils.Helper;

public class Boss extends Monster {
    public Boss(String name, int hp, int maxHp, Weapon weapon, int xpReward, int goldReward) {
        super(name, hp, maxHp, weapon,  xpReward, goldReward);
    }

    public String getName() {
        return name;
    }

    @Override
    public void takeDamage(Character character) {
        System.out.println(super.name + " took " + character.weapon.getDamage() + " points in damage.");
        System.out.println(super.name + "'s health was: " + super.hp);
        super.hp -= character.weapon.getDamage();
        System.out.println(super.name + " now has " + hp + " health points");
        System.out.println("-------------");
    }

    @Override
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

    private int randomInt;
    public void specialAttack(Character character) {
        Helper helper = new Helper();
        randomInt = helper.generateRandomNumber();
        System.out.println(character.name + "'s health was: " + character.hp);

        System.out.println(super.name + " used a special attack!");
        if (randomInt < 30) {
            System.out.println(character.name + " took " + super.weapon.getDamage() * 2  + " points in damage.");
            character.hp -= super.weapon.getDamage() * 2;
            System.out.println(character.name + " now has " + character.hp + " health points");
            System.out.println("-------------");
        }
        else {

        }
    }
}
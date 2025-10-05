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
    public void takeDamage(int damage) {
        System.out.println(super.name + " takes damage!");
        System.out.println(super.name + "'s health was: " + super.hp);
        super.hp -= damage;
        System.out.println(super.name + " now has " + hp + " health points");
        System.out.println("-------------");
    }
    private int randomInt;
    @Override
    public void attack(Character character) {
        Helper helper = new Helper();
        randomInt = helper.generateRandomNumber();
        //Special attack
        if (randomInt >= 0 && randomInt <= 30) {
            specialAttack(character);
        }
        //Normal attack
        else {
            System.out.println(super.name + " attacks!");
            System.out.println(character.name + "'s health was: " + character.hp);
            System.out.println(character.name + " took " + super.weapon.getDamage() + " points in damage.");
            character.hp -= super.weapon.getDamage();
            System.out.println(character.name + " now has " + character.hp + " health points");
            System.out.println("-------------");
        }
    }

    @Override
    public boolean isAlive() {
        if (super.hp <= 0) {
            super.hp = 0;
            return false;
        }
        return true;
    }

    public void specialAttack(Character character) {
        int specialAttackDamage;
        System.out.println(super.name + " used a special attack!");
        System.out.println(character.name + "'s health was: " + character.hp);
        specialAttackDamage = (super.weapon.getDamage() * 2);
        System.out.println(character.name + " took " + specialAttackDamage + " points in damage.");
        character.hp -= specialAttackDamage;
        System.out.println(character.name + " now has " + character.hp + " health points");
        System.out.println("-------------");
    }
}
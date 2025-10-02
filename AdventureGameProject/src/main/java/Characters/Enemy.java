package Characters;

public class Enemy extends Monster {
    public Enemy(String name, int hp, int maxHp, Weapon weapon, int xpReward, int goldReward) {
        super(name, hp, maxHp, weapon, xpReward, goldReward);
    }

    @Override
    void takeDamage(int damage) {
        System.out.println(super.name + " took " + damage + " points in damage.");
        System.out.println(super.name + "'s health was: " + super.hp);
        super.hp -= damage;
        System.out.println(super.name + " now has " + hp + " health points");
        System.out.println("-------------");
    }

    @Override
    void attack(Character character) {
        System.out.println(super.name + " attacks!");
        System.out.println(character.name + "'s health was: " + character.hp);
        System.out.println(character.name + " took " + super.weapon.getDamage() + " points in damage.");
        character.hp -= super.weapon.getDamage();
        System.out.println(character.name + " now has " + character.hp + " health points");
        System.out.println("-------------");
    }
}

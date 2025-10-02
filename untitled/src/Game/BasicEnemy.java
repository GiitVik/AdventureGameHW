package Game;

class BasicEnemy extends Monster {
    BasicEnemy(String name, int hp, int maxHp, Weapon weapon, int xpReward, int goldReward) {
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
    void attack(String name, int damage, int health) {
        System.out.println(super.name + " attacks!");
        System.out.println(name + "'s health was: " + health);
        System.out.println(name + " took " + damage + " points in damage.");
        health -= damage;
        System.out.println(name + " now has " + health + " health points");
        System.out.println("-------------");
    }
}

package Game;

class Boss extends Monster {
    Boss(String name, int hp, int maxHp, Weapon weapon, int xpReward, int goldReward) {
        super(name, hp, maxHp, weapon,  xpReward, goldReward);
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

    }

    void specialAttack(String name, int damage, int health) {
        //Stun player, skip turn
    }
}

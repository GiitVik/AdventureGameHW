package Characters;

public class Boss extends Monster {
    public Boss(String name, int hp, int maxHp, Weapon weapon, int xpReward, int goldReward) {
        super(name, hp, maxHp, weapon,  xpReward, goldReward);
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

    }

    @Override
    public boolean isAlive() {
        if (super.hp <= 0) {
            return false;
        }
        return true;
    }

    public void specialAttack(String name, int damage, int health) {
        //Stun player, skip turn
    }
}
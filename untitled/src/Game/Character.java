package Game;

abstract class Character {
    protected String name;
    protected int hp, maxHp;
    protected Weapon weapon;

    Character(String name, int hp, int maxHp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.weapon = weapon;
    }

    abstract void takeDamage(int damage);
    abstract void attack(String name, int damage, int health);
}

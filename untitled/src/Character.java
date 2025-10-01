abstract class Character {
    String name;
    int hp, maxHp;
    Weapon weapon;

    Character(String name, int hp, int maxHp, Weapon weapon) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.weapon = weapon;
    }

    abstract void takeDamage(int damage);
    abstract void attack(String name, int damage, int health);
}

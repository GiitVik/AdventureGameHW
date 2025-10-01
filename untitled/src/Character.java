abstract class Character {
    String name;
    int hp;
    int maxHp;
    int damage;

    Character(String name, int hp, int maxHp,int damage) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.damage = damage;
    }

    abstract void takeDamage(int damage);
    abstract void attack();
}

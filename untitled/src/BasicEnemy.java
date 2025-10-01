class BasicEnemy extends Monster{
    BasicEnemy(String name, int hp, int maxHp, int damage) {
        super(name, hp, maxHp, damage);
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
    void attack() {

    }
}

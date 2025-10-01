abstract class Monster extends Character{
    private int xpReward, goldReward;
    Monster(String name, int hp, int maxHp, Weapon weapon, int xpReward, int goldReward) {
        super(name, hp, maxHp, weapon);
        this.xpReward = xpReward;
        this.goldReward = goldReward;
    }
}

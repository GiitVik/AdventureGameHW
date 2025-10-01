class Hero extends Character{
    private int xp;
    private int level;
    private int maxLevel;
    private int gold;
    Hero(String name, int hp, int maxHp, int damage) {
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
        System.out.println("Hero attacks");
    }

    public void gainXp(int xp) {
        if (this.level < this.maxLevel) {
            System.out.println("Gained experience: " + xp);
            System.out.println("Xp increased from: " + this.xp + ".");
            this.xp += xp;
            System.out.println(" to: " + this.xp + ".");
            System.out.println("----------");
        }
    }

    public int getXp() {
        return xp;
    }

    public void getLevel() {
        this.level = level;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    public void levelStatus() {
        System.out.println(super.name + " is level: " + this.level);
        System.out.println("Current level: " + this.level);
        System.out.println("Max level: " + this.maxLevel);
    }

    private int levelUpCondition;

    public int getLevelUpCondition() {
        return levelUpCondition;
    }

    public void setLevelUpCondition(int levelUpCondition) {
        this.levelUpCondition = levelUpCondition;
    }

    public boolean isLevelMax() {
        if (this.level == this.maxLevel) {
            System.out.println("You won! Hero is at level " + this.level);
            return true;
        }

        return false;
    }

    public void lvlUp() {
        if (this.level <= this.maxLevel && this.level >= 0) {
            if (this.levelUpCondition == xp) {
                System.out.println(super.name + " leveled up!");
                System.out.println("Levelup condition was: " + this.levelUpCondition);
                this.levelUpCondition += 100;
                System.out.println("Levelup condition is now: " + this.levelUpCondition);
                this.level++;
                System.out.println(super.name + " levelled up to level: " + this.level);
                System.out.println("Max hp went from: " + super.maxHp + " hp. to: ");
                super.maxHp += 20;
                System.out.println(super.maxHp + ".");
                if (super.hp <= super.maxHp) {
                    System.out.println("Restored current health to max health, from: " + super.hp);
                    super.hp = super.maxHp;
                    System.out.println("to: " + super.hp);
                }
                System.out.println("----------");
            }
        }
    }
}

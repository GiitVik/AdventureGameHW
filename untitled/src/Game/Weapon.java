package Game;

public class Weapon {
    private String name;
    private int damage;
    private int value;

    public Weapon(String name, int damage, int value) {
        this.name = name;
        this.damage = damage;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("----------");
        Hero hero = new Hero("Jakob", 75, 100,new Weapon("Hands", 10, 0));
        hero.setLevel(1); // Hero is instantiated
        hero.setMaxLevel(10);
        mainGame(hero);
    }

    public static void mainGame(Hero hero) {
        Boss boss = new Boss("Balrog", 100, 100,new Weapon("Mace", 40, 0));
        BasicEnemy goblin = new BasicEnemy("Goblin", 50, 50, new Weapon("Club", 10, 0));

        Weapon axe = new Weapon("Axe", 30, 15);
        Weapon sword = new Weapon("Sword", 20, 10);

        while (!hero.isLevelMax()) {
            for (int i = 0; i < hero.getMaxLevel(); i++) {
                hero.gainXp(100);
                hero.lvlUp();
            }
        }

        System.out.println(goblin.hp);
        goblin.takeDamage(hero.weapon.getDamage());
        goblin.attack(hero.name, goblin.weapon.getDamage(), hero.hp);
    }
}
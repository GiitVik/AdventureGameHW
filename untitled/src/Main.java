//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("----------");
        Hero hero = new Hero("Jakob", 75, 100,20);
        hero.setLevel(1); // Hero is instantiated at level 1
        hero.setLevelUpCondition(100);
        hero.setMaxLevel(10);
        mainGame(hero);

    }

    public static void mainGame(Hero hero) {
        Boss boss = new Boss("Balrog", 100, 100,60);
        BasicEnemy goblin = new BasicEnemy("Goblin", 50, 50, 10);

        Weapon axe = new Weapon("Axe", 30, 15);
        Weapon sword = new Weapon("Sword", 20, 10);

        while (!hero.isLevelMax()) {
            for (int i = 0; i < hero.getMaxLevel(); i++) {
                hero.gainXp(100);
                hero.lvlUp();
            }
        }
    }
}
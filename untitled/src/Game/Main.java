package Game;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("----------");
        Hero hero = new Hero("Jakob", 75, 100,new Weapon("Hands", 10, 0));
        hero.setLevel(1); // Characters.Hero is instantiated
        hero.setGold(25);
        hero.setMaxLevel(10);
        mainGame(hero);
    }
    //Method for the main game, mostly added to separate some code from main
    public static void mainGame(Hero hero) {
        Boss boss = new Boss("Balrog", 100, 100,new Weapon("Mace", 40, 0), 100, 200);
        BasicEnemy goblin = new BasicEnemy("Goblin", 50, 50, new Weapon("Club", 10, 0), 25, 50);

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
        goblin.attack(hero);
        goblin.attack(boss);
        hero.gainGold(100);

    }

    public static void menu() {
        InputReader reader = new InputReader();
        System.out.println("----------");
        System.out.println("Welcome to the game! Pick one of the following choices: ");
        System.out.println("1. Test Battle");
        System.out.println("9. End game");
        System.out.println("Choice: ");
    }


}
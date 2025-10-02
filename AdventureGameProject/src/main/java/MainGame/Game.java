package MainGame;
import Characters.Hero; import Characters.Enemy; import Characters.Boss; import Characters.Weapon;

public class Game {
    public void start() {
        System.out.println("----------");
        Hero hero = new Hero("Jakob", 75, 100,new Weapon("Hands", 10, 0));
        hero.setLevel(1); // Characters.Hero is instantiated
        hero.setGold(25);
        hero.setMaxLevel(10);

        worldMenu();
    }

    public boolean isEncounter() {
        return false;
    }

    public void worldMenu() {
        int input = 0;
        while(!isEncounter()) {
            switch(input) {
                case 1:
                    break;
                case 9:
                    break;
            }
        }
    }

    public void battleMenu() {

    }

    public void shopMenu() {

    }
}

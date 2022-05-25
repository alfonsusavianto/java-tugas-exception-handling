import java.util.Random;

public class Healer extends Character {
    public Healer() {
        super(70, 10, 10);
    }

    @Override
    public boolean attack() {
        return 1 <= getRandomNumber() && getRandomNumber() <= (0.85 * 10);
    }

    public void heal() {
        setHP(getHP() + 25);
    }
}

public class Titan extends Character {
    public Titan() {
        super(0, 45, 200);
    }

    @Override
    public boolean attack() {
        return 1 <= getRandomNumber() && getRandomNumber() <= (0.4 * 10);
    }
}

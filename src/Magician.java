public class Magician extends Character{
    public Magician(){
        super(100, 60, 10);
    }

    @Override
    public boolean attack() {
        return 1 <= getRandomNumber() && getRandomNumber() <= (0.35 * 10);
    }
}
